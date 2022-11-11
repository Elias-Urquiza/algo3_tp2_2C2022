package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestEspiral {

    private Espiral espiral;

    private static final Economia mockEconomia = new MockEconomia();
    @BeforeEach
    public void initEach() {
        espiral = new Espiral(mockEconomia);
    }

    @Test
    public void creoUnEspiralYNoEstaOperativo() {
        Assertions.assertThrows(RuntimeException.class, () -> espiral.usar());
    }

    @Test
    public void creoUnEspiralYPasan10TurnosYLoPuedoUsar() {
        boolean afirmacion = true;

        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();
        espiral.pasarTurno();

        try{
            espiral.usar();
        } catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }
}
