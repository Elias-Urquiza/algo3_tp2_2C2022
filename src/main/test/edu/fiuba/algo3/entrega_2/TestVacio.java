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

import static org.junit.jupiter.api.Assertions.*;

public class TestVacio {


    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {

        Posicion posCriadero = new Posicion(26, 14);
        Posicion posPilon = new Posicion(14, 14);
        Posicion posCriadero2 = new Posicion(26, 26);
        Posicion posPilon2 = new Posicion(14, 26);

        manager = new Manager(40, 40);
        manager.construirCriaderoEn(posCriadero, new Criadero(economia, posCriadero));
        manager.construirPilonEn(posPilon, new Pilon(economia, posPilon));
        manager.construirCriaderoEn(posCriadero2, new Criadero(economia, posCriadero2));
        manager.construirPilonEn(posPilon2, new Pilon(economia, posPilon2));

        for (int i = 0; i < 5; i++) {
            manager.pasarTurno();
        }
    }


    @Test
    public void dadaUnaTileVaciaNoSePuedeConstruirNadaSobreElla(){


        final Posicion pos1 = new Posicion(16,16);

        final RuntimeException exception1 = assertThrows(
                RuntimeException.class,
                 () -> manager.construirProtoss(pos1, new Acceso(economia, pos1) )
        );
        boolean afirmacion1 = "La posicion es un espacio aereo" ==  exception1.getMessage();

        final Posicion pos2 = new Posicion(16,24);

        final RuntimeException exception2 = assertThrows(
                RuntimeException.class,
                () -> manager.construirProtoss(pos2, new Acceso(economia, pos2) )
        );
        boolean afirmacion2 = "La posicion es un espacio aereo" ==  exception2.getMessage();

        final Posicion pos3 = new Posicion(24,16);

        final RuntimeException exception3 = assertThrows(
                RuntimeException.class,
                () -> manager.construirZerg(pos3, new ReservaDeReproduccion(economia, pos3) )
        );
        boolean afirmacion3 = "La posicion es un espacio aereo" ==  exception3.getMessage();


        final Posicion pos4 = new Posicion(24,24);

        final RuntimeException exception4 = assertThrows(
                RuntimeException.class,
                () -> manager.construirZerg(pos4, new ReservaDeReproduccion(economia, pos4) )
        );
        boolean afirmacion4 = "La posicion es un espacio aereo" ==  exception4.getMessage();


        assert(afirmacion1 && afirmacion2 && afirmacion3 && afirmacion4);
    }
}
