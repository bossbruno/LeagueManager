package com.theden.leaguemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CreateLeague extends AppCompatActivity {
String title;
TextView titletxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_league);
        titletxt = (TextView)findViewById(R.id.leaggue);



        }

    }
