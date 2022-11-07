package edu.fiuba.algo3.modelo.buildings.zerg;


import edu.fiuba.algo3.modelo.Turno;

public class Criadero implements Turno {

    private int numeroDeLarvas;
    private int puntosDeVida;
    private int turnosActivo;

    // incluir atributo de ubicacion

    private static final int MAX_LARVAS = 3;
    private static final int TIEMPO_CONSTRUCCION = 4;


    public Criadero() {
        numeroDeLarvas = 3;
        puntosDeVida = 500;
        turnosActivo = 0;
    }

    public void extraerLarvas(int quitarLarvas) throws RuntimeException {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0))
            throw new RuntimeException("Numero de Larvas incorrecto");
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

        numeroDeLarvas-= quitarLarvas;
    }
    @Override
    public void pasarTurno() {
        if(numeroDeLarvas < MAX_LARVAS)
            numeroDeLarvas++;

        turnosActivo++;
    }
}
