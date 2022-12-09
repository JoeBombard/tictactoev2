package com.example.tictactoev2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    String player1;
    String player2;
    Button confirmButton;
    TextView comment, name1, name2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        confirmButton = findViewById(R.id.ButComfirmName);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickConfirm();
            }
        });
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        if ((sharedPref.getString("player1name", "")) != "" && (sharedPref.getString("player2name", "")) != "")
        {
            name1.setText(sharedPref.getString("player1name", ""));
            name2.setText(sharedPref.getString("player2name", ""));
        }

        comment = (TextView) findViewById(R.id.textViewWhoStart);


        Switch WhoStart = (Switch) findViewById(R.id.switch2);
        //WhoStart.setOnCheckedChangeListener(this);





}
    public void ClickConfirm() {
        EditText player10 = findViewById(R.id.player1Name);
        EditText player20 = findViewById(R.id.player2Name);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        // sharedPref.getString("player1name", "");
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("player1name", player10.getText().toString());
        editor.putString("player2name", player20.getText().toString());
        editor.apply();
        finish();
    }
    /*@Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // do something when check is selected
        } else {
            //do something when unchecked
        }
    }*/
}