package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestConstruccionZerg {

    private ConstruccionZerg construccionZerg;
    private static final Economia mockEconomia = new MockEconomia();

    @BeforeEach
    public void initEach() {
         construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, 0, 0);
    }

    @Test
    public void danioUnaConstruccionZergYElDanioEsCorrecto() {
        Assertions.assertEquals(100, construccionZerg.daniar(100));
    }

    @Test
    public void danioUnaConstruccionZergPorMasDeLaVidaMaximaYElDanioEsCorrecto() {
        Assertions.assertEquals(100, construccionZerg.daniar(100));
        Assertions.assertEquals(900, construccionZerg.daniar(1000));
    }

    @Test
    public void curoUnaConstruccionZergYLaCuracionEsLaCorrecta() {
        Assertions.assertEquals(20, construccionZerg.daniar(20));
        Assertions.assertEquals(70, construccionZerg.daniar(70));
        Assertions.assertEquals(90, construccionZerg.curar());
    }

    @Test
    public void creoUnaConstruccionZergConCostoMineralMayorAlQueTengoYTiraExcepcion() {
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionZerg(100, 100, 100, 50, economia, 0, 0));
    }

    @Test
    public void creoUnaConstruccionZergConCostoGasMayorAlQueTengoYTiraExcepcion() {
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionZerg(100, 100, 20, 200, economia, 0, 0));
    }
}
