package com.daqer.simplenote;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddnoteActivity extends AppCompatActivity {
    EditText    titleTxt;
    EditText    descTxt;
    NotesDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        dbHandler = new NotesDBHandler(this);
        titleTxt = (EditText) findViewById(R.id.titleTxt);
        descTxt = (EditText) findViewById(R.id.descTxt);
    }

    public void saveBtnClick(View view){
        try{
            Notes note = new Notes(titleTxt.getText().toString(),descTxt.getText().toString());
            String st = dbHandler.addNote(note);
            Toast.makeText(this,st, Toast.LENGTH_LONG).show();
            this.finish();
        }
        catch (SQLiteException e){
            Toast.makeText(this,e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }


}
