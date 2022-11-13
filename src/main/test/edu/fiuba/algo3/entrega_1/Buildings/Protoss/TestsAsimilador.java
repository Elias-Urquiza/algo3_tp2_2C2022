package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.tiles.Volcan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestsAsimilador {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unAsimiladorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){


        Asimilador asimilador = new Asimilador(mockEconomia, new Posicion(0,0));
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
        final Asimilador asimilador = new Asimilador(mockEconomia, new Posicion(0,0));
        Assertions.assertThrows(RuntimeException.class, () -> asimilador.usar());
    }

    @Test
    public void unAsimiladorSumaGasAlEstarOperativo(){
        Economia economia = new Economia();
        economia.ingresarMineral(100);
        Asimilador asimilador = new Asimilador(economia, new Posicion(0,0));
        asimilador.setRecurso(new Volcan(new Posicion(0,0)));
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
        economia.ingresarMineral(100);
        Asimilador asimilador = new Asimilador(economia, new Posicion(0,0));
        asimilador.setRecurso(new Volcan(new Posicion(0,0)));
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
        economia.ingresarMineral(100);
        Asimilador asimilador = new Asimilador(economia, new Posicion(0,0));
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
