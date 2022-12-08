package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;


public class TestConstruccionZerg {

    private ConstruccionZerg construccionZerg;
    private static final Economia mockEconomia = new MockEconomia();
    private static Ataque terrestre = new Tierra(0, 100);
    private Posicion posicionMock  = new Posicion(3, 3);


    @Test
    public void danioUnaConstruccionZergYElDanioEsCorrecto() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        Assertions.assertEquals(100, construccionZerg.recibirDanio(100, terrestre, posicionMock));
    }

    @Test
    public void danioUnaConstruccionZergPorMasDeLaVidaMaximaYElDanioEsCorrecto() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        Assertions.assertEquals(100, construccionZerg.recibirDanio(100, terrestre, posicionMock));
        Assertions.assertEquals(900, construccionZerg.recibirDanio(1000, terrestre, posicionMock));
    }

    @Test
    public void curoUnaConstruccionZergYLaCuracionEsLaCorrecta() {
        construccionZerg = new ConstruccionZerg(1000, 10, 10, 10, mockEconomia, new Posicion(0,0));
        Assertions.assertEquals(20, construccionZerg.recibirDanio(20, terrestre, posicionMock));
        Assertions.assertEquals(70, construccionZerg.recibirDanio(70, terrestre, posicionMock));
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

    @Test
    public void crearUnaConstruccionNoSePuedeSiNoHayLarvas() {
        Manager manager = new Manager(20,20);

        assertDoesNotThrow ( () -> manager.construirCriaderoEn(new Posicion(1,1), new Criadero(mockEconomia, new Posicion(1,1) ) ) );
    }

    @Test
    public void crearUnaConstruccionNoSePuedePorqueNoHayLarvas() {
        Manager manager = new Manager(20,20);
        manager.construirCriaderoEn(new Posicion(1,1), new Criadero(mockEconomia, new Posicion(1,1) ));
        manager.construirCriaderoEn(new Posicion(1,2), new Criadero(mockEconomia, new Posicion(1,2) ));
        manager.construirCriaderoEn(new Posicion(1,3), new Criadero(mockEconomia, new Posicion(1,3) ));

        RuntimeException exception = assertThrows (RuntimeException.class, () ->manager.construirCriaderoEn(new Posicion(1,4), new Criadero(mockEconomia, new Posicion(1,4) )  ) );
        assertEquals("no hay larvas para construir", exception.getMessage());
    }
}
