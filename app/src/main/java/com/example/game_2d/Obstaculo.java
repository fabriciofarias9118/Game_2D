package com.example.game_2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Obstaculo {

    public static final int LARGURA_DO_OBSTACULO = 150;
    public static final int ALTURA_DO_OBSTACULO = 80;

    private int alturaDoObstaculoInferior;
    private int alturaDoObstaculoSurperior;
    private int posicao;

    private Cenario cenario;

    private Bitmap obstaculoInfetior;
    private Bitmap obstaculoSuperio;

    public Obstaculo(Cenario cenario, int posicao, Context context){}

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

























