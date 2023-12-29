package com.example.sepmproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TABLE_USERDETAILS = "Userdetails";
    private static final String TABLE_ADMIN = "Admin";
    private static final String TABLE_ORDERS = "Orders";
    private static final String TABLE_PRODUCTS = "Products";
    private static final String TABLE_SHELTER = "Shelter";





    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSOWRD = "password";

    private static final String KEY_PID = "Pid";
    private static final String KEY_PNAME = "Pname";
    private static final String KEY_STOCK = "Stock";

    private static final String KEY_NO = "ContactNumber";
    private static final String KEY_DATE_TIME = "DateTime";

    private static final String KEY_APP_NO = "AppNo";
    private static final String KEY_STATUS = "Status";



    private static final String CREATE_TABLE_SHELTER = "CREATE TABLE " + TABLE_SHELTER + "(" + KEY_APP_NO + " TEXT ," + KEY_USERNAME + " TEXT ," + KEY_NO + " TEXT ," + KEY_DATE_TIME + " TEXT ," + KEY_STATUS + " INTEGER " + ")";

    private static final String CREATE_TABLE_ORDERS = "CREATE TABLE " + TABLE_ORDERS + "(" + KEY_USERNAME + " TEXT , " + KEY_NO + " TEXT ," + KEY_PNAME + " TEXT ," + KEY_DATE_TIME + " TEXT " + ")";

    private static final String CREATE_TABLE_PRODUCTS = "CREATE TABLE " + TABLE_PRODUCTS + "(" + KEY_PID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + KEY_PNAME + " TEXT ," + KEY_STOCK +" INTEGER " +")";




    private static final String CREATE_TABLE_USERDETAILS = "CREATE TABLE " + TABLE_USERDETAILS + "(" + KEY_USERNAME + " TEXT ," + KEY_PASSOWRD + " TEXT" + ")";


    private static final String CREATE_TABLE_ADMIN = "CREATE TABLE " + TABLE_ADMIN + "(" + KEY_USERNAME + " TEXT ," + KEY_PASSOWRD + " TEXT" + ")";

    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERDETAILS);
        db.execSQL(CREATE_TABLE_PRODUCTS);
        db.execSQL(CREATE_TABLE_ORDERS);
        db.execSQL(CREATE_TABLE_SHELTER);
        db.execSQL(CREATE_TABLE_ADMIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERDETAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHELTER);

        onCreate(db);
    }


    //Checkusername

    public Boolean Checkusername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails where username =? ", new String[]{username});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //Check username and password
    public Boolean checkusernamepassword(String username, String passoword){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails where username =? and password =?", new String[]{username, passoword});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //SignUp
    public Boolean insert(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long ins=db.insert("Userdetails", null, contentValues);
        if (ins==-1){
            return false;
        }
        else
            return true;
    }

    //update user info
    public Boolean updateuserdata(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",password);

        Cursor cursor = db.rawQuery("select * from Userdetails where username = ?", new String[] {username});
        if(cursor.getCount()>0) {

            long result = db.update("Userdetails", contentValues, "username=?", new String[]{username});
            if (result == -1) {
                return false;
            } else
                return true;
        }
        else
            return false;
    }



    //signup as admin
    public Boolean insertadmin(String username, String password){  //String name,
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        //contentValues.put("name", name);
        long result=db.insert("Admin", null, contentValues);
        if (result==-1){
            return false;
        }
        else
            return true;
    }

    //check admin
    public Boolean adminpass(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Admin where username = ? and password = ?", new String[]{username,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //delete user admin
    public Boolean deleteuserdata(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails where username = ?", new String[] {username});
        if(cursor.getCount()>0) {

            long result = db.delete("Userdetails", "username=?", new String[]{username});
            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }

    //update stock rate admin
    public Boolean updatestock(String Pname, int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("stock",stock);

        Cursor cursor = db.rawQuery("select * from Products where Pname = ?", new String[] {Pname});
        if(cursor.getCount()>0) {

            long result = db.update("Products", contentValues, "Pname=?", new String[]{Pname});
            if (result == -1) {
                return false;
            } else
                return true;
        }
        else
            return false;
    }

    //insert product info admin
    public Boolean insertproduct(String name,int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("PId", PId);
        contentValues.put("stock", stock);
        contentValues.put("pname", name);
        //contentValues.put("rate", rate);
        long result=db.insert("Products", null, contentValues);
        if (result==-1){
            return false;
        }
        else
            return true;
    }

    //decrement stock on placing oder



    //insert into orders table
    public boolean insertOrders(String username, String contact, String pname, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("ContactNumber", contact);
        contentValues.put("Pname", pname);
        contentValues.put("DateTime", date);
        long result = db.insert("Orders", null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    //insert to shelter
    public boolean insertShelter(String AppNo, String username, String contact, String date, int status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("AppNo",AppNo);
        contentValues.put("username",username);
        contentValues.put("ContactNumber",contact);
        contentValues.put("DateTime",date);
        contentValues.put("Status",status);
        long result = db.insert("Shelter",null,contentValues);
        if(result ==-1){
            return false;
        }else
            return true;
    }
    public Boolean updateStatus(int status, String appNo, String username){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status",status);
        Cursor cursor = db.rawQuery("select * from Shelter where appNo = ? and username = ?", new String[] {appNo,username});
        if(cursor.getCount()>0) {

            long result = db.update("Shelter", contentValues, "appNo=? AND username=?" , new String[]{appNo,username});
            if (result == -1) {
                return false;
            } else
                return true;
        }
        else
            return false;
    }
    public Cursor getStock(String P_name)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor ;


        cursor= sqLiteDatabase.rawQuery("select stock from Products where Pname = ? ", new String[] {P_name} );

        return cursor;
    }
    public Cursor getStatus(String appNo, String uname)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor ;


        cursor= sqLiteDatabase.rawQuery("select status from Shelter where appNo = ? and username = ?", new String[] {appNo,uname});

        return cursor;
    }

}


