package codify.aimee.com.codify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Dai on 3/7/2016.
 */

//allows us to add data to our database? I'm not quite sure how to use it though, when ot detects username or password
public class DataSource {

    private SQLiteDatabase database;
    private LocalDBHelper helper;

    public DataSource(Context context)
    {
        helper = new LocalDBHelper(context);
    }

    public void open() throws SQLException
    {
        database = helper.getWritableDatabase();
    }

    public  void close()
    {
        helper.close();
    }

    public boolean insertPlay_Info (play_info p)
    {
        boolean didSucceed = false;
        try{
            ContentValues values = new ContentValues();
            values.put("player_id",p.getId());
            values.put("level",p.getLevel());
            values.put("code", p.getCode());
            values.put("language", p.getLanguage());
            values.put("points", p.getPoints());
            didSucceed = database.insert("play_info", null, values) > 0;
        }
        catch(Exception e)
        {}
        return didSucceed;
    }

    public boolean updatePlay_Info (play_info p)
    {
        boolean didSucceed=false;
        try
        {
            Long rowid = Long.valueOf(p.getId());
            ContentValues values = new ContentValues();

            values.put("level",p.getLevel());
            values.put("code", p.getCode());
            values.put("language", p.getLanguage());
            values.put("points", p.getPoints());

            didSucceed = database.update("play_info", values, "player_id=" + rowid, null) > 0;
        }
        catch(Exception e)
        {}
        return didSucceed;
    }

    public boolean deletePlay_Info(int rowID)
    {
        boolean deleted=false;

        try
        {
            deleted = database.delete("play_info", "player_id" + rowID, null)>0;
        }
        catch (Exception e)
        {}

        return deleted;
    }

    public int getLastPlay_InfoID ()
    {
        int lastID = -1;
        try
        {
            String query = "SELECT MAX(_id) from child";
            Cursor cursor = database.rawQuery(query,null);

            cursor.moveToFirst();
            lastID=cursor.getInt(0);
            cursor.close();
        }
        catch(Exception e)
        {
            lastID= -1;
        }
        return lastID;
    }
    public boolean insertUser (user p)
    {
        boolean didSucceed = false;
        try{
            ContentValues values = new ContentValues();
            values.put("user_id",p.getId());
            values.put("email", p.getEmail());
            didSucceed = database.insert("user", null, values) > 0;
        }
        catch(Exception e)
        {}
        return didSucceed;
    }

    public boolean updateUser (user p)
    {
        boolean didSucceed=false;
        try
        {
            Long rowid = Long.valueOf(p.getId());
            ContentValues values = new ContentValues();

            values.put("user_id",p.getId());
            values.put("email", p.getEmail());

            didSucceed = database.update("user", values, "user_id=" + rowid, null) > 0;
        }
        catch(Exception e)
        {}
        return didSucceed;
    }

    public boolean deleteUser(int rowID)
    {
        boolean deleted=false;

        try
        {
            deleted = database.delete("user", "user_id" + rowID, null)>0;
        }
        catch (Exception e)
        {}

        return deleted;
    }

    public int getLastUserID ()
    {
        int lastID = -1;
        try
        {
            String query = "SELECT MAX(_id) from child";
            Cursor cursor = database.rawQuery(query,null);

            cursor.moveToFirst();
            lastID=cursor.getInt(0);
            cursor.close();
        }
        catch(Exception e)
        {
            lastID= -1;
        }
        return lastID;
    }

}
