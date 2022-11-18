package edu.fiuba.algo3.modelo;

public abstract class Vida {
    public int puntosDeVida;
    public int puntosDeVidaMaxima;

    public Vida(int puntosDeVidaMaxima) {
        this.puntosDeVidaMaxima = puntosDeVidaMaxima;
        this.puntosDeVida = puntosDeVidaMaxima;
    }

    public abstract int daniar(int danio);
    public abstract int curar(int curacion);
}
