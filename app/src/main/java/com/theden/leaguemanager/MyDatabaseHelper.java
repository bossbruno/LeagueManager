package com.theden.leaguemanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
/*
public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;



    public static final String DATABASE_NAME = "LeagueManager.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "jomo";
    public static final String COLUMN_ID = "league_name";
    public static final String COLUMN_TEAM = "team_name";
    public static final String COLUMN_MPLAYED = "PLD";
    public static final String COLUMN_MWON = "W";
    public static final String COLUMN_MDRAWED = "D";
    public static final String COLUMN_MLOST = "L";
    public static final String COLUMN_GFOR = "GF";
    public static final String COLUMN_GAGAINST = "GA";
    public static final String COLUMN_GDIFF = "GD";
    public static final String COLUMN_POINTS = "PTS";
    ImageView COLUMN_TEAMPIC;


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;


    }


    @Override
    public void onCreate(SQLiteDatabase db) {


            String query = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    COLUMN_TEAM + " TEXT NOT NULL, " +
                    COLUMN_MPLAYED + " INTEGER NOT NULL, " +
                    COLUMN_MWON + " INTEGER NOT NULL, " +
                    COLUMN_MLOST + " INTEGER," +
                    COLUMN_MDRAWED + " INTEGER, " +
                    COLUMN_GFOR + " INTEGER, " +
                    COLUMN_GAGAINST + " INTEGER, " +
                    COLUMN_GDIFF + " INTEGER, " +
                    COLUMN_POINTS + " INTEGER);";
            db.execSQL(query);
        }
        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);

        }
        void addteam (String tname){



            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(COLUMN_TEAM, tname);
            cv.put(COLUMN_MPLAYED, 0);
            cv.put(COLUMN_MWON, 0);
            cv.put(COLUMN_MLOST, 0);
            cv.put(COLUMN_MDRAWED, 0);
            cv.put(COLUMN_GAGAINST, 0);
            cv.put(COLUMN_GFOR, 0);
            cv.put(COLUMN_GDIFF, 0);
            cv.put(COLUMN_POINTS, 0);

            long result = db.insert(TABLE_NAME, null, cv);
            if (result == -1) {
                Toast.makeText(context, " Failed to add " + TABLE_NAME, Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, " Added", Toast.LENGTH_SHORT).show();

            }

        }
    }
*/
