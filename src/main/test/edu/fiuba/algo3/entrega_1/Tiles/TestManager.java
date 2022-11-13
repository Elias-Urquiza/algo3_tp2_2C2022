package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.tiles.Moho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        manager.construirCriaderoEn(5,5, new Criadero(economia, 5,5) );

        boolean afirmacion = true;

        int posicion_x = 0;// 5 - 5 = 0
        int posicion_y = 0;
        int topeX = 11;// 5 + 6 = 11
        int topeY = 11;

        for(int i = posicion_x; i<(topeX) ; i++) {
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
        assert(afirmacion);
    }

    @Test
    public void seConstruyeUnCriaderoYElMohoSeExpandeSegunLoEsperadoEnCasoBordeArribaIzquierda() {
        manager.construirCriaderoEn(3,3, new Criadero(economia, 3,3) );

        boolean afirmacion = true;

        int posicion_x = 0;// 3 - 5 = 0 --> 0
        int posicion_y = 0;
        int topeX = 7;// 3 + 4 = 7
        int topeY = 7;

        for(int i = posicion_x; i<(topeX) ; i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                if(i != 3 || j != 3) {//para que no construya sobre el criadero
                    try {
                        manager.construirZerg(i, j, new Guarida(economia, i, j));
                    } catch (RuntimeException e) {
                        afirmacion = false;
                    }
                }
            }
        }

        //chequeo que hay moho porque pude construir un edificio zerg en el lugar.
        assert(afirmacion);
    }
}
