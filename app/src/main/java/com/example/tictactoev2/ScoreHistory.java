package com.example.tictactoev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreHistory extends AppCompatActivity {
TextView P1W, P2W, P1draw, P2draw, P1L, P2L, name1, name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_history);
        P1W = (TextView) findViewById(R.id.Player1Score);
        P2W = (TextView) findViewById(R.id.Player1);
        P1L = (TextView) findViewById(R.id.Player1Score);
        P2L = (TextView) findViewById(R.id.Player1);
        P1draw = (TextView) findViewById(R.id.textView10);
        P2draw = (TextView) findViewById(R.id.textView10);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        P1W.setText(Integer.toString(sharedPref.getInt("player1score", 0)));
        P2W.setText(Integer.toString(sharedPref.getInt("player2score", 0)));
        P1L.setText(Integer.toString(sharedPref.getInt("player2score", 0)));
        P2L.setText(Integer.toString(sharedPref.getInt("player1score", 0)));
        P1draw.setText(Integer.toString(sharedPref.getInt("drawscore", 0)));
        P2draw.setText(Integer.toString(sharedPref.getInt("drawscore", 0)));

        //editor.apply();

        Button finish = (Button) findViewById(R.id.terminer);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}