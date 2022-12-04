package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

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
        Criadero criadero = new Criadero(economia, posicion );
        manager.construirCriaderoEn(posicion, criadero);
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        boolean afirmacion = true;

        int posicion_x = 0;// 5 - 5 = 0
        int posicion_y = 0;
        int topeX = 11;// 5 + 6 = 11
        int topeY = 11;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 5 || j != 5) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(new Posicion(i, j), new ReservaDeReproduccion(economia, new Posicion(i, j)));
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
        Criadero criadero = new Criadero(economia, pos );
        manager.construirCriaderoEn(pos, criadero );
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
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
                        manager.construirZerg(pos, new ReservaDeReproduccion(economia, pos));
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
        Criadero criadero = new Criadero(economia, pos );
        manager.construirCriaderoEn(pos, criadero );
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

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
                        manager.construirZerg(pos, new ReservaDeReproduccion(economia, pos));
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
        Criadero criadero = new Criadero(economia, pos );
        manager.construirCriaderoEn(pos,criadero );
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

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
                        manager.construirZerg(pos, new ReservaDeReproduccion(economia, pos));
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
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoParaCristales() {
        boolean afirmacion = true;
        Posicion pos = new Posicion(17 ,3);
        Posicion pos2 = new Posicion(17 ,2);
        Posicion pos3 = new Posicion(19 ,2);
        Posicion pos4 = new Posicion(1 ,17);
        manager.agregarCristales(pos2);
        manager.agregarCristales(pos3);
        manager.agregarCristales(pos4); // esta linea es para verificar que no pasa nada con cistrales lejps


        try {
            manager.construirCriaderoEn(pos, new Criadero(economia, pos));
        }catch (RuntimeException e){
            afirmacion  = false;
        }
        assert (afirmacion);
    }


    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoParaVolcanes() {
        boolean afirmacion = true;
        Posicion pos = new Posicion(17 ,3);
        Posicion pos2 = new Posicion(17 ,2);
        Posicion pos3 = new Posicion(19 ,2);
        Posicion pos4 = new Posicion(1 ,17);
        manager.agregarVolcanes(pos2);
        manager.agregarVolcanes(pos3);
        manager.agregarVolcanes(pos4); // esta linea es para verificar que no pasa nada con cistrales lejps


        try {
            manager.construirCriaderoEn(pos, new Criadero(economia, pos));
        }catch (RuntimeException e){
            afirmacion  = false;
        }
        assert (afirmacion);
    }


    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoEnCasoBordeAbajoDerecha() {
        Posicion pos = new Posicion(17, 17);
        Criadero criadero = new Criadero(economia, pos );
        manager.construirCriaderoEn(pos, criadero );
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

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
                        manager.construirZerg(pos, new ReservaDeReproduccion(economia, pos));
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
        Pilon pilon = new Pilon(economia, pos);
        manager.construirPilonEn(pos, pilon);
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();
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
        Pilon pilon = new Pilon(economia, pos);
        manager.construirPilonEn(pos, pilon);
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();

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
        Pilon pilon =  new Pilon(economia, pos);
        manager.construirPilonEn(pos, pilon);
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();
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
        Pilon pilon = new Pilon(economia, pos);
        manager.construirPilonEn(pos, pilon);
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();

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
        Pilon pilon = new Pilon(economia, pos);
        manager.construirPilonEn(pos, pilon);
        pilon.pasarTurno();
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();

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
        assertEquals("Este piso no esta energizado", exception.getMessage());
    }

    @Test
    public void intentoConstruirProtossDespuesDeUnPilonYNoFalla() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos3 = new Posicion(12, 12);
        Pilon pilon = new Pilon(economia, pos1);
        manager.construirPilonEn(pos1, pilon);
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();

        String afirmacion = "Todo ok";
        try {
            manager.construirProtoss(pos3, new Acceso(economia, pos3));
        } catch (RuntimeException e) {
            afirmacion = e.getMessage();
        }
        assertEquals("Todo ok", afirmacion);
    }



    @Test
    public void intentoDestruirUnProtossYEfectivamenteLoDestruye() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos3 = new Posicion(12, 12);
        Pilon pilon = new Pilon(economia, pos1);
        manager.construirPilonEn(pos1, pilon);
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();
        manager.construirProtoss(pos3, new Acceso(economia, pos3));
        assertDoesNotThrow(() -> manager.destruirProtoss(pos3));

    }

    @Test
    public void intentoDestruirUnProtossQueNoExisteYEntoncesNoSeDestruyeNada() {
        Posicion pos1 = new Posicion(10, 10);
        Posicion pos3 = new Posicion(12, 12);

        Pilon pilon = new Pilon(economia, pos1);
        manager.construirPilonEn(pos1, pilon);
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        manager.construirProtoss(pos3, new Acceso(economia, pos3));
        manager.destruirProtoss(pos3);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.destruirProtoss(pos3)
        );
        assertEquals("No hay nada para destruir", exception.getMessage());
    }

    @Test
    public void intentoDestruirUnPilonYNoPuedoConstruirOtraConstruccionProtoss() {
        Posicion pos = new Posicion(10 ,10);

        manager.construirPilonEn(pos, new Pilon(economia, pos));
        manager.destruirProtoss(pos);


        int contador= 0;

        int posicion_x = 7;
        int posicion_y = 7;
        int topeX = 14;
        int topeY = 14;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                try {
                    pos = new Posicion(i, j);
                    manager.construirProtoss(pos, new Acceso(economia, pos));
                } catch (RuntimeException e) {
                        contador ++;
                }
            }

        }
        assertEquals (49, contador, "Se elimina un pilon y la zona se desenergiza correctamente");
    }

    @Test
    public void sePuedenDestruirMuchosEdificiosSinProblemaAlguno(){
        Posicion pos = new Posicion(10,10);
        Posicion pos1 = new Posicion(11,11);
        Posicion pos2 = new Posicion(10,13);
        Posicion pos3 = new Posicion(7,10);
        Posicion pos4 = new Posicion(10,11);
        Posicion pos5 = new Posicion(9,9);
        Posicion pos6 = new Posicion(8,13);
        Posicion pos7 = new Posicion(11,12);

        Pilon pilon = new Pilon (economia, pos );
        manager.construirPilonEn(pos,  pilon);
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        manager.construirProtoss(pos1, new Acceso(economia, pos1));
        manager.construirProtoss(pos2, new Acceso(economia, pos2));
        manager.construirProtoss(pos3, new Acceso(economia, pos3));
        manager.construirProtoss(pos4, new PuertoEstelar(economia, pos4));
        manager.construirProtoss(pos5, new PuertoEstelar(economia, pos5));
        manager.construirProtoss(pos6, new PuertoEstelar(economia, pos6));
        manager.construirProtoss(pos7, new PuertoEstelar(economia, pos7));

        boolean afirmacion = true;
        LinkedList<Posicion> list = new LinkedList<>();
        list.add(pos);list.add(pos1);list.add(pos2);list.add(pos3);list.add(pos4);list.add(pos5);list.add(pos6);list.add(pos7);

        for(int i = 0; i<8; i++) {
            try {
                manager.destruirProtoss(list.get(i));
            } catch (RuntimeException e) {
                afirmacion = false;
            }
        }

        assert (afirmacion);
    }

    @Test
    public void edificioSinEnergiaNoFunciona(){
        Posicion pos = new Posicion(10,10);
        Posicion pos1 = new Posicion(11,11);
        Posicion pos2 = new Posicion(10,13);
        Posicion pos3 = new Posicion(7,10);

        int contador = 0;

        Pilon pilon = new Pilon(economia, pos);
        Acceso acceso1 = new Acceso(economia, pos1);
        Acceso acceso2 = new Acceso(economia, pos3);
        PuertoEstelar puertoEstelar =  new PuertoEstelar(economia, pos2);

        manager.construirPilonEn(pos, pilon);
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();

        manager.construirProtoss(pos1, acceso1);
        manager.construirProtoss(pos2, puertoEstelar);
        manager.construirProtoss(pos3, acceso2);
        manager.destruirProtoss(pos);

        for(int i=0; i<14 ; i++){
            acceso1.pasarTurno();
            puertoEstelar.pasarTurno();
            acceso2.pasarTurno();
        }


        try {
            acceso1.usar();
        }catch (RuntimeException e){
            contador ++;
        }
        try {
            acceso2.usar();
        }catch (RuntimeException e){
            contador ++;
        }
        try {
            puertoEstelar.usar();
        }catch (RuntimeException e){
            contador ++;
        }

        assertEquals(3, contador, "Se destruye un pilon y entonces los edificios energizados por el al no tener energia, pasan a estar NO OPERATIVOS");
    }

    @Test
    public void siSeDestruyeUnPilonPeroHayOtroCercaEntoncesElEdificioNoSeDesenergiza(){
        Posicion pos0 = new Posicion(10,10);
        Posicion pos1 = new Posicion(15,15);
        Posicion pos2 = new Posicion(13,13);

        Acceso acceso = new Acceso(economia, pos2);
        Pilon pilon1 = new Pilon(economia, pos0);
        Pilon pilon2 = new Pilon(economia, pos1);
        manager.construirPilonEn(pos0, pilon1);
        pilon1.pasarTurno();
        pilon1.pasarTurno();
        pilon1.pasarTurno();
        pilon1.pasarTurno();
        pilon1.pasarTurno();

        manager.construirProtoss(pos2, acceso);
        manager.construirPilonEn(pos1, pilon2);
        pilon2.pasarTurno();
        pilon2.pasarTurno();
        pilon2.pasarTurno();
        pilon2.pasarTurno();
        pilon2.pasarTurno();

        for(int i=0; i<14 ; i++) {
            acceso.pasarTurno();
        }
        manager.destruirProtoss(pos0);

        assertDoesNotThrow( () -> acceso.usar() );
    }

    @Test
    public void siSeDestruyeUnPilonSeDesenergizanLasEstructurasPeroAlConstruirOtroCercaEstasVuelvenAEstarActivas(){
        Posicion pos0 = new Posicion(10,10);
        Posicion pos2 = new Posicion(13,13);

        Acceso acceso = new Acceso(economia, pos2);
        Pilon pilon1 = new Pilon(economia, pos0);

        manager.construirPilonEn(pos0, pilon1);
        pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();
        manager.construirProtoss(pos2, acceso);

        for(int i=0; i<14 ; i++)
            acceso.pasarTurno();
        manager.destruirProtoss(pos0);

        Posicion pos1 = new Posicion(15,15);
        Pilon  pilon2 = new Pilon(economia, pos1);
        manager.construirPilonEn(pos1, pilon2);
        pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();

        assertDoesNotThrow( () -> acceso.usar() );
    }

    @Test
    public void siSeDestruyenAmbosPilonesNoEstaMasOperativo(){
        Posicion pos0 = new Posicion(10,10);
        Posicion pos1 = new Posicion(15,15);
        Posicion pos2 = new Posicion(13,13);

        Acceso acceso = new Acceso(economia, pos2);
        Pilon pilon1 = new Pilon(economia, pos0);
        Pilon pilon2 = new Pilon(economia, pos1);

        manager.construirPilonEn(pos0, pilon1);
        pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();
        manager.construirProtoss(pos2, acceso);
        manager.construirPilonEn(pos1, pilon2);
        pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();

        for(int i=0; i<14 ; i++)
            acceso.pasarTurno();

        manager.destruirProtoss(pos0);
        manager.destruirProtoss(pos1);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> acceso.usar()
        );
        assertEquals("Edificio no operativo", exception.getMessage());
    }

    @Test
    public void construirSobreUnaConstruccionLanzaError(){
        Posicion pos0 = new Posicion(10,10);
        Pilon pilon1 = new Pilon(economia, pos0);
        Acceso acceso = new Acceso(economia, pos0);

        manager.construirPilonEn(pos0, pilon1);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirProtoss(pos0, acceso)
        );

    }

    @Test
    public void construirSobreUnaConstruccionExtractoraLanzaError(){
        Posicion pos0 = new Posicion(10,10);
        Pilon pilon1 = new Pilon(economia, pos0);
        Extractor extractor = new Extractor(economia, pos0);
        manager.agregarVolcanes(pos0);
        manager.construirEstructuraDeVolcan(pos0, extractor);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirPilonEn(pos0, pilon1)
        );
        assertEquals("Ya hay una construccion en esa posicion", exception.getMessage());
    }

    @Test
    public void construirUnPilonSobreUnVolcanLanzaExepcion(){
        Posicion pos0 = new Posicion(10,10);
        Pilon pilon1 = new Pilon(economia, pos0);
        manager.agregarVolcanes(pos0);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirPilonEn(pos0, pilon1)
        );
        assertEquals("No se puede construir en esta posicion", exception.getMessage());
    }

    @Test
    public void construirUnPilonSobreUnCristalLanzaExcepcion() {
        Posicion pos0 = new Posicion(10,10);
        Pilon pilon1 = new Pilon(economia, pos0);
        manager.agregarVolcanes(pos0);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirPilonEn(pos0, pilon1)
        );
        assertEquals("No se puede construir en esta posicion", exception.getMessage());
    }

    @Test
    public void construirUnCriaderoSobreUnVolcanLanzaExepcion(){
        Posicion pos0 = new Posicion(10,10);
        Criadero criadero1 = new Criadero(economia, pos0);
        manager.agregarVolcanes(pos0);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirCriaderoEn(pos0, criadero1)
        );
        assertEquals("No se puede construir en esta posicion", exception.getMessage());
    }

    @Test
    public void construirUnCriaderoSobreUnCristalLanzaExcepcion() {
        Posicion pos0 = new Posicion(10,10);
        Criadero criadero1 = new Criadero(economia, pos0);
        manager.agregarVolcanes(pos0);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirCriaderoEn(pos0, criadero1)
        );
        assertEquals("No se puede construir en esta posicion", exception.getMessage());
    }

    @Test
    public void llenarElLimiteDeUnidadesEIntentarConstruirMasUnidadesTiraError() {
        // Setup to reach 200 max limit -> if limit is changed, test will fail.
        for(int i = 5; i < 15; i++) {
            for(int j = 5; j < 10; j++) {
                Posicion pos = new Posicion(i, j);
                manager.crearUnidad(pos, new Scout(economia, pos));
            }
        }
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.crearUnidad(new Posicion(18, 18), new Scout(economia, new Posicion(18, 18)))
        );
        assertEquals("No puedes construir esta unidad, ya tienes la mayor cantidad de unidades posibles", exception.getMessage());
    }

    @Test
    public void noLlenarElLimiteConUnPilonYDestruirElPilonYaNoTeDejaConstruir() {
        // Setup to reach 200 max limit -> if limit is changed, test will fail.
        manager.construirPilonEn(new Posicion(0,0), new Pilon(economia, new Posicion(0,0)));
        for(int i = 5; i < 15; i++) {
            for(int j = 5; j < 10; j++) {
                Posicion pos = new Posicion(i, j);
                manager.crearUnidad(pos, new Scout(economia, pos));
            }
        }
        manager.destruirProtoss(new Posicion(0, 0));
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.crearUnidad(new Posicion(18, 18), new Scout(economia, new Posicion(18, 18)))
        );
        assertEquals("No puedes construir esta unidad, ya tienes la mayor cantidad de unidades posibles", exception.getMessage());
    }
}