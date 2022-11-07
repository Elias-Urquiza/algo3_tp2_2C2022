package edu.fiuba.algo3.modelo;



public class Criadero implements Turno{

    private int numeroDeLarvas;
    private int puntosDeVida;

    public int MAXLARVAS = 3; // quiero hacer una cte de esto pero no se como.

    public Criadero() {
        numeroDeLarvas = 3;
        puntosDeVida = 500;
    }

    public void extraerLarvas(int quitarLarvas) throws RuntimeException {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0) )
            throw new RuntimeException("Numero de Larvas incorrecto");

        numeroDeLarvas-= quitarLarvas;
    }

    @Override
    public void pasarTurno() {
        if(numeroDeLarvas < MAXLARVAS)
            numeroDeLarvas++;
    }


}
