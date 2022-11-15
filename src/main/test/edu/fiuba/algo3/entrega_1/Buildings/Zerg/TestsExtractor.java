package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.mocks.CriaderoActivo;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsExtractor {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unExtractorSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){
        Extractor unExtractor = new Extractor(mockEconomia, new Posicion(0,0));
        boolean afirmacion = true;

        for(int i = 0; i < 6; i++)
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
        Economia economia = new Economia();
        final Extractor extractor = new Extractor(economia, new Posicion(0,0));
        Assertions.assertThrows(RuntimeException.class, () -> extractor.usar());
    }

    @Test
    public void seAgregaUnZanganoCorrectamente(){
        Economia economia = new Economia();
        Extractor unExtractor = new Extractor(economia, new Posicion(0,0));
        CriaderoActivo criaderoActivo = new CriaderoActivo();
        boolean afirmacion = true;

        for(int i = 0; i < 6; i++)
            unExtractor.pasarTurno();

        try{
            unExtractor.agregarZangano(criaderoActivo);
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }



    @Test
    public void elCriaderoDelCualSeSacaAlZanganoNoTieneLarvasSeLanzaExcepcion(){
        Economia economia = new Economia();
        Extractor unExtractor = new Extractor(economia, new Posicion(0,0));
        CriaderoActivo criaderoActivo = new CriaderoActivo();
        boolean afirmacion = false;

        for(int i = 0; i < 6; i++)
            unExtractor.pasarTurno();

        criaderoActivo.extraerLarvas(3);

        try{
            unExtractor.agregarZangano(criaderoActivo);
        }catch (RuntimeException e){
            afirmacion = true;
        }

        assert(afirmacion);
    }

    @Test
    public void despuesDeUnTurnoElExtractorRecolecto10DeGasSiTieneUnZangano(){
        Economia economia = new Economia()               ;
        Extractor unExtractor = new Extractor(economia, new Posicion(0,0))  ;

        boolean afirmacion = true;

        for(int i = 0; i < 6; i++)
            unExtractor.pasarTurno(); // se activa el Extractor.
        unExtractor.agregarZangano(new CriaderoActivo() );

        unExtractor.pasarTurno();

        try {
            economia.gastarGasVespeno(10);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void despuesDeUnTurnoElExtractorRecolecto20DeGasSiTieneDosZanganos(){
        Economia economia = new Economia()               ;
        Extractor unExtractor = new Extractor(economia, new Posicion(0,0))  ;

        boolean afirmacion = true;

        for(int i = 0; i < 6; i++)
            unExtractor.pasarTurno(); // se activa el Extractor.
        unExtractor.agregarZangano(new CriaderoActivo() );
        unExtractor.agregarZangano(new CriaderoActivo() );

        unExtractor.pasarTurno();

        try {
            economia.gastarGasVespeno(20);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void despuesDeUnTurnoElExtractorRecolecto30DeGasSiTieneTresZanganos(){
        Economia economia = new Economia()               ;
        Extractor unExtractor = new Extractor(economia, new Posicion(0,0))  ;

        boolean afirmacion = true;

        for(int i = 0; i < 6; i++)
            unExtractor.pasarTurno(); // se activa el Extractor.
        unExtractor.agregarZangano(new CriaderoActivo() );
        unExtractor.agregarZangano(new CriaderoActivo() );
        unExtractor.agregarZangano(new CriaderoActivo() );

        unExtractor.pasarTurno();

        try {
            economia.gastarGasVespeno(30);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void NoSePuedeAgregaUnZanganoMasCuandoYaHayTres(){
        Economia economia = new Economia();
        Extractor unExtractor = new Extractor(economia, new Posicion(0,0));
        CriaderoActivo criaderoActivo = new CriaderoActivo();
        boolean afirmacion = false;

        for(int i = 0; i < 6; i++)
            unExtractor.pasarTurno();

        unExtractor.agregarZangano(criaderoActivo);
        unExtractor.agregarZangano(criaderoActivo);
        unExtractor.agregarZangano(criaderoActivo);
        unExtractor.agregarZangano(new CriaderoActivo());

        unExtractor.pasarTurno();

        try {
            economia.gastarGasVespeno(40); //compruebo que no se agrego un cuarto zangano porque la produccion
        }catch (RuntimeException e){       //de gas al pasar el turno fue de como si solo hubiese 3 zanganos.
            afirmacion= true;              //
        }

        assert(afirmacion);
    }
}
