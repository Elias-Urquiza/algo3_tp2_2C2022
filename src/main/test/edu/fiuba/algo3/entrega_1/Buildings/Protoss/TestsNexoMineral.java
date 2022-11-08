package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsNexoMineral {

    @Test
    public void unNexoMineralSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        NexoMineral nexoMineral = new NexoMineral();
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
        final NexoMineral nexoMineral = new NexoMineral();
        Assertions.assertThrows(RuntimeException.class, () -> nexoMineral.usar());
    }
}
