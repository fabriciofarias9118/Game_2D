package com.example.game_2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Nave {

    int hangar = 80;
    int altura = 120;

    static final int RAIO = 55;

    private Som som;

    private Cenario cenario;

    private Context context;

    private Bitmap nave;

    boolean isRodape = false;

    int bordaSuperior;

    public Nave(Cenario cenario, Context context, Som som){

        this.cenario = cenario;
        this.som = som;
        this.context = context;

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.nave);

        this.nave = Bitmap.createScaledBitmap(bitmap,
                RAIO*2,
                RAIO*2,
                false);
    }

    public void adicionarCamada(Canvas canvas){
        canvas.drawBitmap(nave, hangar - RAIO, altura, null);
    }

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
