package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tiles.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCorrelatividadEstructuras {

    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {
        manager = new Manager(20, 20);
    }


    @Test
    public void unaGuaridaSeConstruyeCorrectamenteSiYSoloSiYaExisteUnaReserva() {
        Posicion posReserva = new Posicion(5, 7);
        Posicion posGuarida = new Posicion(5, 8);
        manager.construirZerg(posReserva, new ReservaDeReproduccion(economia, posReserva));

        assertDoesNotThrow(() -> manager.construirZerg(posGuarida, new Guarida(economia, posGuarida)));
    }

    @Test
    public void unaGuaridaNoSeConstruyeCorrectamenteSiNoExisteUnaReserva() {
        Posicion posGuarida = new Posicion(5, 8);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirZerg(posGuarida, new Guarida(economia, posGuarida))
        );
        assertEquals("No existe su correlativa", exception.getMessage());
    }

    @Test
    public void unEspiralSeConstruyeCorrectamenteSiYSoloSiYaExisteUnaGuarida() {
        Posicion posReserva = new Posicion(5, 7);
        Posicion posGuarida = new Posicion(5, 8);
        Posicion posEspiral = new Posicion(4, 8);
        manager.construirZerg(posReserva, new ReservaDeReproduccion(economia, posReserva));
        manager.construirZerg(posGuarida, new Guarida(economia, posGuarida));

        assertDoesNotThrow(() -> manager.construirZerg(posEspiral, new Espiral(economia, posEspiral)));
    }

    @Test
    public void unEpiralNoSeConstruyeCorrectamenteSiNoExisteUnaGuarida() {

        Posicion posEspiral = new Posicion(14, 18);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirZerg(posEspiral, new Espiral(economia, posEspiral))
        );
        assertEquals("No existe su correlativa", exception.getMessage());
    }

    @Test
    public void unPuertoEstelarSeConstruyeCorrectamenteSiYSoloSiYaExisteUnAcceso() {
        Posicion posAcceso = new Posicion(15, 17);
        Posicion posPuertoEstelar = new Posicion(15, 18);

        manager.construirProtoss(posAcceso, new Acceso(economia, posAcceso));

        assertDoesNotThrow(() -> manager.construirProtoss(posPuertoEstelar, new PuertoEstelar(economia, posPuertoEstelar)));
    }

    @Test
    public void unPuertoEstelarNoSeConstruyeCorrectamenteSiNoExisteUnAcceso() {
        Posicion posPuertoEstelar = new Posicion(15, 18);

        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> manager.construirProtoss(posPuertoEstelar, new PuertoEstelar(economia, posPuertoEstelar))
        );
        assertEquals("No existe su correlativa", exception.getMessage());
    }
}
