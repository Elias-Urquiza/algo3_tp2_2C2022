package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tiles.Moho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMoho {
    private Moho moho;
    private Posicion pos;
    private LinkedList<ConstruccionZerg> construcciones;
    private Economia econ = new MockEconomia();

    @BeforeEach
    public void init() {
        pos = new Posicion(1, 1);
        moho = new Moho(pos);
        construcciones = new LinkedList<>();
    }
    @Test
    public void cuandoLaPosicionEsLaMismaAgregaLaConstruccionALaLista() {
        moho.construir(construcciones, new ReservaDeReproduccion(econ, pos), pos);
        assertEquals(1, construcciones.size());
    }

    @Test
    public void cuandoLaPosicionNoEsLaMismaNoAgregaLaConstruccionALaLista() {
        moho.construir(construcciones, new ReservaDeReproduccion(econ, pos), new Posicion(2,2));
        assertEquals(0, construcciones.size());
    }
}
