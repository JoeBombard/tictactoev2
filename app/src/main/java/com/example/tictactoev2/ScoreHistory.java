package com.example.tictactoev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreHistory extends AppCompatActivity {
TextView P1W, P2W, P1draw, P2draw, P1L, P2L, name1, name2, P1Score, P2Score;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_history);
        /*P1W = (TextView) findViewById(R.id.player1win);
        P2W = (TextView) findViewById(R.id.player2win);
        P1L = (TextView) findViewById(R.id.player1loss);
        P2L = (TextView) findViewById(R.id.player2loss);
        P1draw = (TextView) findViewById(R.id.player1draw);
        P2draw = (TextView) findViewById(R.id.player2draw);
        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        P1Score = (TextView) findViewById(R.id.player1score);
        P2Score = (TextView) findViewById(R.id.player2score);*/

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        /*P1W.setText(Integer.toString(sharedPref.getInt("player1score", 0)));
        P2W.setText(Integer.toString(sharedPref.getInt("player2score", 0)));
        P1L.setText(Integer.toString(sharedPref.getInt("player2score", 0)));
        P2L.setText(Integer.toString(sharedPref.getInt("player1score", 0)));
        P1draw.setText(Integer.toString(sharedPref.getInt("drawscore", 0)));
        P2draw.setText(Integer.toString(sharedPref.getInt("drawscore", 0)));
        if (sharedPref.getString("player1name", "") != "") name1.setText(sharedPref.getString("player1name", "") + "'s score");
        else name1.setText("Player 1's score");
        if (sharedPref.getString("player2name", "") != "") name2.setText(sharedPref.getString("player2name", "") + "'s score");
        else name2.setText("Player 2's score");
        int temp = sharedPref.getInt("player1score", 0) - sharedPref.getInt("player2score", 0);
        P1Score.setText(Integer.toString(temp));
        P2Score.setText(Integer.toString(temp * -1));*/

        Button finish = (Button) findViewById(R.id.terminer);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ArrayList<String> str = new ArrayList<String>();
        str.add("test vs test1, test win");
        try {
            File myObj = new File(getFilesDir().getAbsolutePath() + File.pathSeparator + "score.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.nextLine();
                str.add(data);
                //data = myReader.nextLine();
                //P1W.setText(data);
            }
            myReader.close();
            Toast.makeText(getBaseContext(), "Score saved successfully!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getBaseContext(), "Score failed to saved", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));/**/
        //recyclerView.setAdapter(new CustomAdapter(str,this));

    }
}