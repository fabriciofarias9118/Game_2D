package com.example.game_2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Nave {

    int hangar = 80;
    int altura = 120;

    static final int RAIO = 55;

    private Som som;

    private Cenario cenario;

    private Bitmap Nave;

    boolean isRodape = false;

    int bordaSuperior;

    public Nave(Cenario cenario, Context context, Som som){}

    public void adicionarCamada(Canvas canvas){}

    public int getHangar() {
        return hangar;
    }

    public void setHangar(int hangar) {
        this.hangar = hangar;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
