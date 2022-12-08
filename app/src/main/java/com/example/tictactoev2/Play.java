package com.example.tictactoev2;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Play extends AppCompatActivity {
    int QuiJou = 1, WaitToCheckWin = 0; // qui joue = 1 ou -1 // garder qui joue a 1
    String[] Names = new String[] {"Player 1", "Player 2"};// changer leur nom et changer l'orde dependament de qui commence (j'ai fait une fonction)
    String[] symbole = new String[] {"X", "O"}; // ne pas les changer de place
    boolean CanPlay = true, LautreJoueurCommence; //  LautreJoueurCommence est true si la switch sans settings est activer (je c pas commen sa changer encore.
    TextView comment, turn;
    ArrayList<Button> btn = new ArrayList<Button>();
    Button continuer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        if (LautreJoueurCommence) CangerLordeDesJoueur(); //

        comment = (TextView) findViewById(R.id.GameComment);
        turn = (TextView) findViewById(R.id.PlayerTurn);

        int temps = 0;
        if (QuiJou == -1) temps = 1;
        turn.setText("It's " + Names[temps] + "'s turn to play (or " + symbole[temps] + ")");// corrent grammar=================================
        continuer = findViewById(R.id.continueplay);
        continuer.setEnabled(false);
        continuer.setVisibility(View.GONE);

        btn.add(findViewById(R.id.button11));
        btn.add(findViewById(R.id.button12));
        btn.add(findViewById(R.id.button13));
        btn.add(findViewById(R.id.button21));
        btn.add(findViewById(R.id.button22));
        btn.add(findViewById(R.id.button23));
        btn.add(findViewById(R.id.button31));
        btn.add(findViewById(R.id.button32));
        btn.add(findViewById(R.id.button33));

        for (int i = 0; i < btn.size(); i++)
        {
            Button temp = btn.get(i);
            temp.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClickBtn(temp);
                }
            }));
        }
    }
    public void ClickBtn(Button btn){
        if (CanPlay) {
            if (btn.getText() == "") {
                comment.setText("");
                int temp = 0;
                if (QuiJou == -1) temp = 1;
                btn.setText(symbole[temp]);
                if (++WaitToCheckWin >= 5)
                    if (CheckWin()) {
                        comment.setText(Names[temp] + " Won!!!");
                        CanPlay = false;
                        continuer.setEnabled(true);
                        continuer.setVisibility(View.VISIBLE);
                    }
                if (CanPlay) {
                    QuiJou *= -1;
                    if (QuiJou == -1) temp = 1;
                    else temp = 0;
                    turn.setText("Its " + Names[temp] + "'s turns to play (or " + symbole[temp] + ")");// corrent grammar=================================
                }
            } else comment.setText("This square is already taken");
        }
    }
    public boolean CheckWin(){
        for (int i = 0; i < 3; i++) if (btn.get(i).getText() ==  btn.get(i+3).getText() && btn.get(i+3).getText() == btn.get(i+6).getText() && btn.get(i).getText() != "") return true;// check all vertical win
        for (int i = 0; i < 9; i += 3) if (btn.get(i).getText() ==  btn.get(i+1).getText() && btn.get(i+1).getText() == btn.get(i+2).getText() && btn.get(i).getText() != "")return true;// check all horisontal win
        if (btn.get(0).getText() ==  btn.get(4).getText() && btn.get(4).getText() == btn.get(8).getText() && btn.get(0).getText() != "") return true;// check diagonale 1 win
        if (btn.get(2).getText() ==  btn.get(4).getText() && btn.get(4).getText() == btn.get(6).getText() && btn.get(2).getText() != "") return true;// check all diagonale 2 win
        return false;
    }
    public void CangerLordeDesJoueur(){
        String temp = Names[0];
        Names [0] = Names[1];
        Names[1]=temp;
    }
}
