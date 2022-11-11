package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;

public class CriaderoActivo extends Criadero {
    public CriaderoActivo() {
        super(new MockEconomia(), 0, 0);
        pasarTurno();
        pasarTurno();
        pasarTurno();
        pasarTurno();
    }

}
