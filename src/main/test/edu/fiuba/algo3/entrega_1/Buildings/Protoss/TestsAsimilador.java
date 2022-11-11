package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsAsimilador {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unAsimiladorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){


        Asimilador asimilador = new Asimilador(mockEconomia);
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
        Economia economia = new Economia();
        final Asimilador asimilador = new Asimilador(economia);
        Assertions.assertThrows(RuntimeException.class, () -> asimilador.usar());
    }




    @Test
    public void unAsimiladorSumaGasAlEstarOperativo(){

        Economia economia = new Economia();

        Asimilador asimilador = new Asimilador(economia);
        boolean afirmacion = true;

        for(int i = 0; i < 7; i++)
            asimilador.pasarTurno();

        try {
            economia.gastarGasVespeno(20);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }


    @Test
    public void unAsimiladorSumaGasAlEstarOperativoVariosTurnos(){

        Economia economia = new Economia();

        Asimilador asimilador = new Asimilador(economia);
        boolean afirmacion = true;

        for(int i = 0; i < 8; i++)
            asimilador.pasarTurno();

        try {
            economia.gastarGasVespeno(40);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void unAsimiladorNoSumaGasAlNoEstarOperativo(){

        Economia economia = new Economia();

        Asimilador asimilador = new Asimilador(economia);
        boolean afirmacion = false;

        for(int i = 0; i < 5; i++)
            asimilador.pasarTurno();

        try {
            economia.gastarGasVespeno(20);
        }catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }
}
