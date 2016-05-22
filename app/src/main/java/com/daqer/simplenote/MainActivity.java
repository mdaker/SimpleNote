package com.daqer.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText titleTxt;
    EditText descTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTxt = (EditText)findViewById(R.id.titleTxt);
        descTxt = (EditText)findViewById(R.id.descTxt);
    }

    public void addBtnClick(View view){
        Intent i = new Intent(this,AddnoteActivity.class);
        startActivity(i);

    }
}
