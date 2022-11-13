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
        Posicion posicion = new Posicion(5,5);
        manager.construirCriaderoEn(posicion, new Criadero(economia, posicion));

        boolean afirmacion = true;

        int posicion_x = 0;// 5 - 5 = 0
        int posicion_y = 0;
        int topeX = 11;// 5 + 6 = 11
        int topeY = 11;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 5 || j != 5) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(new Posicion(i, j), new Espiral(economia, new Posicion(i, j)));
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
        Posicion pos = new Posicion(3,3);
        manager.construirCriaderoEn(pos, new Criadero(economia, pos ) );

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 5 = 0 --> 0
        int posicion_y = 0;
        int topeX = 9;// 3 + 6 = 9
        int topeY = 9;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 3) {//para que no construya sobre el criadero
                   try{
                        pos = new Posicion(i,j);
                        manager.construirZerg(pos, new Guarida(economia, pos));
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
        Posicion pos = new Posicion(3, 17);
        manager.construirCriaderoEn(pos, new Criadero(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 5 = 0 --> 0
        int posicion_y = 12;
        int topeX = 9;// 3 + 6 = 9
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 17) {//para que no construya sobre el criadero
                    try {
                        pos = new Posicion(i,j);
                        manager.construirZerg(pos, new Guarida(economia, pos));
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
        Posicion pos = new Posicion(17 ,3);
        manager.construirCriaderoEn(pos, new Criadero(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 12;// 3 - 5 = 0 --> 0
        int posicion_y = 0;
        int topeX = 20;// 3 + 6 = 9
        int topeY = 9;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 17 || j != 3) {//para que no construya sobre el criadero
                    try {
                        pos =new Posicion(i,j);
                        manager.construirZerg(pos, new Guarida(economia, pos));
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
        Posicion pos = new Posicion(17, 17);
        manager.construirCriaderoEn(pos, new Criadero(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 12;// 3 - 5 = 0 --> 0
        int posicion_y = 12;
        int topeX = 20;// 3 + 6 = 9
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 17 || j != 17) {//para que no construya sobre el criadero
                    try {
                        pos =new Posicion(i, j);
                        manager.construirZerg(pos, new Guarida(economia, pos));
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
        Posicion pos = new Posicion(3,3);
        manager.construirPilonEn(pos, new Pilon(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 3 = 0 --> 0
        int posicion_y = 0;
        int topeX = 7;// 3 + 4 = 7
        int topeY = 7;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 3) {//para que no construya sobre el criadero
                    try {
                        pos = new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
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
        Posicion pos = new Posicion(1,1);
        manager.construirPilonEn(pos, new Pilon(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 3 = 0 --> 0
        int posicion_y = 0;
        int topeX = 5;// 3 + 4 = 5
        int topeY = 5;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 1 || j != 1) {//para que no construya sobre el criadero
                    try {
                        pos = new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
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
        Posicion pos = new Posicion(1,18);
        manager.construirPilonEn(pos, new Pilon(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 3 = 0 --> 0
        int posicion_y = 15;
        int topeX = 5;// 3 + 4 = 5
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 1 || j != 18) {//para que no construya sobre el criadero
                    try {
                        pos = new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
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
        Posicion pos = new Posicion(18, 1);
        manager.construirPilonEn(pos, new Pilon(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 15;// 3 - 3 = 0 --> 0
        int posicion_y = 0;
        int topeX = 20;// 3 + 4 = 5
        int topeY = 5;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 18 || j != 1) {//para que no construya sobre el criadero
                    try {
                        pos = new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
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
        Posicion pos =new Posicion(18, 18);
        manager.construirPilonEn(pos, new Pilon(economia, pos));

        boolean afirmacion = true;

        int posicion_x = 15;// 3 - 3 = 0 --> 0
        int posicion_y = 15;
        int topeX = 20;// 3 + 4 = 5
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 18 || j != 18) {//para que no construya sobre el criadero
                    try {
                        pos = new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
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
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos2 = new Posicion (5, 5);
        manager.agregarCristales(pos1);
        manager.agregarVolcanes(pos2);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirEstructuraDeVolcan(pos1, new Asimilador(economia, pos1))
        );
        assertEquals("No hay un volcan en la posicion", exception.getMessage());
    }

    @Test
    public void intentoConstruirAsimiladorSobreVolcanYPuedo() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos2 = new Posicion (5, 5);
        manager.agregarCristales(pos1);
        manager.agregarVolcanes(pos2);
        assertDoesNotThrow(() -> manager.construirEstructuraDeVolcan(pos2, new Asimilador(economia, pos2)));
    }


    @Test
    public void intentoConstruirNexoMineralSobreVolcanYNoPuedo() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos2 = new Posicion (5, 5);
        manager.agregarCristales(pos1);
        manager.agregarVolcanes(pos2);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirEstructuraDeCristales(pos2, new NexoMineral(economia, pos2))
        );
        assertEquals("No hay un mineral en la posicion", exception.getMessage());
    }

    @Test
    public void intentoConstruirNexoMineralSobreCristalYPuedo() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos2 = new Posicion (5, 5);
        manager.agregarCristales(pos1);
        manager.agregarVolcanes(pos2);
        assertDoesNotThrow(() -> manager.construirEstructuraDeCristales(pos1, new NexoMineral(economia, pos1)));
    }

    @Test
    public void intentoConstruirProtossSinEnergiaYNoPuedo() {
        Posicion pos2 = new Posicion (5, 5);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirProtoss(pos2, new Acceso(economia, pos2))
        );
        assertEquals("No esta energizada esta posicion", exception.getMessage());
    }

    @Test
    public void intentoConstruirProtossDespuesDeUnPilonYNoFalla() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos3 = new Posicion(12, 12);
        manager.construirPilonEn(pos1, new Pilon(economia, pos1));
        String afirmacion = "Todo ok";
        try {
            manager.construirProtoss(pos3, new Acceso(economia, pos3));
        } catch (RuntimeException e) {
            afirmacion = e.getMessage();
        }
        assertEquals("Todo ok", afirmacion);
    }

    /**

    @Test
    public void intentoDestruirUnProtossYEfectivamenteLoDestruye() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos3 = new Posicion(12, 12);
        Posicion posMock = new Posicion(12 ,12);
        manager.construirPilonEn(pos1, new Pilon(economia, pos1));
        manager.construirProtoss(pos3, new Acceso(economia, pos3));
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
        Posicion pos1 = new Posicion(11, 11);
        manager.construirPilonEn(posMock, new Pilon(economia, posMock));
        manager.destruirProtoss(posMock);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirProtoss(pos1, new Acceso(economia,pos1))
        );
        assertEquals("No esta energizada esta posicion", exception.getMessage());
    }
    */

}