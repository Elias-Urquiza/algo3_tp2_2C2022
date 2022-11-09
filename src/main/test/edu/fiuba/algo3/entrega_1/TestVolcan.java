package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.Volcan;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestVolcan {
    @Test
    public void construyoUnCriaderoSobreElVolcanYTiraExcepcion() {
        final Volcan volcan = new Volcan();
        Assertions.assertThrows(RuntimeException.class, () -> volcan.buildOn(new Criadero() ) );
    }

    @Test
    public void construyoUnExtractorSobreElVolcanYDevuelveCorrectamente() {
        final Volcan volcan = new Volcan();
        volcan.buildOn(new Extractor( new Economia() ) );
        Assertions.assertNotNull(volcan.getConstruccionEncima() );
    }

    @Test
    public void construyoUnAsimiladorSobreElVolcanYDevuelveCorrectamente() {
        final Volcan volcan = new Volcan();
        volcan.buildOn(new Asimilador(new Economia()));
        Assertions.assertNotNull(volcan.getConstruccionEncima());
    }
}
