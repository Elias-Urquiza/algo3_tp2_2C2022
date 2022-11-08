package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsAsimilador {

    @Test
    public void unAsimiladorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Asimilador asimilador = new Asimilador();
        boolean afirmacion = true;

        for(int i = 0; i < 6; i++)
            asimilador.pasarTurno();

        try{
            asimilador.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarElAsimiladorAntesDeQueSeTermineDeConstruir(){
        final Asimilador asimilador = new Asimilador();
        Assertions.assertThrows(RuntimeException.class, () -> asimilador.usar());
    }
}
