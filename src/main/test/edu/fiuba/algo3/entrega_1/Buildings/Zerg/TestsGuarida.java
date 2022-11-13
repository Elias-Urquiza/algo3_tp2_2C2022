package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsGuarida {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unExtractorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Guarida unaGuarida = new Guarida(mockEconomia, 0, 0);
        boolean afirmacion = true;

        for(int i = 0; i < 12; i++)
            unaGuarida.pasarTurno();

        try{
            unaGuarida.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarLaGuaridaAntesDeQueSeTermineDeConstruir(){
        final Guarida guarida = new Guarida(mockEconomia, 0, 0);
        Assertions.assertThrows(RuntimeException.class, () -> guarida.usar());
    }
}
