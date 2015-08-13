package pe.com.concyssa.quotilius;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // QuotesDataSource dataSource = new QuotesDataSource(this);

        Button btAlta = (Button) findViewById(R.id.btAlta);
        btAlta.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          EditText etAutor = (EditText) findViewById(R.id.etAutor);
                                          EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);

                                          QuotesReaderDbHelper conection = new QuotesReaderDbHelper(getApplicationContext());
                                          SQLiteDatabase bd = conection.getWritableDatabase();
                                          if (bd.isOpen()) {
                                              //bd.execSQL("insert into Quotes (body,author) values(\"2122\",\"0300\") ");
                                              ContentValues reg = new ContentValues();
                                              reg.put("body", etAutor.getText().toString());
                                              reg.put("author", etDescripcion.getText().toString());
                                              bd.insert("Quotes", null, reg);
                                              bd.close();
                                              Toast toast = Toast.makeText(getApplicationContext(), "Se cargaron los datos del artículo", LENGTH_SHORT);
                                              toast.show();
                                              etAutor.setText("");
                                              etDescripcion.setText("");
                                          }

                                      }
                                  }
        );

        Button btConsulta = (Button)findViewById(R.id.btconsultadescrip);

        btConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuotesReaderDbHelper conection = new QuotesReaderDbHelper(getApplicationContext());
                SQLiteDatabase bd = conection.getWritableDatabase();
                EditText etAutor = (EditText) findViewById(R.id.etAutor);
                EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);
                Cursor fila = bd.rawQuery("select  * from Quotes where author='Aristóteles'", null);
                if (fila.moveToFirst()) {
                    etAutor.setText(fila.getString(0));
                    etDescripcion.setText(fila.getString(1));

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "No se encontro el registro", LENGTH_SHORT);
                    toast.show();
                }
                bd.close();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
