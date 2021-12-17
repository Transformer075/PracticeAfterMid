package com.example.practiceapp02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper{
    public static final String STUDENT_NAME = "STUDENTName";
    public static final String STUDENT_AGE = "STUDENTAge";
    public static final String ACTIVE_STUDENT = "ActiveSTUDENT";
    public static final String STUDENT_ID = "STUDENTID";
    public static final String STUDENT_TABLE = "StudentTable";

    public DbHelper(@Nullable Context context) {
        super(context, "studentDB.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStatement = "CREATE TABLE " + STUDENT_TABLE + "(" + STUDENT_ID + "Integer PRIMARY KEY AUTOINCREMENT," +
                STUDENT_NAME + "Text, " + STUDENT_AGE + "int, " + ACTIVE_STUDENT + "BOOL)";
        db.execSQL(createStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }

    public void addStudent(StudentData studentData){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(STUDENT_NAME, studentData.getName());
        cv.put(STUDENT_AGE, studentData.getAge());
        cv.put(ACTIVE_STUDENT, studentData.isActive());
        db.insert(STUDENT_TABLE, null,cv);
        db.close();
    }

    public List<StudentData> getAllStudents(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);
        ArrayList<StudentData> studentArrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                studentArrayList.add(new StudentData(cursor.getString(1), cursor.getInt(2),
                        cursor.getInt(3) == 1 ? true:false));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return studentArrayList;
    }
}
