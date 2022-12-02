package com.example.tictactoev2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Play extends AppCompatActivity {
    int QuiJou = 1; // 1 ou -1
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
        }));
    }
    public void ClickBtn(Button btn){
        if (btn.getText() == "") {

        }
        else comment.setText("This square is already taken");

    }
}
