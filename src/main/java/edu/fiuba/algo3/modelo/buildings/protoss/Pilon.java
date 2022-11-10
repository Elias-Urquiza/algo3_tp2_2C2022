package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class Pilon implements Turno, Construccion {
    private int puntosDeVida;

    private int turnosActivo;

    private int puntosDeEscudo;

    private static final int MAX_ESCUDO = 350;

    private static final int TIEMPO_CONSTRUCCION = 5;

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

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");


    }
}
