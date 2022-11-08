package edu.fiuba.algo3.entrega_1.TestsConstruccionesZerg;

import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsGuarida {

    @Test
    public void unExtractorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Guarida unaGuarida = new Guarida();
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
        final Guarida guarida = new Guarida();
        Assertions.assertThrows(RuntimeException.class, () -> guarida.usar());
    }
}
