package com.example.tictactoev2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    String player1;
    String player2;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        confirmButton = findViewById(R.id.ButComfirmName);
    }
    public void ClickConfirm() {
        EditText player10 = findViewById(R.id.player1Name);
        EditText player20 = findViewById(R.id.player2Name);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this); // copie cette ligne là et ensuite met l'autre ligne en commentaire pour aller retrouver "player1name".
        // sharedPref.getString("player1name", "");
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("player1name", player10.getText().toString());
        editor.putString("player2name", player20.getText().toString());
        editor.apply();
        finish();
    }
}