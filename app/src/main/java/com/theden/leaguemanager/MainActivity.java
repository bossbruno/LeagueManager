package com.theden.leaguemanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab1 , fab2, fab3;
    Animation ropen, rclose, fopen, fclose;
    boolean isOpen = false;
    TextView txtcup , txtleague;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    EditText cupname;
    TextView Noparticipants;
    private Button save, cancel;
    Spinner spinner;

Create_Cup.MyDatabaseHelper db;
ArrayList<String> leaguename, noteams , leagueid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





txtcup = (TextView)findViewById(R.id.cup_txt);
txtleague=(TextView)findViewById(R.id.league_txt) ;

        fab1 = (FloatingActionButton)findViewById(R.id.add_btn);
        fab2 = (FloatingActionButton) findViewById(R.id.edit_btn);
        fab3 = (FloatingActionButton) findViewById(R.id.new_btn);

        fopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_close_anim);
        ropen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_open_anim);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createLeaguebuilder();

            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateLeague.class);
                startActivity(intent);
            }
        });

    }

    private void animateFab(){
        if(isOpen){
            fab1.startAnimation(rclose);
            fab2.startAnimation(fclose);
            txtcup.startAnimation(fclose);
            fab3.startAnimation(fclose);
            txtleague.startAnimation(fclose);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isOpen=false;
        }
        else{
            fab1.startAnimation(ropen);
            fab2.startAnimation(fopen);
            txtcup.startAnimation(fopen);
            txtleague.startAnimation(fopen);
            fab3.startAnimation(fopen);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isOpen=true;
        }
    }

    public void createLeaguebuilder(){
        dialogbuilder = new AlertDialog.Builder(this);
        final View popupview = getLayoutInflater().inflate(R.layout.popup , null);
        cupname =(EditText) popupview.findViewById(R.id.editTextTextPersonName2);
        Noparticipants = (TextView)popupview.findViewById(R.id.textView3);
        save = (Button) popupview.findViewById(R.id.button);
        cancel= (Button) popupview.findViewById(R.id.button2);
spinner = (Spinner)popupview.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.Cup_no_teams, android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        dialogbuilder.setView(popupview);
        dialog = dialogbuilder.create();
        dialog.show();



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(getApplicationContext(), Create_Cup.class);
                inte.putExtra("Name",cupname.getText().toString());
                inte.putExtra("number", spinner.getSelectedItem().toString());
                startActivity(inte);



            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }

}