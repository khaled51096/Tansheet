package com.example.lody.tanshet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class delete extends AppCompatActivity {
    private Button delete2;
    private Button back;
    private EditText id;
    private EditText id2;
    private TextView id1;
    private TextView id3;
    DBconnection database;
    String a = "999";
    String b = "555";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        delete2 = (Button) findViewById(R.id.delete1_button);
        back = (Button) findViewById(R.id.back_button);
        database = new DBconnection(this);
        id = (EditText) findViewById(R.id.editText);
        id2 = (EditText) findViewById(R.id.editText2);
        id1 = (TextView) findViewById(R.id.textView);
        id3 = (TextView) findViewById(R.id.textView2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(delete.this, MainActivity.class);
                startActivity(i);
            }
        });

    }



    public void delete3(View view) {
        String str = id.getText().toString();
        String str2 = id2.getText().toString();
        if ((str.equals(a))||(str.equals(b))) {
            id2.setVisibility(View.VISIBLE);
            id3.setVisibility(View.VISIBLE);

            int count2 = database.deletedata2(str2);

            if(id2.getText()== null || id3.getText()== null) {
                Toast.makeText(delete.this, "ادخل كود العميل", Toast.LENGTH_LONG).show();
            }
            else {

                Toast.makeText(this, "تم الحذف", Toast.LENGTH_LONG).show();

            }


        }
        else {

            int count = database.deletedata(str);
            Toast.makeText(this, "تم الحذف", Toast.LENGTH_LONG).show();
        }
    }
}



