package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.tiles.Moho;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestMoho {
    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void construyoUnPilonSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new Pilon(mockEconomia)) );
    }

    @Test
    public void construyoUnAccesoSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new Acceso(mockEconomia)) );
    }

    @Test
    public void construyoUnNexoSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new NexoMineral(mockEconomia)) );
    }
    @Test
    public void construyoUnPuertoEstelarSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new PuertoEstelar(mockEconomia)) );
    }

    @Test
    public void construyoUnCriaderoSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        Criadero criadero = new Criadero(mockEconomia);
        boolean afirmacion = true;

        try{
            moho.buildOn(criadero);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnaEspiralSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        Espiral espiral = new Espiral(mockEconomia);
        boolean afirmacion = true;

        try{
            moho.buildOn(espiral);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnaGuaridaSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        Guarida guarida = new Guarida(mockEconomia);
        boolean afirmacion = true;
        
        try{
            moho.buildOn(guarida);
        }catch (RuntimeException e){
            afirmacion = false;
        }

    }
    @Test
    public void construyoUnaReservaSobreElMohoYNoHayProblema() {
        final Moho moho = new Moho();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(mockEconomia);
        boolean afirmacion = true;

        try{
            moho.buildOn(reserva);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }


}
