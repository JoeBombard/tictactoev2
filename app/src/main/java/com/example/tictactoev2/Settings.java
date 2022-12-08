package com.example.tictactoev2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    String player1;
    String player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }
    public void ClickConfirm() {
        EditText player10 = findViewById(R.id.player1Name);
        EditText player20 = findViewById(R.id.player2Name);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("player1name", player10.getText().toString());
        editor.putString("player2name", player20.getText().toString());
        editor.apply();
    }
}