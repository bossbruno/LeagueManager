package com.theden.leaguemanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Create_Cup extends AppCompatActivity {
    TextView CupName, Numb;
    static String atitle;
    String number;
    Integer num2;
    static EditText txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cup);
        CupName = (TextView) findViewById(R.id.CupName);
        Numb = (TextView) findViewById(R.id.textView4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            atitle = extras.getString("Name");
            CupName.setText(atitle + "'s Cup");

        }

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            number = extra.getString("number");
            Numb.setText(number + " Teams");
            num2 = Integer.valueOf(number);


        }
        Numberofteams();

    }

    public void Numberofteams() {

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linlay);
        // setContentView(linearLayout);
        // for(int i = 2; i<=num2; i=(i*2) )
        int i = 1;

        while (i <= num2) {
            i++;
            txtview = new EditText(this);
            txtview.setHint("Enter Team Name ");


            linearLayout.addView(txtview);

        }
        Button btn = new Button(this);
        btn.setText("Add Teams");
        linearLayout.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getApplicationContext());
                myDatabaseHelper.addteam();


            }
        });

    }

    public static class MyDatabaseHelper extends SQLiteOpenHelper {

        private Context context;


        public static final String DATABASE_NAME = "LeagueManager.db";
        public static final int DATABASE_VERSION = 1;
        public String TABLE_NAME = atitle;
        public static final String COLUMN_ID = "Position";
        public  final String COLUMN_TEAM = "team_name";
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
        void addteam(){


            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(COLUMN_TEAM, txtview.getText().toString());
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
                onCreate(db);
                Toast.makeText(context, " Failed to add " + txtview.getText(), Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(context, " Added " + txtview.getText(), Toast.LENGTH_SHORT).show();

            }

        }

        Cursor readallData(){
            String query = "SELECT *  FROM " + TABLE_NAME;
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = null;
            if(db!=null){
             cursor=   db.rawQuery(query, null);

            }
            return cursor;
        }

    }


}
