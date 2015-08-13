package pe.com.concyssa.quotilius;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by jdiaz on 12/08/2015.
 */
public class QuotesDataSource {
    //Metainformación de la base de datos
    public static final String QUOTES_TABLE_NAME = "Quotes";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Quotes
    public static class ColumnQuotes{
        public static final String ID_QUOTES = BaseColumns._ID;
        public static final String BODY_QUOTES = "body";
        public static final String AUTHOR_QUOTES = "author";

        public ColumnQuotes() {
        }
    }

    //Script de Creación de la tabla Quotes
    public static final String CREATE_QUOTES_SCRIPT =
            "create table "+QUOTES_TABLE_NAME+"(" +
                    ColumnQuotes.ID_QUOTES+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnQuotes.BODY_QUOTES+" "+STRING_TYPE+" not null," +
                    ColumnQuotes.AUTHOR_QUOTES+" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto
    public static final String INSERT_QUOTES_SCRIPT =
            "insert into "+QUOTES_TABLE_NAME+" values(" +
                    "null," +
                    "\"El ignorante afirma, el sabio duda y reflexiona\"," +
                    "\"Aristóteles\")," +
                    "(null," +
                    "\"Hay derrotas que tienen mas dignidad que la victoria\"," +
                    "\"Jorge Luis Borges\")," +
                    "(null," +
                    "\"Si buscas resultados distintos, no hagas siempre lo mismo\"," +
                    "\"Mahatma Gandhi\")";


    private QuotesReaderDbHelper openHelper;
    private SQLiteDatabase database;

    public QuotesDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new QuotesReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

}
