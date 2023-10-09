package com.example.game_2d;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class Som {

    private SoundPool soundPool;

    public static int MOVIMENTO;
    public static int COLISAO;
    public static int GAME_OVER;
    public static int FASE_01;
    public static int HIGH_SCORE;


    // VERIFICA A VER DO BUILDER
    public Som(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            soundPool = new SoundPool.Builder().setMaxStreams(10).build();

        } else {

            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

        }

        // ATRIBUINDO OS ARQUIVOS DE AUDIO AS VARIAVEIS
        MOVIMENTO = soundPool.load(context, R.raw.pulo, 0);
        COLISAO = soundPool.load(context, R.raw.colisao, 0);
        GAME_OVER = soundPool.load(context, R.raw.game_over_01, 0);
        FASE_01 = soundPool.load(context, R.raw.fase_01, 0);
        HIGH_SCORE = soundPool.load(context, R.raw.high_score, 0);

    }

    // REPRODUZ O AUDIO
    public void playSom(int som) {
        soundPool.play(som, 0.1f, 0.1f, 1, 0, 1);
    }

    // REPRODUZ O AUDIO
    public void playFalas(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }


}















