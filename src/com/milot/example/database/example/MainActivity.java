package com.milot.example.database.example;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ListActivity implements OnClickListener {
	
	List<String> lista = new ArrayList<String>();
	Databaza db;
	EditText editTekst;
	Button butoni;
	SQLiteDatabase d;
	ArrayAdapter<String> adapteri;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db = new Databaza(this);
        d = db.getReadableDatabase();
        
        butoni = (Button) findViewById(R.id.butoni);
        editTekst = (EditText) findViewById(R.id.editTekst);
        
        butoni.setOnClickListener(this);
        
        refreshData();

        adapteri = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        setListAdapter(adapteri);
    }
    
    private void refreshData()
    {
    	lista.clear();
    	Cursor c = d.rawQuery("SELECT name FROM tblPerson", null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
        	lista.add(c.getString(0));
        	c.moveToNext();
        }
                
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		if(v == butoni)
		{
	        ContentValues cv = new ContentValues();
	        cv.put("name", editTekst.getText().toString());
	        d.insert("tblPerson", "", cv);
	        refreshData();
	        adapteri.notifyDataSetChanged();
		}
	}
}