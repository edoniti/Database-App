package com.milot.example.database.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Databaza extends SQLiteOpenHelper {
	private final static String DATABASE_NAME = "databaza";
	
	
	public Databaza(Context context) {
		super(context, DATABASE_NAME, null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE tblPerson (id integer primary key autoincrement, name text);");
		db.execSQL("INSERT INTO tblPerson (name) values ('hajdari');");
		db.execSQL("INSERT INTO tblPerson (name) values ('fazlia');");
		db.execSQL("INSERT INTO tblPerson (name) values ('xhemilja');");
		db.execSQL("INSERT INTO tblPerson (name) values ('basria');");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop if exists " + DATABASE_NAME);
	}

}
