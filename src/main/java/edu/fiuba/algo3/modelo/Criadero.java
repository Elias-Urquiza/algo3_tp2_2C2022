package edu.fiuba.algo3.modelo;

public class Criadero {

    private int numeroDeLarvas;
    private int puntosDeVida;

    public Criadero() {
        numeroDeLarvas = 3;
        puntosDeVida = 500;
    }

    public void extraerLarvas(int quitarLarvas) throws RuntimeException {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0) )
            throw new RuntimeException("Numero de Larvas incorrecto");

        numeroDeLarvas-= quitarLarvas;
    }
}
