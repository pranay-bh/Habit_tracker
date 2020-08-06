package com.solvedunsloved.myapplication.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.solvedunsloved.myapplication.Model.Habit;
import com.solvedunsloved.myapplication.Util.Constants;
import java.util.ArrayList;
import java.util.List;

public class HabitDatabase extends SQLiteOpenHelper {

    private Context ctx;
    public HabitDatabase(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        this.ctx =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_DATABASE = "CREATE TABLE " +  Constants.TABLE_NAME
                + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY,"
                + Constants.KEY_NAME + " TEXT,"
                + Constants.KEY_DURATION + " TEXT,"
                + Constants.KEY_DESCRIPTION + " TEXT);";
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

    public void addHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_NAME, habit.getName());
        values.put(Constants.KEY_DURATION, habit.getDuration());
        values.put(Constants.KEY_DESCRIPTION, habit.getDescription());
        //Insert the row
        db.insert(Constants.TABLE_NAME, null, values);
    }

    public Habit gethabit(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, new String[] {Constants.KEY_ID,
                        Constants.KEY_NAME, Constants.KEY_DURATION, Constants.KEY_DESCRIPTION},
                Constants.KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Habit habit = new Habit();
        habit.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
        habit.setName(cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME)));
        habit.setDuration(cursor.getString(cursor.getColumnIndex(Constants.KEY_DURATION)));
        habit.setDescription(cursor.getString(cursor.getColumnIndex(Constants.KEY_DESCRIPTION)));
        return habit;
    }

    public List<Habit> getAllHabits() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Habit> habitList = new ArrayList<>();

        Cursor cursor = db.query(Constants.TABLE_NAME, new String[] {
                Constants.KEY_ID,
                Constants.KEY_NAME,
                Constants.KEY_DURATION,
                Constants.KEY_DESCRIPTION,}, null, null, null, null, null );

        if (cursor.moveToFirst()) {
            do {
                Habit habit = new Habit();
                habit.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
                habit.setName(cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME)));
                habit.setDuration(cursor.getString(cursor.getColumnIndex(Constants.KEY_DURATION)));
                habit.setDescription(cursor.getString(cursor.getColumnIndex(Constants.KEY_DESCRIPTION)));
                habitList.add(habit);
            }while (cursor.moveToNext());
        }
        return habitList;
    }

    public int updateHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_NAME, habit.getName());
        values.put(Constants.KEY_DURATION, habit.getDuration());
        values.put(Constants.KEY_DESCRIPTION, habit.getDescription());
        return db.update(Constants.TABLE_NAME, values, Constants.KEY_ID + "=?", new String[] { String.valueOf(habit.getId())} );
}

    public void deleteHabit(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.KEY_ID + " = ?",
                new String[] {String.valueOf(id)});
        db.close();
    }

    //get count
    public int getHabitCount() {
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();
    }

}