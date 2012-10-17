package com.milot.example.database.example;

import java.util.LinkedList;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	Databaza db;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db = new Databaza(this);
        SQLiteDatabase d = db.getReadableDatabase();
        
        Cursor c = d.rawQuery("SELECT name FROM tblPerson", null);
        
        ContentValues cv = new ContentValues();
        cv.put("name", "Miloti");
        
        //d.insert("tblPerson", "", cv);
        //d.delete("tblPerson", "name = 'Miloti'", null);
        
        c.moveToFirst();
        
        while (!c.isAfterLast()) {
        		Log.e("A", c.getString(0));
        		c.moveToNext();
        }
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
