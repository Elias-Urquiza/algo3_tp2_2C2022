package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.tiles.Energia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsEnergia {

    private Energia energia;
    private LinkedList<ConstruccionProtoss> construcciones;
    private Economia econ = new MockEconomia();

    @BeforeEach
    public void init() {
        energia = new Energia(new Posicion(1,1));
        construcciones = new LinkedList<>();
    }
    @Test
    public void cuandoLaPosicionEsLaMismaAgregaLaConstruccionALaLista() {
        energia.construir(construcciones, new PuertoEstelar(econ, new Posicion(1,1)), new Posicion(1,1));
        assertEquals(1, construcciones.size());
    }

    @Test
    public void cuandoLaPosicionNoEsLaMismaAgregaNoLaConstruccionALaLista() {
        assertEquals(0, construcciones.size());
        energia.construir(construcciones, new PuertoEstelar(econ, new Posicion(2,2)), new Posicion(2,2));
    }
}
