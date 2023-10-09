package com.example.game_2d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class GameOver {
    public static final Paint VERMELHO = Cores.corTextoPontos();

    private Cenario cenario;
    private GameOver(Cenario cenario){
        this.cenario = cenario;
    }

    public void adiconarCamada(Canvas canvas){
        String texto = "Game Over";

        // INSTANCIANDO UM RETANGULO
        Rect LimiteDoTexto = new Rect();
        // DESENHANDO O RETANGULO TRANSPARENTE
        VERMELHO.getTextBounds(texto,0, texto.length(), LimiteDoTexto);
        // DESENHANDO O TEXTO
        canvas.drawText(texto, (cenario.getLargura()/2)-300, cenario.geAltura(), VERMELHO);

    }
}
