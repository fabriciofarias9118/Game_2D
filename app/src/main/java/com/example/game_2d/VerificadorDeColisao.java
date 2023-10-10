package com.example.game_2d;

public class VerificadorDeColisao {

    private Nave nave;
    private Obstaculos obstaculos;

    public VerificadorDeColisao(Nave nave, Obstaculos obstaculos){
        this.nave = nave;
        this.obstaculos = obstaculos;
    }

    public boolean temColisao(){
        return obstaculos.verificarColisao(nave);
    }
}
