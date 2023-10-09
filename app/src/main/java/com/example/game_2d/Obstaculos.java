package com.example.game_2d;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Obstaculos {

    int QUANTIDADE_DE_OBSTACULOS = 50;
    int DISTANCIA_ENTRE_OBSTACULOS = 150;

    List<Obstaculo> obstaculoList = new ArrayList<>();

    Cenario cenario;

    Pontuacao pontuacao;

    int maximo = 0;
    int posicaoInicial = 0;

    Context context;

    //  CRIA A LISTA DE OBSTACULOS
    public Obstaculos(Cenario cenario, Pontuacao pontuacao, Context context){

        this.cenario = cenario;
        this.pontuacao = pontuacao;
        this.context = context;

        for (int i = 0; i < QUANTIDADE_DE_OBSTACULOS; i++){

            posicaoInicial += DISTANCIA_ENTRE_OBSTACULOS;
            obstaculoList.add(new Obstaculo(cenario, posicaoInicial, context));

        }

        for (Obstaculo obstaculo: obstaculoList){
            maximo = Math.max(obstaculo.getPosicao(),maximo);
        }

    }

    public void adicionarCamada(Canvas canvas){
        for (Obstaculo obstaculo: obstaculoList){
            obstaculo.adicionarObstaculoNoCenario(canvas);
        }
    }
    public void moverObstaculo(){

        ListIterator<Obstaculo> obstaculoListIterator = obstaculoList.listIterator();

        while (obstaculoListIterator.hasNext()){

            Obstaculo obstaculo = obstaculoListIterator.next();
            Obstaculo.movimentarObstaculo();

            if (obstaculo.verificarSeObstaculoSaiuDoCenario()){

                obstaculoListIterator.remove();
                Obstaculo novoObstaculo = new Obstaculo(cenario,
                        maximo + DISTANCIA_ENTRE_OBSTACULOS, context);
                obstaculoListIterator.add(novoObstaculo);
            }
        }

    }
    public boolean verificarColisao(Nave nave){

        for (Obstaculo obstaculo: obstaculoList){
            if (obstaculo.verificarColisaoVertical(nave)
                && obstaculo.verificarColisaoHorizontal(nave)){
                return true;
            }
        }
        return false;
    }

}










