package com.example.tictactoev2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Play extends AppCompatActivity {
    int QuiJou = 1; // 1 ou -1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button btn11 = (Button) findViewById(R.id.button11);
        btn11.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn11.setText("X");
            }
        }));
    }
}
