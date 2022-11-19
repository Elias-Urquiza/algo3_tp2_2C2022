package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestConstruccionZerg {

    private ConstruccionZerg construccionZerg;
    private static final Economia mockEconomia = new MockEconomia();



    @Test
    public void danioUnaConstruccionZergYElDanioEsCorrecto() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        Assertions.assertEquals(100, construccionZerg.recibirDanio(100));
    }

    @Test
    public void danioUnaConstruccionZergPorMasDeLaVidaMaximaYElDanioEsCorrecto() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        Assertions.assertEquals(100, construccionZerg.recibirDanio(100));
        Assertions.assertEquals(900, construccionZerg.recibirDanio(1000));
    }

    @Test
    public void curoUnaConstruccionZergYLaCuracionEsLaCorrecta() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        Assertions.assertEquals(20, construccionZerg.recibirDanio(20));
        Assertions.assertEquals(70, construccionZerg.recibirDanio(70));
        Assertions.assertEquals(90, construccionZerg.curar());
    }

    @Test
    public void creoUnaConstruccionZergConCostoMineralMayorAlQueTengoYTiraExcepcion() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionZerg(100, 100, 100, 50, economia, new Posicion(0,0)));
    }

    @Test
    public void creoUnaConstruccionZergConCostoGasMayorAlQueTengoYTiraExcepcion() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionZerg(100, 100, 20, 200, economia, new Posicion(0,0)));
    }
}
