package com.example.tictactoev2;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class Play extends AppCompatActivity {
    int QuiJou = 1, WaitToCheckWin = 0; // qui joue = 1 ou -1
    String[] Names = new String[] {"Player 1", "Player 2"};
    String[] symbole = new String[] {"X", "O"};
    boolean CanPlay = true, draw = false;
    TextView comment, turn;
    ArrayList<Button> btn = new ArrayList<Button>();
    Button continuer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPref.getString("player1name", "") != "" )
            Names[0] = sharedPref.getString("player1name", "");
        if (sharedPref.getString("player2name", "") != "")
            Names[1] = sharedPref.getString("player2name", "");




        comment = (TextView) findViewById(R.id.GameComment);
        turn = (TextView) findViewById(R.id.PlayerTurn);

        int temps = 0;
        if (QuiJou == -1) temps = 1;
        turn.setText("It's " + Names[temps] + "'s turn to play (or " + symbole[temps] + ")");
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
            temp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClickBtn(temp);
                }
            });
        }
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();

                try {
                    File myObj = new File(getFilesDir().getAbsolutePath() + File.pathSeparator + "score.txt");
                    FileWriter myWriter = new FileWriter(myObj, true);
                    myObj.deleteOnExit();
                    String name1 = "Player 1", name2 = "Player 2";
                    if (sharedPref.getString("player1name", "") != "") name1 = (sharedPref.getString("player1name", ""));
                    if (sharedPref.getString("player2name", "") != "") name2 = (sharedPref.getString("player2name", ""));
                    String winner = "Draw\n";
                    if (QuiJou == 1) winner = name1 + " Wins\n";
                    else if (QuiJou == -1) winner = name2 + " Wins\n";
                    myWriter.write(name1 + " VS " + name2 + " : " + winner);
                    myWriter.close();

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Score failed to saved", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                finish();
            }
        });
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
                if (WaitToCheckWin == 9){
                    CanPlay = false;
                    draw = true;
                    QuiJou = 2;
                    comment.setText( "Draw. ");
                    turn.setText( "Draw. ");
                    continuer.setEnabled(true);
                    continuer.setVisibility(View.VISIBLE);

                }
                if (CanPlay) {
                    QuiJou *= -1;
                    if (QuiJou == -1) temp = 1;
                    else temp = 0;
                    turn.setText("It's " + Names[temp] + "'s turn to play (or " + symbole[temp] + ")");
                }
            } else comment.setText("This square is already taken.");
        }
    }
    public boolean CheckWin(){
        for (int i = 0; i < 3; i++) if (btn.get(i).getText() ==  btn.get(i+3).getText() && btn.get(i+3).getText() == btn.get(i+6).getText() && btn.get(i).getText() != "") return true;// check all vertical win
        for (int i = 0; i < 9; i += 3) if (btn.get(i).getText() ==  btn.get(i+1).getText() && btn.get(i+1).getText() == btn.get(i+2).getText() && btn.get(i).getText() != "")return true;// check all horisontal win
        if (btn.get(0).getText() ==  btn.get(4).getText() && btn.get(4).getText() == btn.get(8).getText() && btn.get(0).getText() != "") return true;// check diagonale 1 win
        if (btn.get(2).getText() ==  btn.get(4).getText() && btn.get(4).getText() == btn.get(6).getText() && btn.get(2).getText() != "") return true;// check diagonale 2 win
        return false;
    }
}
