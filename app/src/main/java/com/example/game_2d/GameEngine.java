package com.example.game_2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/*
 *  TODO: Clase Game Over
 *  TODO: Clase Obstaculo
 *  TODO: Clase Obstaculos ** (movimento)
 *  TODO: Clase Colisões
 *  TODO: Clase Nave movimento
 *  TODO: Consumir todas as classes e metodos para rodar o game
 */

public class GameEngine extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private Nave nave;
    private Cenario cenario;
    private Som som;
    private final SurfaceHolder holder = getHolder();

    private Bitmap background;
    private Obstaculos obstaculos;
    private Pontuacao pontuacao;
    Canvas canvas;

    public GameEngine(Context context) {
        super(context);
        this.cenario = new Cenario(context);
        som = new Som(context);
        inicializarElementos();
        setOnTouchListener(this::onTouch);

    }

    private void inicializarElementos() {
        this.nave = new Nave(
                cenario,
                getContext(),
                som
        );
        Bitmap back = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.space
        );
        this.background = Bitmap.createScaledBitmap(
                back,
                cenario.getLargura(),
                cenario.getAltura(),
                false
        );
        this.obstaculos = new Obstaculos(cenario, pontuacao, getContext());
        this.pontuacao = new Pontuacao();

    }

    public void iniciarGame(){
        this.isRunning = true;
    }

    public void cancelarGame(){
        this.isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning){
            if (!holder.getSurface().isValid()) continue;
            canvas = holder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, null);

            nave.adicionarCamada(canvas);
            nave.navegacaoDown();

            obstaculos.adicionarCamada(canvas);
            obstaculos.moverObstaculo();

            pontuacao.adiconarCamada(cenario, canvas);

            if (new VerificadorDeColisao(nave, obstaculos).temColisao()){
                if (pontuacao.getVidas() > 0){
                    int vidas = pontuacao.getVidas() -1;
                    pontuacao.setVidas(vidas);
                    nave.setHangar(60);
                    nave.setAltura(cenario.getAltura()/2);
                }else {
                    new GameOver(cenario).adiconarCamada(canvas);
                    isRunning = false;
                    som.playFalas(Som.GAME_OVER);
                }
            }
            holder.unlockCanvasAndPost(canvas);
            Log.i("criptp", "Game Rodando...");
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        nave.navegacaoUp();

        int vidas = pontuacao.getVidas();

        if (nave.getHangar() < cenario.getLargura() - 35){
            nave.setHangar(nave.getHangar() + 15);
        } else {
            nave.setHangar(120);
        }
        pontuacao.incrementarPontos();

        switch (pontuacao.getContadorDePontos()){
            case 10:
                som.playFalas(som.FASE_01);
                break;
            case 50:
                som.playFalas(som.FASE_01);
                break;
            case 100:
                som.playFalas(som.FASE_01);
                break;
            case 150:
                som.playFalas(som.FASE_01);
                break;
            case 250:
                som.playFalas(som.FASE_01);
                break;
            case 350:
                som.playFalas(som.FASE_01);
        }

        return false;
    }
}
