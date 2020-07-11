package com.example.lody.tanshet;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.password;
import static com.example.lody.tanshet.DBconnection.DBinfo.createApplicationFolder;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText phone;
    EditText address;
    EditText codeghaz;
    Button view;
    private Button tan;
    TextView viewtext;
    Button gdeed;
    private Button delete;
    DBconnection database;
    EditText textmsg;
    EditText text2;
    EditText text3;
    EditText text4;
    private Button ser;
    double x = 0;
    double y = 0;
    double z = 0;
    String xx ="999";
    String yy ="555";
    String datx;
    static final int READ_BLOCK_SIZE = 100;
    private static final int REQUEST_RUNTIME_PERMISSION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (CheckPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            // you have permission go ahead
            createApplicationFolder();
        } else {
            // you do not have permission go request runtime permissions
            RequestPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, REQUEST_RUNTIME_PERMISSION);
        }






    codeghaz = (EditText)findViewById(R.id.editText3);
        tan = (Button)findViewById(R.id.button1);
        delete = (Button)findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, delete.class);
                startActivity(i);
            }
        });
        ser = (Button)findViewById(R.id.search3_button);
        ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,search.class);
                startActivity(i);
            }
        });
        textmsg=(EditText)findViewById(R.id.editText1);
        textmsg.setGravity(Gravity.CENTER);
        text2=(EditText)findViewById(R.id.EditText2);
        text2.setGravity(Gravity.CENTER);

        text3 = (EditText)findViewById(R.id.EditText3);
        text4 = (EditText)findViewById(R.id.EditText4);

        Button ReadBtn= (Button) findViewById(R.id.button2);
        ReadBtn.setVisibility(View.GONE);
        name = (EditText)findViewById(R.id.name_button);
        phone = (EditText)findViewById(R.id.phone_button);
        address = (EditText)findViewById(R.id.addr_button);
        view = (Button) findViewById(R.id.view_button);
        viewtext = (TextView)findViewById(R.id.viewdata_text);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(MainActivity.this,view_activity.class);
               i.putExtra("data",database.viewdata1());
                startActivity(i);


            }
        });

        database = new DBconnection(this);
        text2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String aa = text2.getText().toString();
                if (aa.equals(xx)) {
                    Toast.makeText(MainActivity.this, "هذا العميل من جوجل بلاي", Toast.LENGTH_LONG).show();
                }
                else if(aa.equals(yy)){

                    Toast.makeText(MainActivity.this, "مكاتب ادارية", Toast.LENGTH_LONG).show();

                }
                else {

                    String b = database.getcode1(aa);
                    if (b.equals("1")) {
                        Toast.makeText(MainActivity.this, "هذا الكود تم تنشيطه من قبل", Toast.LENGTH_LONG).show();
                        String h = database.searchdata1(aa);
                        Intent i = new Intent(MainActivity.this, view2.class);
                        i.putExtra("data2", h);
                        startActivity(i);
                        text2.setText("");


                    }
                }

            }
        });
        codeghaz.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String aaa = text2.getText().toString();
                String bb = codeghaz.getText().toString();
                if((aaa .equals(xx))||(aaa.equals(yy))){
                    String bbb = database.getcode2(bb);
                    if (bbb.equals("1")) {
                        Toast.makeText(MainActivity.this, "هذا الكود تم تنشيطه من قبل", Toast.LENGTH_LONG).show();
                        String h = database.searchdata2(bb);
                        Intent i = new Intent(MainActivity.this, view2.class);
                        i.putExtra("data2", h);
                        startActivity(i);
                        text2.setText("");
                        codeghaz.setText("");

                    }



                }
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((name.getText().toString().equals("")) || (phone.getText().toString().equals("")) || (text2.getText().toString().equals("") || (codeghaz.getText().toString().equals("")) || (address.getText().toString().equals(""))) )
                {
                    Toast.makeText(MainActivity.this,"من فضلك أكمل البيانات",Toast.LENGTH_LONG).show();
                }
                else {
                            try {

                                x = Double.parseDouble(text3.getText().toString());
                                y = Double.parseDouble(codeghaz.getText().toString());
                                z = x + y;
                                textmsg.setText(Double.toString(z));


                                datx = textmsg.getText().toString();
                                datx = datx.replace('E', '1');
                                datx = datx.replace('.', '2');

                                textmsg.setText(datx);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            String name1 = name.getText().toString();
                            String phone1 = phone.getText().toString();
                            String code1 = text2.getText().toString();
                            String code2 = textmsg.getText().toString();
                            String code3 = codeghaz.getText().toString();
                            String add = address.getText().toString();
                            long id = database.dataInsert(name1, phone1, code1, code2, code3, add);
                            name.setText("");
                            phone.setText("");
                            text2.setText("");
                            codeghaz.setText("");
                            address.setText("");
                        }




                }


        });
    }
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {

        switch (permsRequestCode) {

            case REQUEST_RUNTIME_PERMISSION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // you have permission go ahead
                    createApplicationFolder();
                } else {
                    // you do not have permission show toast.
                }
                return;
            }
        }
    }

    public void RequestPermission(Activity thisActivity, String Permission, int Code) {
        if (ContextCompat.checkSelfPermission(thisActivity,
                Permission)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
                    Permission)) {
            } else {
                ActivityCompat.requestPermissions(thisActivity,
                        new String[]{Permission},
                        Code);
            }
        }
    }

    public boolean CheckPermission(Context context, String Permission) {
        if (ContextCompat.checkSelfPermission(context,
                Permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }





    // Read text from file
    public void ReadBtn(View v) {
        //reading text from file

    }
    }

