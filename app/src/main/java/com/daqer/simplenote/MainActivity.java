package com.daqer.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ListView    viewLst;
    NotesDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new NotesDBHandler(this);
        viewLst = (ListView) findViewById(R.id.viewLst);
        printDatabase();
    }

    @Override
    protected void onResume() {
        super.onResume();
        printDatabase();
    }

    public void addBtnClick(View view){
        Intent i = new Intent(this,AddnoteActivity.class);
        startActivity(i);

    }

    //Print the database
    public void printDatabase(){

        String[] notes = dbHandler.databaseToString();
        //ListAdapter noteAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,notes);
        ListAdapter noteAdapter = new NoteAdapter(this,notes);
        viewLst = (ListView) findViewById(R.id.viewLst);
        viewLst.setAdapter(noteAdapter);
    }
}
