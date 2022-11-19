package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.tiles.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestConstrucciones {

    private FloorManager fm = new FloorManager( (new LinkedList<Moho>()), new LinkedList<Cristales>(),new LinkedList< Volcan >(), new LinkedList<Energia>(),
            new LinkedList< TileVacia >(), new LinkedList<ConstruccionZerg>(), new LinkedList<ConstruccionProtoss>(),
            new LinkedList<ExtraeRecurso>(),20, 20);

    @Test
    public void construirLuegoDeConstruirYsinTenerMineralsLanzaUnaExcepcion(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(150);
        Extractor extractor = new Extractor(economia, new Posicion(0,0));
        Criadero criadero = new Criadero(economia, new Posicion(0,0));
        criadero.setFloorManager(fm);
        criadero.pasarTurno();criadero.pasarTurno();criadero.pasarTurno();criadero.pasarTurno();

        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();

        try{
            Extractor extractorDos = new Extractor(economia, new Posicion(0,0));
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);



    }
    @Test
    public void construirLuegoDeConstruirSinZanganosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(150);
        Extractor extractor = new Extractor(economia, new Posicion(2,2));
        Criadero criadero = new Criadero(economia, new Posicion(0,0));
        criadero.setFloorManager(fm);
        criadero.pasarTurno();criadero.pasarTurno();criadero.pasarTurno();criadero.pasarTurno();

        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();

        try{
            Extractor extractorDos = new Extractor(economia, new Posicion(0,0));
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);

    }

    @Test
    public void construirRecolectandoFuncionaBien(){
        boolean afirmacion = true;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(350);
        Extractor extractor = new Extractor(economia, new Posicion(0,0));
        extractor.setRecurso(new Volcan(new Posicion(0,0)));
        Criadero criadero = new Criadero(economia, new Posicion(0,0));
        criadero.setFloorManager(fm);

        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();



        extractor.agregarZangano(criadero);
        extractor.agregarZangano(criadero);

        for (int i = 0; i<5 ;i++ ){
            extractor.pasarTurno();
        }

        try{
            Guarida guarida = new Guarida(economia, new Posicion(0,0));
        }
        catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);



    }

    @Test
    public void construirSinMineralesProtossLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(250);
        Asimilador asimilador = new Asimilador(economia, new Posicion(0,0));


        for (int i = 0; i<1 ;i++ ){
            asimilador.pasarTurno();
        }

        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, new Posicion(0,0));
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);



    }

    @Test
    public void construirRecolectandoMineralesProtossNoLanzaError(){
        boolean afirmacion = true;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(250);
        Asimilador asimilador = new Asimilador(economia, new Posicion(0,0));
        asimilador.setRecurso(new Volcan(new Posicion(0,0)));

        for (int i = 0; i<14 ;i++ ){
            asimilador.pasarTurno();
        }

        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, new Posicion(0,0));
        }
        catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);

    }
    // TODO :)
}
