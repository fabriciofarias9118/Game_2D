package com.example.game_2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Obstaculo {

    public static final int LARGURA_DO_OBSTACULO = 150;
    public static final int TAMANHO_DO_OBSTACULO = 80;
    private int alturaDoObstaculoInferior;
    private int alturaDoObstaculoSurperior;

    private int posicao;
    private Cenario cenario;

    private Bitmap obstaculoInfetior;
    private Bitmap obstaculoSuperior;

    // CRIANDO OS OBSTACULOS
    public Obstaculo(Cenario cenario, int posicao, Context context){

        this.posicao = posicao;
        this.cenario = cenario;

        // GERAR TAMANHOS DINAMICOS DE OBSTACULOS
        this.alturaDoObstaculoInferior = cenario.getAltura() - TAMANHO_DO_OBSTACULO + gerarValorAleatorio();
        this.alturaDoObstaculoSurperior = TAMANHO_DO_OBSTACULO + gerarValorAleatorio();

        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.objeto_obstaculo);

        // ATRIBUNDO OS TAMAMHOS E O DESENHO COMO OBSTACULOS SUPERIOR E INFERIOR.
        this.obstaculoInfetior = Bitmap.createScaledBitmap(bp,LARGURA_DO_OBSTACULO, this.alturaDoObstaculoInferior, false);
        this.obstaculoSuperior = Bitmap.createScaledBitmap(bp,LARGURA_DO_OBSTACULO, this.alturaDoObstaculoSurperior, false);

    }

    public void adicionarCamada(Canvas canvas){}

    public void desenharObstaculoInferiorNaCamada(Canvas canvas){}
    public void desenharObstaculoSuperiorNaCamada(Canvas canvas){}
    public void movimentarObstaculo(){}

    public int gerarValorAleatorio(){return 1;}

    public int getPosicao(){return posicao;}
    public boolean verificarSeObstaculoSaiuDoCenario(){return true;}
    public boolean verificarColisaoVertical(){return true;}
    public boolean verificarColisaoHorizontal(){return true;}



}

























