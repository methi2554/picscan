package com.example.picscan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String ttstext, String rating , byte[] image ){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO SCAN VALUES (NULL,?, ?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, ttstext);
        statement.bindString(2, rating);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public void updateData(String ttstext , String rating , byte[] image , int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE SCAN SET ttstext = ?,  rating = ? ,  image = ?  WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, ttstext);
        statement.bindString(2 ,rating);
        statement.bindBlob(3, image);
        statement.bindDouble(3, (double)id);


        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM SCAN WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
