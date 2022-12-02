package com.example.tictactoev2;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.jar.Attributes;

public class Play extends AppCompatActivity {
    int QuiJou = 1; // 1 ou -1
    String[] Names = new String[] {"Player 1", "Player 2"};
    String[] symbole = new String[] {"X", "Y"};
    TextView comment = (TextView) findViewById(R.id.GameComment);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);



        Button btn11 = (Button) findViewById(R.id.button11);
        btn11.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickBtn(btn11);
            }
        }));/*
        Button btn12 = (Button) findViewById(R.id.button12);
        btn12.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickBtn(btn12);
            }
        }));
        Button btn13 = (Button) findViewById(R.id.button13);
        btn13.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickBtn(btn13);
            }
        }));*/


    }
    public void ClickBtn(Button btn){
        if (btn.getText() == "") {
            int temp = 0;
            if (QuiJou == -1) temp = 1;
            btn.setText(symbole[temp]);
        }
        else comment.setText("This square is already taken");

    }
}
