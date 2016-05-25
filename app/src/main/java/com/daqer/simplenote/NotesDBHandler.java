package com.daqer.simplenote;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NotesDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "simpleNotesDB.db";
    private static final String TABLE_NOTES = "notes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "_title";
    private static final String COLUMN_DESCRIPTION = "_description";
    private static final String COLUMN_DATE = "_date";


    //Constructor for Handler
    public NotesDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static Context context_m;

    //OnCreate & OnUpgrade Methods
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String query = "CREATE TABLE " + TABLE_NOTES + "(" +
                    COLUMN_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT,  " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_DATE + " DATETIME " +
                    ");";

            db.execSQL(query);

            //db.execSQL("drop table notes");
        }catch (SQLiteException e){
            //Toast.makeText(context_m, "Exception", Toast.LENGTH_LONG);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Once if you want to upgrade structure of database like alter or drop table
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NOTES);
        onCreate(db);

    }

    // Add a new row to the database
    public String addNote(Notes note){
        try{
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, note.get_title());
        values.put(COLUMN_DESCRIPTION, note.get_description());
        values.put(COLUMN_DATE,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NOTES, null, values);
        db.close();
            return "Saved Successfully....";
        }
        catch (SQLiteException e){
            return e.getMessage().toString();
        }
    }

    // Delete a product from database
    public void deleteNote(String id){
        SQLiteDatabase db  = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NOTES + " WHERE " + COLUMN_ID + "=\"" + id + "\";");
    }

    //Print records as string
    public String[] databaseToString(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NOTES + " WHERE 1 ORDER BY " + COLUMN_DATE + " DESC";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        String[] array = new String[c.getCount()];
        int i = 0;
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("_title")) != null) {
                //dbString = c.getString(c.getColumnIndex("_title"));
                String uname = c.getString(c.getColumnIndex("_title"));
                array[i] = uname;
                i++;

            }
            c.moveToNext();
        }
        db.close();
        return array;
    }
}

