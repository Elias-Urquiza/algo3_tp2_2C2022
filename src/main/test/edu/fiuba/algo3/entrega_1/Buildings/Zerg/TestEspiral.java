package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestEspiral {
    @Test
    public void creoUnEspiralYNoEstaOperativo() {
        final Espiral espiral = new Espiral();
        Assertions.assertThrows(RuntimeException.class, () -> espiral.usar());
    }

    @Test
    public void creoUnEspiralYPasan10TurnosYLoPuedoUsar() {
        Espiral espiral = new Espiral();
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
