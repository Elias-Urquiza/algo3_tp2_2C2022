package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

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

    @Test
    public void unExtractorNoSePuedeExtraerSinZanganosYaConstruido(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = false;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();

        try{
            unExtractor.extraer();
        }catch (RuntimeException e){
            afirmacion = true;
        }

        assert(afirmacion);
    }

    @Test
    public void unExtractorPuedeSumarZanganosTeniendoCero(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = true;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();



        try{
            unExtractor.agregarZangano();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void unExtractorPuedeSumarZanganosTeniendoUno(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = true;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();

        unExtractor.agregarZangano();



        try{
            unExtractor.agregarZangano();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void unExtractorPuedeSumarZanganosTeniendoDos(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = true;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();

        unExtractor.agregarZangano();
        unExtractor.agregarZangano();



        try{
            unExtractor.agregarZangano();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void unExtractorNoPuedeSumarZanganosTeniendoTres(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = false;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();

        unExtractor.agregarZangano();
        unExtractor.agregarZangano();
        unExtractor.agregarZangano();



        try{
            unExtractor.agregarZangano();
        }catch (RuntimeException e){
            afirmacion = true;
        }

        assert(afirmacion);
    }

    @Test
    public void unExtractorNoPuedeExtraerGasTeniendoCeroZanganos(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = false;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();





        try{
            unExtractor.extraer();
        }catch (RuntimeException e){
            afirmacion = true;
        }

        assert(afirmacion);
    }

    @Test
    public void unExtractorPuedeExtraerGasTeniendoUnZangano(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = true;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.agregarZangano();

        try{
            unExtractor.extraer();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        if(unExtractor.cantidadDeGas() != 10){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void unExtractorPuedeExtraerGasTeniendoDosZangano(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = true;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.agregarZangano();
        unExtractor.agregarZangano();

        try{
            unExtractor.extraer();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        if(unExtractor.cantidadDeGas() != 20){
            afirmacion = false;
        }

        assert(afirmacion);
    }
    @Test
    public void unExtractorPuedeExtraerGasTeniendoTresZangano(){

        Extractor unExtractor = new Extractor();
        boolean afirmacion = true;

        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.pasarTurno();
        unExtractor.agregarZangano();
        unExtractor.agregarZangano();
        unExtractor.agregarZangano();
        unExtractor.extraer();



        if(unExtractor.cantidadDeGas() != 30){
            afirmacion = false;
        }

        assert(afirmacion);
    }


}
