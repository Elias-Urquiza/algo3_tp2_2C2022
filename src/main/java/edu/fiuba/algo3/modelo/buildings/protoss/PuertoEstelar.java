package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;

public class PuertoEstelar extends ConstruccionProtoss implements Turno, Construccion {
    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 10;

    private static final int MAX_ESCUDO = 600;

    public PuertoEstelar(){
        super(600, 600);
        turnosActivo = 0;
    }
    @Override
    public void pasarTurno(){
        curar();
        turnosActivo ++;

    }

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

    }
}
