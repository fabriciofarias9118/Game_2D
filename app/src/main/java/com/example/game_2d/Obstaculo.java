package com.example.game_2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Obstaculo {

    public static final int LARGURA_DO_OBSTACULO = 150;
    public static final int TAMANHO_DO_OBSTACULO = 80;
    int alturaDoObstaculoInferior;
    int alturaDoObstaculoSurperior;

    static int posicao;
    Cenario cenario;

    Bitmap obstaculoInfetior;
    Bitmap obstaculoSuperior;

    // CRIANDO OS OBSTACULOS
    public Obstaculo(Cenario cenario, int posicao, Context context) {

        this.posicao = posicao;
        this.cenario = cenario;

        // GERAR TAMANHOS DINAMICOS DE OBSTACULOS
        this.alturaDoObstaculoInferior = cenario.getAltura() - TAMANHO_DO_OBSTACULO + gerarValorAleatorio();
        this.alturaDoObstaculoSurperior = TAMANHO_DO_OBSTACULO + gerarValorAleatorio();

        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.objeto_obstaculo);

        // ATRIBUNDO OS TAMAMHOS E O DESENHO COMO OBSTACULOS SUPERIOR E INFERIOR.
        this.obstaculoInfetior = Bitmap.createScaledBitmap(bp, LARGURA_DO_OBSTACULO, this.alturaDoObstaculoInferior, false);
        this.obstaculoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_OBSTACULO, this.alturaDoObstaculoSurperior, false);

    }

    public void adicionarObstaculoNoCenario(Canvas canvas) {
        desenharObstaculoInferiorNoCenario(canvas);
        desenharObstaculoSuperiorNoCenario(canvas);
    }

    public void desenharObstaculoInferiorNoCenario(Canvas canvas) {
        canvas.drawBitmap(obstaculoInfetior, posicao, alturaDoObstaculoInferior, null);
    }

    public void desenharObstaculoSuperiorNoCenario(Canvas canvas) {
        canvas.drawBitmap(obstaculoSuperior, posicao, alturaDoObstaculoSurperior, null);
    }

    public static void movimentarObstaculo() {
        posicao -= 5;
    }

    public int gerarValorAleatorio() {
        return (int) (Math.random()*150);
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean verificarSeObstaculoSaiuDoCenario() {
        return posicao + LARGURA_DO_OBSTACULO < 0;
    }

    public boolean verificarColisaoVertical() {
        return true;
    }

    public boolean verificarColisaoHorizontal() {
        return true;
    }


}

























