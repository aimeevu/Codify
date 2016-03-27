package codify.aimee.com.codify;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dai on 3/7/2016.
 */
public class LocalDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "noMoreNagginginator.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_USERS = "CREATE TABLE users (id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, " +
            "email VARCHAR(100) " +
            "UNIQUE,password VARCHAR(32))";

    private static final String CREATE_TABLE_PLAY_INFO = "CREATE TABLE play_info user_id INT UNSIGNED, " +
            "level INT UNSIGNED," +
            "code VARCHAR(500)," +
            "language VARCHAR(500)," +
            "points INT UNSIGNED)";

    public LocalDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase database)
    {
        database.execSQL(CREATE_TABLE_USERS);
        database.execSQL(CREATE_TABLE_PLAY_INFO);
    }

    public void onUpgrade(SQLiteDatabase database, int oldversion, int newversion)
    {
        Log.w(LocalDBHelper.class.getName(),
                "Upgrading database from " + oldversion + " to "
                        + newversion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS users");
        database.execSQL("DROP TABLE IF EXISTS play_info");
        onCreate(database);
    }
}
