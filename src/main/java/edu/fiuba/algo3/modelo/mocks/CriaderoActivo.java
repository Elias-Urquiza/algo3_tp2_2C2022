package edu.fiuba.algo3.modelo.mocks;

import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;

public class CriaderoActivo extends Criadero {
    public CriaderoActivo() {
        super(new MockEconomia());
        pasarTurno();
        pasarTurno();
        pasarTurno();
        pasarTurno();
    }

}
