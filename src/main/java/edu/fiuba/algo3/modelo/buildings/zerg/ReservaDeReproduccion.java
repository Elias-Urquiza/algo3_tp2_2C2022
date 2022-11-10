package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class ReservaDeReproduccion implements Construccion, Turno {

    private int puntosDeVida;

    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 12;

    public ReservaDeReproduccion(){
        puntosDeVida = 1000;
        turnosActivo = 0;
    }

    public void evolucionarLarvas(int larvasEvolucionar)throws RuntimeException{
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");
    }
    public void pasarTurno() {
        turnosActivo++;
    }
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");


    }
}
