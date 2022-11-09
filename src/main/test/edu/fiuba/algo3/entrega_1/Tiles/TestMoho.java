package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.tiles.Moho;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestMoho {
    @Test
    public void construyoUnPilonSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new Pilon(), guardar) );
    }

    @Test
    public void construyoUnAccesoSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new Acceso(), guardar ) );
    }

    @Test
    public void construyoUnNexoSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new NexoMineral(), guardar) );
    }
    @Test
    public void construyoUnPuertoEstelarSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new PuertoEstelar(), guardar) );
    }

    @Test
    public void construyoUnCriaderoSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        Construccion guardar = null;
        Criadero criadero = new Criadero();
        boolean afirmacion = true;

        try{
            moho.buildOn(new Criadero(), guardar );
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnaEspiralSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        Espiral espiral = new Espiral();
        Construccion guardar = null;
        boolean afirmacion = true;

        try{
            moho.buildOn(espiral, guardar);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnaGuaridaSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        Guarida guarida = new Guarida();
        Construccion guardar = null;
        boolean afirmacion = true;
        
        try{
            moho.buildOn(guarida, guardar);
        }catch (RuntimeException e){
            afirmacion = false;
        }

    }
    @Test
    public void construyoUnaReservaSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Construccion guardar = null;
        boolean afirmacion = true;

        try{
            moho.buildOn(reserva, guardar);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }


}
