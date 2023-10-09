package com.example.game_2d;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Pontuacao {

    public static final Paint BRANCO = Cores.corTextoPontos();
    public static final Paint VIDAS = Cores.corTextoPontos();
    public static final Paint PONTUACAO = Cores.corTextoPontos();

    private int contadorDePontos = 0;
    private int contadorDeVidas = 0;

    private Cenario cenario;


    // CRIANDO CAMADAS PARA ADICIONAR TEXTOS
    public void adiconarCamada(Cenario cenario, Canvas canvas){
        // DESENHANDO TEXTO DA PONTUAÇÃO
        canvas.drawText("Pontos", 25, 80, BRANCO);
        canvas.drawText(String.valueOf(contadorDePontos), 100, 180, BRANCO);

        // DESENHANDO TEXTO DE VIDAS
        canvas.drawText("Vidas", cenario.getLargura() - 220, 80, BRANCO);
        canvas.drawText(String.valueOf(contadorDeVidas), cenario.getLargura() - 200, 180, BRANCO);

        // DESENHANDO TEXTO DE RECORD
    canvas.drawText("Record", (cenario.getLargura()/2) - 100, 80, BRANCO);
    canvas.drawText(String.valueOf(contadorDePontos), (cenario.getLargura()/2) - 100, 180, BRANCO);

    }

    public void incrementarPontos(){
        this.contadorDePontos++;
    }

    public int getContadorDePontos() {
        return contadorDePontos;
    }
}
