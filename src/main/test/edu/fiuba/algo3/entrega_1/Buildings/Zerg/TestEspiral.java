package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestEspiral {

    private Espiral espiral;

    private static final Economia mockEconomia = new MockEconomia();



    @Test
    public void creoUnEspiralYNoEstaOperativo() {
        espiral = new Espiral(mockEconomia,0 ,0);
        Assertions.assertThrows(RuntimeException.class, () -> espiral.usar());
    }

    @Test
    public void creoUnEspiralYPasan10TurnosYLoPuedoUsar() {
        espiral = new Espiral(mockEconomia,0 ,0);
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
