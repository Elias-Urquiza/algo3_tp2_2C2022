package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsPuertoEstelar {

    @Test
    public void unNexoMineralSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        PuertoEstelar puertoEstelar = new PuertoEstelar();
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
        final PuertoEstelar puertoEstelar = new PuertoEstelar();
        Assertions.assertThrows(RuntimeException.class, () -> puertoEstelar.usar());
    }
}
