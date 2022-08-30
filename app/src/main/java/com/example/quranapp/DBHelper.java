package com.example.quranapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    String DbName;
    String DbPath;
    Context context;

    public DBHelper(@Nullable Context context,String name) {
        super(context, "quran_database", null, 1);

        this.context = context;
        DbName = "quran_database.db";
        DbPath = "/data/data/" + context.getPackageName() +"/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CheckDatabase();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CheckDatabase(){
        try{
            String path = DbPath + DbName;
            SQLiteDatabase.openDatabase(path,null,0);
        }catch (Exception e){
            this.getReadableDatabase();
            CopyDatabase();
        }
    }

    public void CopyDatabase(){
        try{
            InputStream io = context.getAssets().open(DbName);
            String outfilenme = DbPath + DbName;
            OutputStream outputStream = new FileOutputStream(outfilenme);
            int length;
            byte[] buffer = new byte[1024];
            while ((length = io.read(buffer)) > 0){
                outputStream.write(buffer,length,0);
            }
            io.close();
            outputStream.flush();
            outputStream.close();
        }catch(Exception e){}
    }

    public void OpenDatabase(){
        String path = DbPath + DbName;
        SQLiteDatabase.openDatabase(path,null,0);
    }

    public ArrayList<ayatModel> getSurah(int sID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah where SuraID = "+ sID , null);
        ArrayList<ayatModel> ayatList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                ayatList.add(new ayatModel(cursorCourses.getInt(0), cursorCourses.getInt(1),cursorCourses.getInt(2),cursorCourses.getString(3),cursorCourses.getString(4),cursorCourses.getString(5),cursorCourses.getString(6),cursorCourses.getString(7),cursorCourses.getInt(8),cursorCourses.getInt(9),cursorCourses.getInt(10)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return ayatList;
    }

    public ArrayList<surahModel> getAllSurahs(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM tsurah " , null);
        ArrayList<surahModel> surahList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                surahList.add(new surahModel(cursorCourses.getInt(0),cursorCourses.getString(1),cursorCourses.getString(2),cursorCourses.getString(3),cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return surahList;
    }

}
