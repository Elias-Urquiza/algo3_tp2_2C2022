package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.tiles.Moho;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestMoho {
    /*
    @Test
    public void construyoUnPilonSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new Pilon()) );
    }
    @Test
    public void construyoUnAccesoSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new Acceso()) );
    }

    @Test
    public void construyoUnNexoSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new NexoMineral()) );
    }
    @Test
    public void construyoUnPuertoEstelarSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new PuertoEstelar()) );
    }

    @Test
    public void construyoUnCriaderoSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            moho.buildOn(new Criadero());
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnaEspiralSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            moho.buildOn(new Espiral());
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnaGuaridaSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            moho.buildOn(new Guarida());
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert (afirmacion);
    }
    @Test
    public void construyoUnaReservaSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            moho.buildOn(new ReservaDeReproduccion());
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    /*
    @Test
    public  void elMohoPasadoDosTurnosCrece(){
        Criadero criadero = new Criadero();
        Tablero unTablero = new Tablero(20, 20);

        unTablero.construirEn(5,5, criadero);

        unTablero.pasarTurno();
        unTablero.pasarTurno();



    }*/

    }
