package edu.fiuba.algo3.entrega_1.Buildings.Protoss;


import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsAcceso {

    @Test
    public void unAccesoSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Acceso acceso = new Acceso();
        boolean afirmacion = true;

        for(int i = 0; i < 8; i++)
            acceso.pasarTurno();

        try{
            acceso.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarElAccesoAntesDeQueSeTermineDeConstruir(){
        final Acceso acceso = new Acceso();
        Assertions.assertThrows(RuntimeException.class, () -> acceso.usar());
    }
}
