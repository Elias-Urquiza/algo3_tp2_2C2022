package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tiles.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVacio {


    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {
//16 - 24
        Posicion posCriadero = new Posicion(25, 25);
        Posicion posPilon = new Posicion(15, 15);

        manager = new Manager(40, 40);
        manager.construirCriaderoEn(posCriadero, new Criadero(economia, posCriadero));
        manager.construirPilonEn(posPilon, new Pilon(economia, posPilon));

        for (int i = 0; i < 5; i++) {
            manager.pasarTurno();
        }
    }


    @Test
    public void dadaUnaTileVaciaNoSePuedeConstruirNadaSobreElla(){

        Posicion pos;
        int esperado = 4;
        int resultado = 0;

        try {
            pos = new Posicion(23,23);
            manager.construirZerg(pos, new ReservaDeReproduccion(economia, pos));
        }catch (RuntimeException e){
            resultado++;
        }
        try {
            pos = new Posicion(18, 19);
            manager.construirProtoss(pos, new Acceso(economia, pos));
        }catch (RuntimeException e){
            resultado++;
        }
        try {
            pos = new Posicion(20,20);
            manager.construirCriaderoEn(pos, new Criadero(economia, pos));
        }catch (RuntimeException e){
            resultado++;
        }
        try {
            pos = new Posicion(19, 19);
            manager.construirPilonEn(pos, new Pilon(economia, pos));
        }catch (RuntimeException e){
            resultado++;
        }

        assertEquals(esperado, resultado);
    }
}
