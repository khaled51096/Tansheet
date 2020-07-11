package com.example.lody.tanshet;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class search extends AppCompatActivity {
    private Button search;
    private Button back2;
    private EditText code2;
    private TextView code;
    private TextView view_serch_data;
    DBconnection database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = (Button)findViewById(R.id.search_button);
        back2 = (Button)findViewById(R.id.back2_button);
        code2 = (EditText)findViewById(R.id.code2_button);
        database = new DBconnection(this);
        code = (TextView) findViewById(R.id.code1_button);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(search.this,MainActivity.class);
                startActivity(i);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String k = code2.getText().toString();
               String h = database.searchdata1(k);
                Intent i = new Intent(search.this, search_data_view.class);
                i.putExtra("data2", h);
                startActivity(i);


            }
        });

    }
}
