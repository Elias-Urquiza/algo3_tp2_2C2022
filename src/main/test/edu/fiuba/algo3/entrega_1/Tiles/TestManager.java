package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
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
        boolean afirmacion = true;

        try {
            manager.construirZerg(new Posicion(12, 12), new ReservaDeReproduccion(economia, new Posicion(12, 12)));
        } catch (RuntimeException e) {
            afirmacion = false;
        }

        try{
            manager.construirZerg(new Posicion(12, 19), new ReservaDeReproduccion(economia, new Posicion(12, 19)));
        }catch (RuntimeException e) {
            afirmacion = false;
        }
        try{
            manager.construirZerg(new Posicion(19, 18), new ReservaDeReproduccion(economia, new Posicion(19, 18)));
        }catch (RuntimeException e) {
            afirmacion = false;
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert(afirmacion);
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

        int contador = 0 ;

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 5 = 0 --> 0
        int posicion_y = 12;
        int topeX = 9;// 3 + 6 = 9
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {

                    try {
                        pos = new Posicion(i,j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
                    } catch (RuntimeException e) {
                        contador++;
                    }
                }

        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        //assert (afirmacion);
        assertEquals(72 ,contador);
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
        int contador = 0 ;
        int posicion_x = 12;// 3 - 5 = 0 --> 0
        int posicion_y = 0;
        int topeX = 20;// 3 + 6 = 9
        int topeY = 9;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {

                    try {
                        pos = new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
                    } catch (RuntimeException e) {
                        contador++;
                    }
                }

        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assertEquals(72, contador);
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
        boolean afirmacion = true;
        Posicion pos;
        int posicion_x = 12;// 3 - 5 = 0 --> 0
        int posicion_y = 12;
        int topeX = 20;// 3 + 6 = 9
        int topeY = 20;
        int contador = 0;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                    try {
                        pos =new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
                    } catch (RuntimeException e) {
                        contador++;
                    }
                }
            }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assertEquals(64, contador);
    }



    @Test
    public void seConstruyeUnPilonYSeEnergizaLaZonaCorrespondiente() {

        Posicion pos;
        int posicion_x = 0;
        int posicion_y = 0;
        int topeX = 7;
        int topeY = 7;
        int contador = 0;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 3) {//para que no construya sobre el criadero
                    try {
                        pos = new Posicion(i, j);
                        manager.construirProtoss(pos, new Acceso(economia, pos));
                    } catch (RuntimeException e) {
                        contador++;
                    }
                }
            }
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assertEquals(6, contador);
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
    public void seConstruyeUnPilonYSeEnergizaLaZonadeArribaDerecha() {
        Posicion pos =new Posicion(3, 18);
        Pilon pilon = new Pilon(economia, pos);
        manager.construirPilonEn(pos, pilon);
        pilon.pasarTurno();
        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();

        boolean afirmacion = true;

        int posicion_x = 0 ;// 3 - 3 = 0 --> 0
        int posicion_y = 15;
        int topeX =  7;// 3 + 4 = 5
        int topeY = 20;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if (i != 3 || j != 18) {//para que no construya sobre el criadero
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
                () -> manager.construirAsimilador(pos1, new Asimilador(economia, pos1))
        );
        assertEquals("No hay un volcan en la posicion", exception.getMessage());
    }

    @Test
    public void intentoConstruirAsimiladorSobreVolcanYPuedo() {
        Posicion pos2 = new Posicion (6, 6);
        manager.agregarVolcanes(pos2);
        assertDoesNotThrow(() -> manager.construirAsimilador(pos2, new Asimilador(economia, pos2)));
    }


    @Test
    public void intentoConstruirNexoMineralSobreVolcanYNoPuedo() {
        Posicion pos2 = new Posicion (6, 6);
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
        Posicion pos3 = new Posicion(6, 6);
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
        Posicion pos3 = new Posicion(6, 6);
        manager.construirProtoss(pos3, new Acceso(economia, pos3));
        assertDoesNotThrow(() -> manager.destruirProtoss(pos3));
    }

    @Test
    public void intentoDestruirUnProtossQueNoExisteYEntoncesNoSeDestruyeNada() {

        Posicion pos3 = new Posicion(3, 4);

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
        Posicion pos = new Posicion(0 ,15);
        Pilon lonPi =new Pilon(economia, pos);
        manager.construirPilonEn(pos,lonPi );
        lonPi.pasarTurno();lonPi.pasarTurno();lonPi.pasarTurno();lonPi.pasarTurno();lonPi.pasarTurno();
        manager.destruirProtoss(pos);


        int contador= 0;

        int posicion_x = 0;
        int posicion_y = 12;
        int topeX = 4;
        int topeY = 19;

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
        assertEquals (28, contador, "Se elimina un pilon y la zona se desenergiza correctamente");
    }

    @Test
    public void sePuedenDestruirMuchosEdificiosSinProblemaAlguno(){
        Posicion pos1 = new Posicion(3,4);
        Posicion pos2 = new Posicion(0,0);
        Posicion pos3 = new Posicion(3,6);
        Posicion pos4 = new Posicion(4,3);
        Posicion pos5 = new Posicion(1,0);
        Posicion pos6 = new Posicion(6,3);


        manager.construirProtoss(pos1, new Acceso(economia, pos1));
        manager.construirProtoss(pos2, new Acceso(economia, pos2));
        manager.construirProtoss(pos3, new Acceso(economia, pos3));
        manager.construirProtoss(pos4, new PuertoEstelar(economia, pos4));
        manager.construirProtoss(pos5, new PuertoEstelar(economia, pos5));
        manager.construirProtoss(pos6, new PuertoEstelar(economia, pos6));

        boolean afirmacion = true;
        LinkedList<Posicion> list = new LinkedList<>();
        list.add(pos1);list.add(pos2);list.add(pos3);list.add(pos4);list.add(pos5);list.add(pos6);

        for(int i = 0; i<6; i++) {
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
        Posicion pos = new Posicion (15,0);
        Posicion pos1 = new Posicion(15,1);
        Posicion pos2 = new Posicion(14,0);
        Posicion pos3 = new Posicion(16,0);

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
        Posicion pos0 = new Posicion(15,0);
        Posicion pos1 = new Posicion(15,3);
        Posicion pos2 = new Posicion(15,1);

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

        for(int i=0; i<8 ; i++) {
            acceso.pasarTurno();
        }
        manager.destruirProtoss(pos0);

        assertDoesNotThrow( () -> acceso.usar() );
    }

    @Test
    public void siSeDestruyeUnPilonSeDesenergizanLasEstructurasPeroAlConstruirOtroCercaEstasVuelvenAEstarActivas(){
        Posicion pos0 = new Posicion(10,11);
        Posicion pos2 = new Posicion(10,12);

        Acceso acceso = new Acceso(economia, pos2);
        Pilon  pilon1 = new Pilon (economia, pos0);

        manager.construirPilonEn(pos0, pilon1);
        pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();
        manager.construirProtoss(pos2, acceso);

        for(int i=0; i<8 ; i++)
            acceso.pasarTurno();
        manager.destruirProtoss(pos0);

        Posicion pos1 = new Posicion(11,11);
        Pilon  pilon2 = new Pilon(economia, pos1);
        manager.construirPilonEn(pos1, pilon2);
        pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();

        assertDoesNotThrow( () -> acceso.usar() );
    }

    @Test
    public void siSeDestruyenAmbosPilonesNoEstaMasOperativo(){
        Posicion pos0 = new Posicion(10,11);
        Posicion pos1 = new Posicion(8,11);
        Posicion pos2 = new Posicion(9,11);

        Acceso acceso = new Acceso(economia, pos2);
        Pilon pilon1 = new Pilon(economia, pos0);
        Pilon pilon2 = new Pilon(economia, pos1);

        manager.construirPilonEn(pos0, pilon1);
        pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();pilon1.pasarTurno();
        manager.construirProtoss(pos2, acceso);
        manager.construirPilonEn(pos1, pilon2);
        pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();pilon2.pasarTurno();

        for(int i=0; i<8 ; i++)
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
        Posicion pos0 = new Posicion(10,11);
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
        Posicion pos0 = new Posicion(10,11);
        Pilon pilon1 = new Pilon(economia, pos0);
        Extractor extractor = new Extractor(economia, pos0);
        manager.agregarVolcanes(pos0);
        manager.construirExtractor(pos0, extractor);
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirPilonEn(pos0, pilon1)
        );
        assertEquals("Ya hay una construccion en esa posicion", exception.getMessage());
    }

    @Test
    public void construirUnPilonSobreUnVolcanLanzaExepcion(){
        Posicion pos0 = new Posicion(10,11);
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
        Posicion pos0 = new Posicion(10,11);
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
        Posicion pos0 = new Posicion(10,11);
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
        Posicion pos0 = new Posicion(10,11);
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
                manager.crearProtoss(pos, new Scout(economia, pos));
            }
        }
        manager.crearProtoss(new Posicion(1, 20), new Scout(economia, new Posicion(1, 20)));
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.crearProtoss(new Posicion(18, 18), new Scout(economia, new Posicion(18, 18)))
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
                manager.crearProtoss(pos, new Scout(economia, pos));
            }
        }
        manager.destruirProtoss(new Posicion(0, 0));
        manager.crearProtoss(new Posicion(1, 20), new Scout(economia, new Posicion(1, 20)));
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.crearProtoss(new Posicion(18, 18), new Scout(economia, new Posicion(18, 18)))
        );
        assertEquals("No puedes construir esta unidad, ya tienes la mayor cantidad de unidades posibles", exception.getMessage());
    }


    @Test
    public void seTerminaElJuegoPierdenLosProtoss() {
        Posicion posicion = new Posicion(15,14);
        Posicion posicion2 = new Posicion(14,14);
        boolean afirmacion = false;

        ReservaDeReproduccion reserva = new ReservaDeReproduccion(economia, posicion);
        manager.construirZerg(posicion, reserva);
        for(int i = 0; i<12; i++) reserva.pasarTurno();

        Guarida guarida = new Guarida(economia, posicion2);
        manager.construirZerg(posicion2, guarida);
        for(int i = 0; i<12; i++) guarida.pasarTurno();

        Hidralisco hidralisco = new Hidralisco(economia, posicion2);
        manager.crearZerg(posicion2, hidralisco);
        hidralisco.pasarTurno();hidralisco.pasarTurno();hidralisco.pasarTurno();hidralisco.pasarTurno();

        manager.moverUnidad( new Posicion(3,4), hidralisco );


        for(int i = 0; i<59; i++)
            manager.unidadAtacaConstruccion(hidralisco, manager.getConstruccionProtoss().get(0));
        for(int i = 0; i<1; i++)
            manager.unidadAtacaConstruccion(hidralisco, manager.getConstruccionProtoss().get(0));

        RuntimeException exception = assertThrows( RuntimeException.class, () -> manager.pasarTurno());
        assertEquals("Los Zerg han ganado el juego", exception.getMessage());
    }

    @Test
    public void seTerminaElJuegoPierdenLosZerg() {

        Posicion pos = new Posicion(6,6);
        Acceso acceso = new Acceso(economia, pos);
        manager.construirProtoss(pos, acceso);
        acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();
        acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();

        Dragon dragon = new Dragon(economia, pos);
        manager.crearProtoss(pos ,dragon);
        dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();

        manager.moverUnidad(new Posicion(17, 16), dragon);

        for(int i =0; i< 25 ;i++)
            manager.unidadAtacaConstruccion(dragon, manager.getConstruccionesZerg().get(0));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> manager.pasarTurno());
        assertEquals("Los Protoss han ganado el juego", exception.getMessage());

    }

    @Test
    public void seTerminaElJuegoPierdenLosProtossConExtractores() {
        Posicion pos = new Posicion(6,6);
        Posicion pos1 = new Posicion(17,15);

        Acceso acceso = new Acceso(economia, pos);
        manager.construirProtoss(pos, acceso);
        acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();
        acceso.pasarTurno();acceso.pasarTurno();acceso.pasarTurno();

        Dragon dragon = new Dragon(economia, pos);
        manager.crearProtoss(pos ,dragon);
        dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();dragon.pasarTurno();

        manager.moverUnidad(new Posicion(17, 16), dragon);


        Extractor extractor = new Extractor(economia, pos1);
        manager.construirExtractor(pos1, extractor);
        extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();extractor.pasarTurno();

        for(int i =0; i< 25 ;i++)
            manager.unidadAtacaConstruccion(dragon, manager.getConstruccionesZerg().get(0));

        assertDoesNotThrow( () -> manager.pasarTurno());

        for(int i =0; i< 38 ;i++)// dragon le pega al extractor (por gil le pasa)
            manager.unidadAtacaConstruccion(dragon, extractor);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> manager.pasarTurno());
        assertEquals("Los Protoss han ganado el juego", exception.getMessage());
    }
}