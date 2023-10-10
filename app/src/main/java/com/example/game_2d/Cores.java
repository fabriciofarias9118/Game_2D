package com.example.game_2d;

import android.graphics.Paint;

public class Cores {

    public static Paint corTextoPontos(){
        Paint corTextoPontos = new Paint();
        corTextoPontos.setColor(0xFFFF0000);



        return corTextoPontos;
    }

    public static Paint corGameOver(){
        Paint corGameOver = new Paint();
        corGameOver.setColor(0x0000FFFF);

        return corGameOver;
    }
}
