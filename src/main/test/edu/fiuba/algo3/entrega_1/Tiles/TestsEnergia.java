package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.Moho;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsEnergia {

    @Test
    public void construyoUnCriaderoSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Criadero() ) );
    }

    @Test
    public void construyoUnaEspiralSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Espiral() ) );
    }

    @Test
    public void construyoUnaGuaridaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Guarida() ) );
    }

    @Test
    public void construyoUnaReservaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new ReservaDeReproduccion() ) );
    }

    @Test
    public void construyoUnPilonSobreEnergiaYSeDevuelveCorrectamente() {
        final Energia energia = new Energia();
        energia.buildOn(new Pilon() );
        Assertions.assertNotNull(energia.getConstruccionEncima() );
    }

    @Test
    public void construyoUnAccesoSobreEnergiaYSeDevuelveCorrectamente() {
        final Energia energia = new Energia();
        energia.buildOn(new Acceso() );
        Assertions.assertNotNull(energia.getConstruccionEncima() );
    }

    @Test
    public void construyoUnNexoSobreEnergiaYSeDevuelveCorrectamente() {
        final Energia energia = new Energia();
        energia.buildOn(new NexoMineral() );
        Assertions.assertNotNull(energia.getConstruccionEncima() );
    }

    @Test
    public void construyoUnPuertoEstelarSobreEnergiaYSeDevuelveCorrectamente() {
        final Energia energia = new Energia();
        energia.buildOn(new PuertoEstelar() );
        Assertions.assertNotNull(energia.getConstruccionEncima() );
    }

}
