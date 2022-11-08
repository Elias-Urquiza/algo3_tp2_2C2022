package edu.fiuba.algo3.entrega_1.TestsConstruccionesZerg;

import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsReservaDeProduccion {

    @Test
    public void unExtractorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        ReservaDeReproduccion unaReserva = new ReservaDeReproduccion();
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
        final ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Assertions.assertThrows(RuntimeException.class, () -> reserva.usar());
    }

}
