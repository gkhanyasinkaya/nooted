package com.app.nooted.Resource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "nooted.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users(ID INTEGER PRIMARY KEY AUTOINCREMENT, workSpaceId INTEGER, userName TEXT, userPass TEXT, userMail TEXT)");
        db.execSQL("CREATE TABLE WorkSpaces(ID INTEGER PRIMARY KEY AUTOINCREMENT, workSpaceName TEXT,workSpaceColor TEXT)");
        db.execSQL("CREATE TABLE Cards(ID INTEGER PRIMARY KEY AUTOINCREMENT, elementId INTEGER,workSpaceId INTEGER,cardName TEXT,positionX INTEGER,positionY INTEGER)");
        db.execSQL("CREATE TABLE Elements(ID INTEGER PRIMARY KEY AUTOINCREMENT, elementName TEXT, description TEXT)");
        db.execSQL("CREATE TABLE ID(ID INTEGER PRIMARY KEY AUTOINCREMENT,workSpaceId INTEGER, userId INTEGER, elementId INTEGER, cardId INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS WorkSpaces");
        db.execSQL("DROP TABLE IF EXISTS Cards");
        db.execSQL("DROP TABLE IF EXISTS Elements");
    }


    public boolean InsertID(int workSpaceId, int userId , int elementId, int cardId){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("workSpaceId", workSpaceId);
        contentValues.put("userId", userId);
        contentValues.put("elementId", elementId);
        contentValues.put("cardId", cardId);
        long result = sqLiteDatabase.insert("ID", null, contentValues);
        if(result == -1){
            return false;
        }
        return true;
    }

    public boolean InsertUser(String userName, String userPass, String userMail){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", userName);
        contentValues.put("userPass", userPass);
        contentValues.put("userMail", userMail);
        long result = sqLiteDatabase.insert("Users", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean InsertElement(String elementName, String description){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("elementName", elementName);
        contentValues.put("description", description);
        long result = sqLiteDatabase.insert("Elements", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public void UpdateElement(int ID,String elementName, String description) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("UPDATE Elements SET elementName=?, description=? WHERE ID=?", new String[] {elementName,description,Integer.toString(ID)});
    }

    public boolean InsertCard(String cardName, int positionX, int positionY){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cardName", cardName);
        contentValues.put("positionX", positionX);
        contentValues.put("positionY", positionY);
        long result = sqLiteDatabase.insert("Cards", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public void UpdateCard(int ID,int elementId,int workSpaceId, String cardName,int positionX , int positionY) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("UPDATE Cards SET elementId=?, workSpaceId=?, cardName=?,positionX=?,positionY=? WHERE ID=?", new String[] {Integer.toString(elementId),Integer.toString(workSpaceId),cardName,Integer.toString(positionX),Integer.toString(positionY),Integer.toString(ID)});
    }

    public long InsertWorkSpace(int workSpaceID,String workSpaceName,String bgColor){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", workSpaceID);
        contentValues.put("workSpaceName", workSpaceName);
        contentValues.put("workSpaceColor", bgColor);

        long result = sqLiteDatabase.insert("WorkSpaces", null, contentValues);
        if(result == -1){
            return -1;
        }else{
            return result;
        }
    }

    /*
    public ArrayList<String> getWorkSpaceName(int userId){
        int i = 1;
        ArrayList<String> workSpaceArrayList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT workSpaceName  FROM WorkSpace WHERE userID = ?", new String[]{Integer.toString(userId)});
        if(cursor.getCount() >= 0){
            cursor.moveToFirst();
            workSpaceArrayList.add(cursor.getString(i));
        }
        return(workSpaceArrayList);
    }*/

    public Boolean CheckUsername(String userName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE userName=?", new String[]{userName});
        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }

    public User getUser(int Id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE ID=?", new String[]{Integer.toString(Id)});
        User user = new User();
        cursor.moveToFirst();
        user.setId(cursor.getInt(0));
        user.setUserName(cursor.getString(1));
        user.setUserMail(cursor.getString(2));
        user.setUserPass(cursor.getString(3));

        return user;
    }


    public int CheckLogin(String userName, String userPass){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE userName=? AND userPass=?", new String[]{userName, userPass});
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            return 1;
        }else{
            return -1;
        }
    }
}