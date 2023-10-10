package com.example.game_2d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameMenu extends AppCompatActivity {

    GameEngine gameEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
        }
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_game_menu);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ConstraintLayout container = (ConstraintLayout) findViewById(R.id.conteiner);

        gameEngine = new GameEngine(this);
        container.addView(gameEngine);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameEngine.cancelarGame();
    }

    @Override
    protected void onResume() {
        super.onResume();

        gameEngine.iniciarGame();
        new Thread(gameEngine).start();
    }
}