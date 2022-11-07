package edu.fiuba.algo3.modelo.buildings.zerg.EnConstruccion;

import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;

public class PreCriadero implements Turno {
    private static final int TIEMPO_CONSTRUCCION = 4;

    private int tiempoDesdeCreacion;

    public PreCriadero() {
        tiempoDesdeCreacion = 0;
    }

    @Override
    public void pasarTurno() {
        if (TIEMPO_CONSTRUCCION - tiempoDesdeCreacion > 0) {
            tiempoDesdeCreacion = tiempoDesdeCreacion + 1;
        }
        else {
            // eliminar preCriadero y llamar Criadero()
            Criadero()
        }
    }
}
