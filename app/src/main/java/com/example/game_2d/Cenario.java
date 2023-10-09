package com.example.game_2d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class Cenario {

    private DisplayMetrics metrics;

    public Cenario(Context context){

        WindowManager manager =
                (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        Display display = manager.getDefaultDisplay();

        metrics = new DisplayMetrics();

        display.getMetrics(metrics);

        Log.i("LogCenario", "Cenario: ");
    }

    public int getLargura() {
        return metrics.widthPixels;
    }

    public int geAltura() {
        return metrics.heightPixels;
    }
}
