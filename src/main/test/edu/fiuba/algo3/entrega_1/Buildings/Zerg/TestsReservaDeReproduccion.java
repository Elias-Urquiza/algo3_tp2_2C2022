package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsReservaDeReproduccion {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unExtractorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        ReservaDeReproduccion unaReserva = new ReservaDeReproduccion(mockEconomia, new Posicion(0, 0));
        boolean afirmacion = true;

        for(int i = 0; i < 12; i++)
            unaReserva.pasarTurno();

        try{
            unaReserva.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarLaReservaAntesDeQueSeTermineDeConstruir(){
        final ReservaDeReproduccion reserva = new ReservaDeReproduccion(mockEconomia,  new Posicion(0, 0));
        Assertions.assertThrows(RuntimeException.class, () -> reserva.usar());
    }

}
