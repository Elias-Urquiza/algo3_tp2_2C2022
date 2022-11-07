package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class Espiral implements Turno, Construccion {

    private int turnosActivo;
    private final int TIEMPO_CONSTRUCCION = 10;
    public Espiral() {
        turnosActivo = 0;
    }

    @Override
    public void usar() {
        if (turnosActivo < TIEMPO_CONSTRUCCION) {
            throw new RuntimeException("No se puede usar todavia");
        }
    }

    @Override
    public void pasarTurno() {
        turnosActivo++;
    }
}
