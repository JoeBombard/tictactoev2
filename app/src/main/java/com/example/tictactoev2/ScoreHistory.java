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
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_history);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();

        Button finish = (Button) findViewById(R.id.terminer);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ArrayList<String> str = new ArrayList<String>();
        try {
            File myObj = new File(getFilesDir().getAbsolutePath() + File.pathSeparator + "score.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.nextLine();
                str.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(getBaseContext(), "Score failed to saved", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));/**/
        recyclerView.setAdapter(new CustomAdapter(str));

    }
}