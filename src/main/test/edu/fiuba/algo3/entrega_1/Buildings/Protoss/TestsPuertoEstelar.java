package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsPuertoEstelar {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unNexoMineralSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        PuertoEstelar puertoEstelar = new PuertoEstelar(mockEconomia);
        boolean afirmacion = true;

        for(int i = 0; i < 10; i++)
            puertoEstelar.pasarTurno();

        try{
            puertoEstelar.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarElNexoMineralAntesDeQueSeTermineDeConstruir(){
        final PuertoEstelar puertoEstelar = new PuertoEstelar(mockEconomia);
        Assertions.assertThrows(RuntimeException.class, () -> puertoEstelar.usar());
    }
}
