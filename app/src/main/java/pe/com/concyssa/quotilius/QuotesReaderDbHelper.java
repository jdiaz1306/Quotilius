package pe.com.concyssa.quotilius;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jdiaz on 12/08/2015.
 */
public class QuotesReaderDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Quotes.db";
    public static final int DATABASE_VERSION = 1;


    public QuotesReaderDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    //Crear la tabla Quotes
        db.execSQL(QuotesDataSource.CREATE_QUOTES_SCRIPT);
        //Insertar registros iniciales
        //db.execSQL(QuotesDataSource.INSERT_QUOTES_SCRIPT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
