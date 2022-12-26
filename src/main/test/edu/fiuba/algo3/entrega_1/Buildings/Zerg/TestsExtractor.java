package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.mocks.CriaderoActivo;
import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestsExtractor {

    private static final Economia mockEconomia = new MockEconomia();

    private Manager manager = new Manager(20, 20);

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
            unExtractor.agregarZangano(manager);
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
            unExtractor.agregarZangano(manager);
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
        unExtractor.agregarZangano(manager);

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
        unExtractor.agregarZangano(manager );
        unExtractor.agregarZangano(manager );

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
        unExtractor.agregarZangano(manager );
        unExtractor.agregarZangano(manager );
        unExtractor.agregarZangano(manager );

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

        unExtractor.agregarZangano(manager);
        unExtractor.agregarZangano(manager);
        unExtractor.agregarZangano(manager);
        unExtractor.agregarZangano(manager);

        unExtractor.pasarTurno();

        try {
            economia.gastarGasVespeno(40); //compruebo que no se agrego un cuarto zangano porque la produccion
        }catch (RuntimeException e){       //de gas al pasar el turno fue de como si solo hubiese 3 zanganos.
            afirmacion= true;              //
        }

        assert(afirmacion);
    }



    @Test
    public void alEliminarseElExtractorTambienLoHacenSusZanganos() {

        Extractor extractor = new Extractor(mockEconomia, new Posicion(17, 15));
        manager.construirExtractor(new Posicion(17, 15),  extractor);
        extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();

        Acceso acceso = new Acceso(mockEconomia, new Posicion(6,6));
        manager.construirProtoss(new Posicion(6,6), acceso);
        acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();

        Dragon dragon =new Dragon(mockEconomia, new Posicion(6,6));
        manager.crearProtoss(new Posicion(6,6), dragon);
        dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();

        manager.moverUnidad(new Posicion(17,14), dragon);

        extractor.agregarZangano(manager);
        extractor.agregarZangano(manager);
        extractor.agregarZangano(manager);

        for(int i=0; i < 38; i++)
            manager.unidadAtacaConstruccion(Raza.PROTOSS, dragon, extractor);

        Extractor extractor2 = new Extractor(mockEconomia, new Posicion(17, 15));

        assertDoesNotThrow( ()->    manager.construirExtractor(new Posicion(17, 15),  extractor2));
    }
}
