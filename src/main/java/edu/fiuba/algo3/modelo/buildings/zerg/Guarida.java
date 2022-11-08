package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class Guarida implements Construccion, Turno {
    private int turnosActivo;
    private int vida;

    private static final int TIEMPO_CONSTRUCCION = 12;

    public Guarida(){
        turnosActivo = 0;
        vida = 1250;
    }

    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }

    }

    @Override
    public void pasarTurno() {
        turnosActivo++;
    }
}
