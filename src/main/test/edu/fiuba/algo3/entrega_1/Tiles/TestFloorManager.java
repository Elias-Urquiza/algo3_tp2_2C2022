package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.tiles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;



public class TestFloorManager {

    private Manager manager;
    private FloorManager floorManager;
    private static final Economia economia = new MockEconomia();
    private static int X = 0;
    private static int Y = 0;

    @Mock
    private Manager mockManager;

    @BeforeEach
    public void initEach() {
        manager = new Manager(20, 20);
    }

    @Test
    public void cuandoSeMohificaLasTilesVaciasCorrespondientesSeVan(){

        Posicion pos0 = new Posicion(6,6);
        Criadero criadero = new Criadero(economia, pos0);
        manager.construirCriaderoEn(pos0,criadero );

        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        boolean afirmacion = true;

        int posicion_x = 1;
        int posicion_y = 1;
        int topeX = 12;
        int topeY = 12;

        LinkedList<TileVacia> lista = manager.getTilesVacias();

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                pos0 = new Posicion(i, j);
                for(TileVacia v : lista){
                    if( (v.getPos()).equals(pos0) )
                        afirmacion = false;
                }
            }
        }
        assert(afirmacion);
    }

    @Test
    public void cuandoSeMohificaLasEnergiasCorrespondientesSeVan(){


        Posicion pos1 = new Posicion(13,13);
        manager.construirPilonEn(pos1, new Pilon(economia, pos1));
        pos1 = new Posicion(0,13);
        manager.construirPilonEn(pos1, new Pilon(economia, pos1));
        pos1 = new Posicion(0,0);
        manager.construirPilonEn(pos1, new Pilon(economia, pos1));
        pos1 = new Posicion(13,0);
        manager.construirPilonEn(pos1, new Pilon(economia, pos1));
        Posicion pos0 = new Posicion(6,6);
        Criadero criadero = new Criadero(economia, pos0);
        manager.construirCriaderoEn(pos0, criadero);

        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        boolean afirmacion = true;

        int posicion_x = 1;
        int posicion_y = 1;
        int topeX = 12;
        int topeY = 12;

        LinkedList<Energia> lista = manager.getEnergias();

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                pos0 = new Posicion(i, j);
                for(Energia e : lista){
                    if( (e.getPos()).equals(pos0) )
                        afirmacion = false;
                }
            }
        }
        assert(afirmacion);
    }

    @Test
    public void cuandoSeEnergizaLasTilesVaciasCorrespondientesSeVan(){

        Posicion pos0 = new Posicion(6,6);
        Pilon pilon = new Pilon(economia, pos0);
        manager.construirPilonEn(pos0, pilon);

        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();
        pilon.pasarTurno();

        boolean afirmacion = true;

        int posicion_x = 3;
        int posicion_y = 3;
        int topeX = 10;
        int topeY = 10;

        LinkedList<TileVacia> lista = manager.getTilesVacias();

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                pos0 = new Posicion(i, j);
                for(TileVacia v : lista){
                    if( (v.getPos()).equals(pos0) )
                        afirmacion = false;
                }
            }
        }
        assert(afirmacion);
    }

    @Test
    public void cuandoSeEnergizaElMohoEnLaZonaQueSeEnergizaNoSeVa(){

        Posicion pos0 = new Posicion(6,6);
        Criadero criadero = new Criadero(economia, pos0);
        manager.construirCriaderoEn(pos0, criadero);
        pos0 = new Posicion(13, 13);
        manager.construirPilonEn(pos0, new Pilon(economia, pos0));

        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();


        int esperado = 4;
        int resultado = 0;

        int posicion_x = 10;
        int posicion_y = 10;
        int topeX = 17;
        int topeY = 17;

        LinkedList<Moho> lista = manager.getMohos();

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                pos0 = new Posicion(i, j);
                for(Moho m : lista){
                    if( (m.getPos()).equals(pos0) )
                        resultado ++;
                }
            }
        }
        assertEquals(esperado, resultado);
    }

    @Test
    public void cuandoPasanLosTurnosElMohoSeEsparceCorrectamente(){
        Posicion pos0 = new Posicion(6,6);
        Criadero criadero = new Criadero(economia, pos0);
        boolean afirmacion1= true;
        int contador = 0;

        manager.construirCriaderoEn(pos0, criadero);

        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();

        Posicion pos1 = new Posicion(12,6);
        Posicion pos2 = new Posicion(12,3);
        Posicion pos3 = new Posicion(12,9);
        Posicion pos4 = new Posicion(0, 0);
        Posicion pos5 = new Posicion(1, 0);
        Posicion pos6 = new Posicion(2, 0);
        Posicion pos7 = new Posicion(0,12);
        Posicion pos8 = new Posicion(1,12);
        Posicion pos9 = new Posicion(2,12);
        LinkedList<Moho> mohos = manager.getMohos();
        LinkedList<Posicion> poses = new LinkedList<>();

        poses.add(pos1);poses.add(pos2);poses.add(pos3);poses.add(pos4);poses.add(pos5);poses.add(pos6);poses.add(pos7);poses.add(pos8);poses.add(pos9);
        for(int i =0; i<9; i++) {
            for (Moho m : mohos) {
                if(m.getPos().equals(poses.get(i)))
                    afirmacion1 = false;
            }
        }

        criadero.pasarTurno();criadero.pasarTurno();

        for (Posicion p : poses) {
            for (Moho m : mohos) {
                if(m.getPos().equals(p))
                    contador++;
            }
        }

        boolean afirmacion2 = contador ==9;
        assert(afirmacion1 && afirmacion2);

    }
}
