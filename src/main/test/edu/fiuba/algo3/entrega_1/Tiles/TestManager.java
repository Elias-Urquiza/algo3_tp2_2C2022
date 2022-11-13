package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.tiles.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestManager {

    private Manager manager;
    private static final Economia economia = new MockEconomia();
    private static int X = 0;
    private static int Y = 0;

    @BeforeEach
    public void initEach() {
        manager = new Manager(20, 20);
    }

    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoSinCasoBorde() {
        manager.construirCriaderoEn(5, 5, new Criadero(economia, 5, 5));

        boolean afirmacion = true;

        int posicion_x = 0;// 5 - 5 = 0
        int posicion_y = 0;
        int topeX = 11;// 5 + 6 = 11
        int topeY = 11;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 5 || j != 5) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(i, j, new Espiral(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }
        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoEnCasoBordeArribaIzquierda() {
        manager.construirCriaderoEn(3, 3, new Criadero(economia, 3, 3));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 5 = 0 --> 0
        int posicion_y = 0;
        int topeX = 9;// 3 + 6 = 9
        int topeY = 9;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 3) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(i, j, new Guarida(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoEnCasoBordeArribaDerecha() {
        manager.construirCriaderoEn(3, 17, new Criadero(economia, 3, 17));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 5 = 0 --> 0
        int posicion_y = 12;
        int topeX = 9;// 3 + 6 = 9
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 17) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(i, j, new Guarida(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoEnCasoBordeAbajoIzquierda() {
        manager.construirCriaderoEn(17, 3, new Criadero(economia, 17, 3));

        boolean afirmacion = true;

        int posicion_x = 12;// 3 - 5 = 0 --> 0
        int posicion_y = 0;
        int topeX = 20;// 3 + 6 = 9
        int topeY = 9;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 17 || j != 3) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(i, j, new Guarida(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }


    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoEnCasoBordeAbajoDerecha() {
        manager.construirCriaderoEn(17, 17, new Criadero(economia, 17, 17));

        boolean afirmacion = true;

        int posicion_x = 12;// 3 - 5 = 0 --> 0
        int posicion_y = 12;
        int topeX = 20;// 3 + 6 = 9
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 17 || j != 17) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(i, j, new Guarida(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }



    @Test
    public void seConstruyeUnPilonYSeEnergizaLaZonaCorrespondiente() {
        manager.construirPilonEn(3, 3, new Pilon(economia, 3, 3));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 3 = 0 --> 0
        int posicion_y = 0;
        int topeX = 7;// 3 + 4 = 7
        int topeY = 7;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 3) {//para que no construya sobre el criadero
                    try {
                        manager.construirProtoss(i, j, new Acceso(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void seConstruyeUnPilonYSeEnergizaLaZonaArribaIzquierda() {
        manager.construirPilonEn(1, 1, new Pilon(economia, 1, 1));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 3 = 0 --> 0
        int posicion_y = 0;
        int topeX = 5;// 3 + 4 = 5
        int topeY = 5;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 1 || j != 1) {//para que no construya sobre el criadero
                    try {
                        manager.construirProtoss(i, j, new Acceso(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }
        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void seConstruyeUnPilonYSeEnergizaLaZonaArribaDerecha() {
        manager.construirPilonEn(1, 18, new Pilon(economia, 1, 18));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 3 = 0 --> 0
        int posicion_y = 15;
        int topeX = 5;// 3 + 4 = 5
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 1 || j != 18) {//para que no construya sobre el criadero
                    try {
                        manager.construirProtoss(i, j, new Acceso(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }
        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void seConstruyeUnPilonYSeEnergizaLaZonaAbajoIzquierda() {
        manager.construirPilonEn(18, 1, new Pilon(economia, 18, 1));

        boolean afirmacion = true;

        int posicion_x = 15;// 3 - 3 = 0 --> 0
        int posicion_y = 0;
        int topeX = 20;// 3 + 4 = 5
        int topeY = 5;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 18 || j != 1) {//para que no construya sobre el criadero
                    try {
                        manager.construirProtoss(i, j, new Acceso(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }
        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void seConstruyeUnPilonYSeEnergizaLaZonaAbajoDerecha() {
        manager.construirPilonEn(18, 18, new Pilon(economia, 18, 18));

        boolean afirmacion = true;

        int posicion_x = 15;// 3 - 3 = 0 --> 0
        int posicion_y = 15;
        int topeX = 20;// 3 + 4 = 5
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 18 || j != 18) {//para que no construya sobre el criadero
                    try {
                        manager.construirProtoss(i, j, new Acceso(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }
        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert (afirmacion);
    }

    @Test
    public void intentoConstruirAsimiladorSobreCristalYNoPuedo() {
        manager.agregarCristales(10, 10);
        manager.agregarVolcanes(5, 5);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirEstructuraDeVolcan(10, 10, new Asimilador(economia, 10, 10))
        );
        assertEquals("No hay un volcan en la posicion", exception.getMessage());
    }

    @Test
    public void intentoConstruirAsimiladorSobreVolcanYPuedo() {
        manager.agregarCristales(10, 10);
        manager.agregarVolcanes(5, 5);
        assertDoesNotThrow(() -> manager.construirEstructuraDeVolcan(5, 5, new Asimilador(economia, 5, 5)));
    }


    @Test
    public void intentoConstruirNexoMineralSobreVolcanYNoPuedo() {
        manager.agregarCristales(10, 10);
        manager.agregarVolcanes(5, 5);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirEstructuraDeCristales(5, 5, new NexoMineral(economia, 5, 5))
        );
        assertEquals("No hay un mineral en la posicion", exception.getMessage());
    }

    @Test
    public void intentoConstruirNexoMineralSobreCristalYPuedo() {
        manager.agregarCristales(10, 10);
        manager.agregarVolcanes(5, 5);
        assertDoesNotThrow(() -> manager.construirEstructuraDeCristales(10, 10, new NexoMineral(economia, 10, 10)));
    }

    @Test
    public void intentoConstruirProtossSinEnergiaYNoPuedo() {
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirProtoss(5, 5, new Acceso(economia, 5, 5))
        );
        assertEquals("No esta energizada esta posicion", exception.getMessage());
    }

    @Test
    public void intentoConstruirProtossDespuesDeUnPilonYNoFalla() {
        manager.construirPilonEn(10, 10, new Pilon(economia, 10, 10));
        String afirmacion = "Todo ok";
        try {
            manager.construirProtoss(12, 12, new Acceso(economia, 12, 12));
        } catch (RuntimeException e) {
            afirmacion = e.getMessage();
        }
        assertEquals("Todo ok", afirmacion);
    }


    @Test
    public void intentoDestruirUnProtossYEfectivamenteLoDestruye() {
        Posicion posMock = new Posicion(12 ,12);
        manager.construirPilonEn(10, 10, new Pilon(economia, 10, 10));
        manager.construirProtoss(12, 12, new Acceso(economia, 12, 12));
        manager.destruirProtoss(posMock);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.destruirProtoss(posMock)
        );
        assertEquals("No hay nada para destruir", exception.getMessage());
    }

    @Test
    public void intentoDestruirUnPilonYNoPuedoConstruirOtraConstruccionProtoss() {
        Posicion posMock = new Posicion(10 ,10);
        manager.construirPilonEn(10, 10, new Pilon(economia, 10, 10));
        manager.destruirProtoss(posMock);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirProtoss(11, 11, new Acceso(economia, 11, 11))
        );
        assertEquals("No esta energizada esta posicion", exception.getMessage());
    }

}