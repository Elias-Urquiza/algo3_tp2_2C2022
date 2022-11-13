package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestsNexoMineral {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unNexoMineralSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        NexoMineral nexoMineral = new NexoMineral(mockEconomia, new Posicion(0,0));
        boolean afirmacion = true;

        for(int i = 0; i < 4; i++)
            nexoMineral.pasarTurno();

        try{
            nexoMineral.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarElNexoMineralAntesDeQueSeTermineDeConstruir(){
        final NexoMineral nexoMineral = new NexoMineral(mockEconomia, new Posicion(0,0));
        Assertions.assertThrows(RuntimeException.class, () -> nexoMineral.usar());
    }
}
