package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Volcan;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;



import org.junit.jupiter.api.Assertions;


public class TestMoho {
    @Test
    public void construyoUnPilonSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new Pilon()) );
    }

    @Test
    public void construyoUnNexoSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new NexoMineral()) );
    }
    @Test
    public void construyoUnPuertoEstelarSobreElMohoYTiraExcepcion() {
        final Moho moho = new Moho();
        Assertions.assertThrows(RuntimeException.class, () -> moho.buildOn(new PuertoEstelar()) );
    }

    @Test
    public void construyoUnCriaderoSobreElMohoYDevuelveCorrectamente() {
        final Moho moho = new Moho();
        moho.buildOn(new Criadero() );
        Assertions.assertNotNull(moho.getConstruccionEncima() );
    }

    @Test
    public void construyoUnaEspiralSobreElMohoYDevuelveCorrectamente() {
        final Moho moho = new Moho();
        moho.buildOn(new Espiral());
        Assertions.assertNotNull(moho.getConstruccionEncima() );
    }

    @Test
    public void construyoUnaGuaridaSobreElMohoYDevuelveCorrectamente() {
        final Moho moho = new Moho();
        moho.buildOn(new Guarida());
        Assertions.assertNotNull(moho.getConstruccionEncima() );
    }
    @Test
    public void construyoUnaReservaSobreElMohoYDevuelveCorrectamente() {
        final Moho moho = new Moho();
        moho.buildOn(new ReservaDeReproduccion());
        Assertions.assertNotNull(moho.getConstruccionEncima() );
    }
}
