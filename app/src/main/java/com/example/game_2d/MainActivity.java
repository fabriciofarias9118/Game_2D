package com.example.game_2d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
            Log.e("LogGame", "oonCreat: "+e.getMessage());
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        constraintLayout = findViewById(R.id.container);

        GameEngine gameEngine = new GameEngine(this);
        constraintLayout.addView(gameEngine);
    }
}