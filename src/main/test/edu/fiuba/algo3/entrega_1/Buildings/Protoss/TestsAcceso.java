package edu.fiuba.algo3.entrega_1.Buildings.Protoss;


import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestsAcceso {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unAccesoSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Acceso acceso = new Acceso(mockEconomia, new Posicion(0,0));
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
        final Acceso acceso = new Acceso(mockEconomia, new Posicion(0,0));
        Assertions.assertThrows(RuntimeException.class, () -> acceso.usar());
    }
}
