package com.example.lody.tanshet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class view_activity extends AppCompatActivity {
    DBconnection database;
    TextView viewtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activity);
        String data = getIntent().getStringExtra("data");
        viewtext = (TextView)findViewById(R.id.viewdata_text);
        viewtext.setText(data);

    }
}
