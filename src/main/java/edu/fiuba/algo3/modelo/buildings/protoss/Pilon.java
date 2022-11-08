package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Turno;

public class Pilon implements Turno {
    private int puntosDeVida;

    private int turnosActivo;

    private int puntosDeEscudo;

    private static final int MAX_ESCUDO = 350;

    public Pilon() {
        puntosDeEscudo = 350;
        puntosDeVida = 350;
        turnosActivo =0;
    }


    @Override
    public void pasarTurno(){
        if(puntosDeEscudo < MAX_ESCUDO)
            puntosDeEscudo++;
        turnosActivo++;
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales
    }
}
