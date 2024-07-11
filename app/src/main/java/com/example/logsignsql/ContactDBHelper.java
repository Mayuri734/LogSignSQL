package com.example.logsignsql;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_NAME = "contacts";
    public static final String COL_NAME = "name";
    public static final String COL_PHONE = "number";

    public ContactDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_NAME + " TEXT PRIMARY KEY," +
                COL_PHONE + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean deleteContact(String name2) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = COL_NAME + "=?";
        String[] selectionArgs = {name2};
        int result = db.delete(TABLE_NAME, selection, selectionArgs);
        db.close();
        return result > 0;
    }
}


