package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.tiles.Volcan;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMorir {
    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {

        Posicion posCriadero = new Posicion(25, 25);
        Posicion posPilon = new Posicion(15, 15);

        manager = new Manager(40, 40);
        manager.construirCriaderoEn(posCriadero, new Criadero(economia, posCriadero));
        manager.construirPilonEn(posPilon, new Pilon(economia, posPilon));

        for (int i = 0; i < 5; i++) {
            manager.pasarTurno();
        }

        manager.construirZerg(new Posicion(25,26), new ReservaDeReproduccion(economia, new Posicion(25,26) ) );
        manager.construirProtoss(new Posicion(14,14), new Acceso(economia, new Posicion(14, 14)));

        for (int i = 0; i < 15; i++) {
               manager.pasarTurno();
        }
    }

    @Test
    public void unZergAlMatarloSeMuereCorrectamente() {
        Zerling zerling = new Zerling(economia, new Posicion(24, 24));
        manager.crearZerg(new Posicion(25, 26), zerling);

        Dragon dragon = new Dragon(economia, new Posicion(24, 24));
        manager.crearProtoss(new Posicion(14, 14), dragon);

        manager.pasarTurno();
        manager.pasarTurno();
        manager.pasarTurno();
        manager.pasarTurno();
        manager.pasarTurno();
        manager.pasarTurno();

        manager.moverUnidad(new Posicion(30, 30), zerling);
        manager.moverUnidad(new Posicion(30, 31), dragon);

        manager.unidadAtacaUnidad(Raza.ZERG, dragon, zerling);
        manager.unidadAtacaUnidad(Raza.ZERG, dragon, zerling);

        assertDoesNotThrow(() -> manager.construirZerg(new Posicion(30, 30), new ReservaDeReproduccion(economia, new Posicion(30, 30))));
    }

    @Test
    public void UnExtractorSeMuereCorrectamente(){


    }

}
