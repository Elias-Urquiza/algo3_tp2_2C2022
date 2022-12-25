package edu.fiuba.algo3.entrega_2.Unidades.Zerg;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.tiles.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsZangano {

    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {
        manager = new Manager(40, 40);

        Pilon pilon = new Pilon(economia, new Posicion(6,6));
        manager.construirPilonEn(new Posicion(6,6), pilon);

        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();

        manager.construirZerg(new Posicion(34,34) , new ReservaDeReproduccion(economia, new Posicion(34,34) ) );
        manager.construirProtoss(new Posicion(6,8), new Acceso(economia, new Posicion(6,8)));

        for (int i = 0; i < 12; i++) {
            manager.pasarTurno();
        }

    }

    @Test
    public void zanganoExtraeCorrectamente(){
        Posicion pos    = new Posicion(34,34);

        Economia economiaZerg = new Economia();
        economiaZerg.ingresarMineral(25);

        Zangano zangano = new Zangano(economiaZerg, pos);
        manager.crearZerg(pos,zangano);
        zangano.pasarTurno();

        Posicion pos2 = new Posicion(34, 35);
        manager.moverUnidad(pos2, zangano);

        manager.pasarTurno();

        assertDoesNotThrow(()-> economiaZerg.gastarMineral(10) );
    }

    @Test
    public void muchosZanganosExtraenCorrectamente(){

        Criadero criadero1 = new Criadero(economia, new Posicion(30, 5));
        Criadero criadero2 = new Criadero(economia, new Posicion(31, 5));

        manager.construirCriaderoEn(new Posicion(30,5), criadero1);
        manager.construirCriaderoEn(new Posicion(31,5), criadero2);
        for(int i = 0; i<4;i++){
            criadero1.pasarTurno();criadero2.pasarTurno();
        }

        Posicion pos = new Posicion(34,34);

        Economia economiaZerg = new Economia();
        economiaZerg.ingresarMineral(25 * 5);

        Zangano zangano = new Zangano(economiaZerg, pos);
        manager.crearZerg(pos,zangano);
        zangano.pasarTurno();

        Zangano zangano2 = new Zangano(economiaZerg, pos);
        manager.crearZerg(pos,zangano2);
        zangano2.pasarTurno();

        Zangano zangano3 = new Zangano(economiaZerg, pos);
        manager.crearZerg(pos,zangano3);
        zangano3.pasarTurno();

        Zangano zangano4 = new Zangano(economiaZerg, pos);
        manager.crearZerg(pos,zangano4);
        zangano4.pasarTurno();

        Zangano zangano5 = new Zangano(economiaZerg, pos);
        manager.crearZerg(pos,zangano5);
        zangano5.pasarTurno();


        Posicion pos2 = new Posicion(37, 38);
        manager.moverUnidad(pos2, zangano);

        Posicion pos3 = new Posicion(36, 38);
        manager.moverUnidad(pos3, zangano2);

        Posicion pos4 = new Posicion(36, 39);
        manager.moverUnidad(pos4, zangano3);

        Posicion pos5 = new Posicion(38, 38);
        manager.moverUnidad(pos5, zangano4);

        Posicion pos6 = new Posicion(38, 39);
        manager.moverUnidad(pos6, zangano5);


        manager.pasarTurno();

        assertDoesNotThrow(()-> economiaZerg.gastarMineral(50) ); // extrae mas porque hay mas cristales
    }

}
