package edu.fiuba.algo3.entrega_1.Buildings;

import edu.fiuba.algo3.modelo.Cristales;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Volcan;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestCristales {
    @Test
    public void construyoUnCriaderoSobreCristalesYTiraExcepcion() {
        final Cristales cristal = new Cristales();
        Assertions.assertThrows(RuntimeException.class, () -> cristal.buildOn(new Criadero() ) );
    }


    @Test
    public void construyoUnExtractorSobreElVolcanYDevuelveCorrectamente() {
        final Cristales cristal = new Cristales();
        cristal.buildOn(new NexoMineral( ) );
        Assertions.assertNotNull(cristal.getConstruccionEncima() );
    }


}
