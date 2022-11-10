package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestConstruccionZerg {

    @Test
    public void danioUnaConstruccionZergYElDanioEsCorrecto() {
        final ConstruccionZerg construccionZerg = new ConstruccionZerg(1000);
        Assertions.assertEquals(100, construccionZerg.daniar(100));
    }

    @Test
    public void danioUnaConstruccionZergPorMasDeLaVidaMaximaYElDanioEsCorrecto() {
        final ConstruccionZerg construccionZerg = new ConstruccionZerg(1000);
        Assertions.assertEquals(100, construccionZerg.daniar(100));
        Assertions.assertEquals(900, construccionZerg.daniar(1000));
    }

    @Test
    public void curoUnaConstruccionZergYLaCuracionEsLaCorrecta() {
        final ConstruccionZerg construccionZerg = new ConstruccionZerg(1000);
        Assertions.assertEquals(20, construccionZerg.daniar(20));
        Assertions.assertEquals(70, construccionZerg.daniar(70));
        Assertions.assertEquals(90, construccionZerg.curar());
    }
}
