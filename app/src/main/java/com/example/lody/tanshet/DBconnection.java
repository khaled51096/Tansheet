package com.example.lody.tanshet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Config;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * Created by الوطنية on 24/10/2017.
 */

public class DBconnection {

    DBinfo Dbinfo;

    public DBconnection(Context context) {

        Dbinfo = new DBinfo(context);
    }
    public String getcode1 (String code1){
        String text = "";
        SQLiteDatabase sqLiteDatabase = Dbinfo.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select code from lody ", null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            text = cursor.getString(cursor.getColumnIndex("code"));
            if (text.equals(code1))
                return "1";
            cursor.moveToNext();
        }

            return "0";


    }
    public String getcode2 (String code2){
        String text = "";
        SQLiteDatabase sqLiteDatabase = Dbinfo.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select code_ghaz from lody ", null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            text = cursor.getString(cursor.getColumnIndex("code_ghaz"));
            if (text.equals(code2))
                return "1";
            cursor.moveToNext();
        }

        return "0";


    }
    public int deletedata(String id){
        SQLiteDatabase sqLiteDatabase = Dbinfo.getWritableDatabase();
        String [] whereArgs = {id};
        String s = DBinfo.code + "=?";
        int count = sqLiteDatabase.delete(DBinfo.tableName,s,whereArgs);
        return count;

    }
    public int deletedata2(String id1){
        SQLiteDatabase sqLiteDatabase = Dbinfo.getWritableDatabase();
        String [] whereArgs = {id1};
        String s = DBinfo.UID + "=?";
        int count = sqLiteDatabase.delete(DBinfo.tableName,s,whereArgs);
        return count;

    }
    public String viewdata1(){
        SQLiteDatabase sqLiteDatabase = Dbinfo.getWritableDatabase();
        SQLiteDatabase sqLiteDatabase1 = Dbinfo.getReadableDatabase();
        String [] columns = {DBinfo.UID, DBinfo.name,DBinfo.phone_num, DBinfo.code,DBinfo.code_tan,DBinfo.code_ghaz,DBinfo.add_cus};
        Cursor cursor =sqLiteDatabase.query(DBinfo.tableName,columns,null,null,null,null,null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext())
        {
            int uid = cursor.getInt(0);
            String namee = cursor.getString(1);
            String phonee = cursor.getString(2);
            String codee = cursor.getString(3);
            String codeee = cursor.getString(4);
            String codeeee = cursor.getString(5);
            String add2 = cursor.getString(6);
            stringBuffer.append("كود العميل          :   "+uid+ "\n"  + "اسم العميل        :   "+namee+ "\n" + "رقم تلفون العميل :   "+phonee+ "\n" + "كود البرنامج        :   " +codee+ "\n" +  "كود الجهاز         :   "+codeeee+ "\n" + "كود التنشيط       :   "+codeee+"\n"  + "العنوان             :   "+add2+   "\n"+ "\n" + "***********************" +"\n" + "\n" );
        }
        return stringBuffer.toString();


    }


    public   String searchdata1(String codeflash){
        SQLiteDatabase sqLiteDatabase = Dbinfo.getWritableDatabase();
        String [] columns = {DBinfo.UID, DBinfo.name,DBinfo.phone_num, DBinfo.code,DBinfo.code_tan,DBinfo.code_ghaz,Dbinfo.add_cus};
        Cursor cursor =sqLiteDatabase.query(DBinfo.tableName,columns,DBinfo.code+" = '"+codeflash+"'",null,null,null,null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext())
        {
            int index1 = cursor.getColumnIndex(DBinfo.UID);
            int index2 = cursor.getColumnIndex(DBinfo.name);
            int index3 = cursor.getColumnIndex(DBinfo.phone_num);
            int index4 = cursor.getColumnIndex(DBinfo.code);
            int index5 = cursor.getColumnIndex(DBinfo.code_ghaz);
            int index6 = cursor.getColumnIndex(DBinfo.code_tan);
            int index7 = cursor.getColumnIndex(DBinfo.add_cus);

            String fuid = cursor.getString(index1);
            String fnamee = cursor.getString(index2);
            String fphonee = cursor.getString(index3);
            String fcodee = cursor.getString(index4);
            String fcodeeee = cursor.getString(index5);
            String fcodeee = cursor.getString(index6);
            String fadd = cursor.getString(index7);


            stringBuffer.append("كود العميل          :   "+fuid+ "\n"  + "اسم العميل        :   "+fnamee+ "\n" + "رقم تلفون العميل :   "+fphonee+ "\n" + "كود البرنامج        :   " +fcodee+ "\n" +  "كود الجهاز         :   "+fcodeeee+ "\n" + "كود التنشيط       :   "+fcodeee+ "\n" +  "العنون             :   "+fadd+  "\n" + "\n"+ "&&&&&&&&&&&&&&&&"  +"\n"  );
        }
        return stringBuffer.toString();


    }
    public   String searchdata2(String codeflash){
        SQLiteDatabase sqLiteDatabase = Dbinfo.getWritableDatabase();
        String [] columns = {DBinfo.UID, DBinfo.name,DBinfo.phone_num, DBinfo.code,DBinfo.code_tan,DBinfo.code_ghaz,Dbinfo.add_cus};
        Cursor cursor =sqLiteDatabase.query(DBinfo.tableName,columns,DBinfo.code_ghaz+" = '"+codeflash+"'",null,null,null,null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext())
        {
            int index1 = cursor.getColumnIndex(DBinfo.UID);
            int index2 = cursor.getColumnIndex(DBinfo.name);
            int index3 = cursor.getColumnIndex(DBinfo.phone_num);
            int index4 = cursor.getColumnIndex(DBinfo.code);
            int index5 = cursor.getColumnIndex(DBinfo.code_ghaz);
            int index6 = cursor.getColumnIndex(DBinfo.code_tan);
            int index7 = cursor.getColumnIndex(DBinfo.add_cus);

            String fuid = cursor.getString(index1);
            String fnamee = cursor.getString(index2);
            String fphonee = cursor.getString(index3);
            String fcodee = cursor.getString(index4);
            String fcodeeee = cursor.getString(index5);
            String fcodeee = cursor.getString(index6);
            String fadd = cursor.getString(index7);


            stringBuffer.append("كود العميل          :   "+fuid+ "\n"  + "اسم العميل        :   "+fnamee+ "\n" + "رقم تلفون العميل :   "+fphonee+ "\n" + "كود البرنامج        :   " +fcodee+ "\n" +  "كود الجهاز         :   "+fcodeeee+ "\n" + "كود التنشيط       :   "+fcodeee+ "\n" +  "العنون             :   "+fadd+  "\n" + "\n"+ "&&&&&&&&&&&&&&&&"  +"\n"  );
        }
        return stringBuffer.toString();


    }

    public long dataInsert(String cust_name, String cust_phone, String cust_code, String cust_code_tan,String cust_code_ghaz, String cust_add) {
        SQLiteDatabase sqLiteDatabase = Dbinfo.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBinfo.name, cust_name);
        contentValues.put(DBinfo.phone_num, cust_phone);
        contentValues.put(DBinfo.code, cust_code);
        contentValues.put(DBinfo.code_tan, cust_code_tan);
        contentValues.put(DBinfo.code_ghaz, cust_code_ghaz);
        contentValues.put(DBinfo.add_cus, cust_add);
        long id = sqLiteDatabase.insert(DBinfo.tableName,null,contentValues);
        return id;
    }



    static class DBinfo extends SQLiteOpenHelper {

        private static final String dataBase_Name = "tansh_db";
        private static final String tableName = "lody";
        private static final int dataBase_version = 7;
        private static final String UID = "id";
        private static final String name = "Name";
        private static final String phone_num = "phone";
        private static final String code = "code";
        private static final String code_tan = "code_tan";
        private static final String code_ghaz = "code_ghaz";
        private static final String add_cus = "add_cus";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + tableName;
        private static final String CREATE_TABLE = "CREATE TABLE " + tableName +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + name + " VARCHAR(255) , " + phone_num + " VARCHAR(255) , " + code + " VARCHAR(255) , " + code_tan + " VARCHAR(255), " + code_ghaz + " VARCHAR(255)," + add_cus + " VARCHAR(255))";

        private Context context;


        public DBinfo(Context context) {
            super(context,Environment.getExternalStorageDirectory()+File.separator+dataBase_Name,null,dataBase_version);
            this.context = context;
            try {

            }
            catch (Exception e) {

            }
           // Toast.makeText(context, "this constructor", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
                Toast.makeText(context, "OnCreate Method", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(context, "due to " + e, Toast.LENGTH_LONG).show();
            }
            try {

            }
            catch (Exception e) {

            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            try {
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);
                Toast.makeText(context, "OnUpgrade Method", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(context, "due to " + e, Toast.LENGTH_LONG).show();
            }
            try {

            }
            catch (Exception e) {

            }

        }
        public static void createApplicationFolder() {


        }


    }



}