package com.example.lody.tanshet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class view2 extends AppCompatActivity {
    DBconnection database;
    TextView viewtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        viewtext = (TextView)findViewById(R.id.viewdata_text1);
        String data = getIntent().getStringExtra("data2");
        viewtext.setText(data);


    }
}

