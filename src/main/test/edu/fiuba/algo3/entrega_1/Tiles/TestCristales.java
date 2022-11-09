package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.tiles.Cristales;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestCristales {
    @Test
    public void construyoUnCriaderoSobreLosCristalesYTiraExcepcion() {
        final Cristales cristal = new Cristales();
        Assertions.assertThrows(RuntimeException.class, () -> cristal.buildOn(new Criadero() ) );
    }

    @Test
    public void construyoUnNexoMineralSobreLosCristalesYDevuelveCorrectamente() {
        final Cristales cristal = new Cristales();
        cristal.buildOn(new NexoMineral( ) );
        Assertions.assertNotNull(cristal.getConstruccionEncima() );
    }
}
