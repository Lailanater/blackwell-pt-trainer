package com.lailperry.android.blackwellpttrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Owner on 2/21/2018.
 */

public class WorkoutDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "workouts.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_WORKOUTS = "workouts";
    private static final String FIELD_ID = "ID";
    private static final String FIELD_NAME = "NAME";
    private static final String FIELD_DESCRIPTION = "DESCRIPTION";
    private static final String FIELD_CONTENT = "CONTENT";
    private static final String FIELD_COMPLETED = "COMPLETED";

    public WorkoutDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_WORKOUTS + " (" + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIELD_NAME + " TEXT, " + FIELD_DESCRIPTION + " TEXT, " + FIELD_CONTENT + " TEXT, " + FIELD_COMPLETED + " BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade code goes here
    }

    public boolean insertData(String name, String description, ArrayList<String> content, boolean completed) throws JSONException {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_DESCRIPTION, description);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(FIELD_CONTENT, new JSONArray(content));
        String arrayList = jsonObject.toString();
        contentValues.put(FIELD_CONTENT, arrayList);
        contentValues.put(FIELD_COMPLETED, completed);
        long result = db.insert(TABLE_WORKOUTS, null, contentValues);
        if (result == -1) {
            return false;
        }
        return true;
    }
}
