package com.example.game_2d;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

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

    public void adicionarCamada(){}
    public void moverObstaculo(){}
    public boolean verificarColisao(){
        return true;
    }

}
