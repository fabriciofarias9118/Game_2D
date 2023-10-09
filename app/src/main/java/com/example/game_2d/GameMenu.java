package com.example.game_2d;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        Cenario cenario = new Cenario(this);

        Intent intent = new Intent(GameMenu.this, MainActivity.class);
        startActivity(intent);

    }
}