package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class Asimilador implements Turno, Construccion {

    private int puntosDeVida;

    private int turnosActivo;

    private int puntosDeEscudo;

    private static final int MAX_ESCUDO = 450;

    private static final int TIEMPO_CONSTRUCCION = 6;

    public Asimilador() {
        puntosDeEscudo = 450;
        puntosDeVida = 450;
        turnosActivo =0;
    }

    @Override
    public void pasarTurno(){
        if(puntosDeEscudo < MAX_ESCUDO)
            puntosDeEscudo++;  //Asumo que va sumando de a un por turno
        turnosActivo++;
    }

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

    }
}
