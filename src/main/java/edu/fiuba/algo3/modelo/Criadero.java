package edu.fiuba.algo3.modelo;

public class Criadero {

    private int numeroDeLarvas;
    public Criadero() {
        numeroDeLarvas = 3;
    }

    public void extraerLarvas(int quitarLarvas) throws Exception {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0) )
            throw new Exception("Numero de Larvas incorrecto");

        numeroDeLarvas-= quitarLarvas;
    }
}
