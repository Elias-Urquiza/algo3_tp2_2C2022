package edu.fiuba.algo3.entrega_1.TestsConstruccionesZerg;

import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsExtractor {

    @Test
    public void unExtractorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = true;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();

        try{
            unExtractor.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarElExtractorAntesDeQueSeTermineDeConstruir(){
        final Extractor extractor = new Extractor();
        Assertions.assertThrows(RuntimeException.class, () -> extractor.usar());
    }

}
