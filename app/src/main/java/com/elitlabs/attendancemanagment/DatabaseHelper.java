package com.elitlabs.attendancemanagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASENAME = "etutionplus.db";
    public static final String TABLE_NAME = "attendance";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "name";
    public static final String COL_3 = "class";
    public static final String COL_4 = "subject";


    public DatabaseHelper(Context context){
        super(context, DATABASENAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, CLASS TEXT, SUBJECT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertAttendance(String name, String Class, String subject){

        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_2,name);
        cv.put(COL_3,Class);
        cv.put(COL_4,subject);

        long result = sqlDB.insert(TABLE_NAME, null, cv);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }


    public boolean updateAttendance(String id, String name, String Class, String subject){
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_1,id);
        cv.put(COL_2,name);
        cv.put(COL_3,Class);
        cv.put(COL_4,subject);

       sqlDB.update(TABLE_NAME, cv, "ID = ? ", new String[]{ id });
       return true;
    }


    public Integer deleteAttendance(String id){
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        return  sqlDB.delete(TABLE_NAME, "ID = ?", new String[]{ id });
    }

    public Cursor getAllData(){
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor result = sqlDB.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return result;
    }
}
