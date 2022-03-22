package com.theden.leaguemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Create_Cup extends AppCompatActivity {
    TextView CupName, Numb;
    String atitle, number;
    Integer num2;
    EditText txtview;

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
                myDatabaseHelper.addteam(txtview.getText().toString().trim());


            }
        });

    }
}
