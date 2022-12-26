package edu.fiuba.algo3.entrega_2.Unidades;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Suministros;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.unidades.UnidadManager;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRango {

    private  final UnidadManager unidadManager = new UnidadManager();
    private static final Economia economia = new MockEconomia();
    private final Zerling sacoDeBoxTerrestreZerg = new Zerling(economia, new Posicion(3,3));
    private final Mutalisco sacoDeBoxAereoZerg = new Mutalisco(economia, new Posicion(4,4));
    private final Zealot sacoDeBoxTerrestreProtoss = new Zealot(economia, new Posicion(6,6));
    private final Scout sacoDeBoxAereoProtoss = new Scout(economia, new Posicion(8,8));
    private HashMap<Raza, Suministros> mockSuministros = new HashMap<Raza, Suministros>();

    @BeforeEach
    public void initEach() {
        Suministros suministrosProtoss = new Suministros();
        suministrosProtoss.aumentarMaxSuminstros(100);
        Suministros suministrosZerg = new Suministros();
        suministrosZerg.aumentarMaxSuminstros(100);
        mockSuministros.put(Raza.PROTOSS, suministrosProtoss);
        mockSuministros.put(Raza.ZERG, suministrosZerg);
        unidadManager.crearUnidad(sacoDeBoxTerrestreZerg, new Posicion(3,3), mockSuministros);
        unidadManager.crearUnidad(sacoDeBoxAereoZerg, new Posicion(4,4), mockSuministros);
        unidadManager.crearUnidad(sacoDeBoxTerrestreProtoss, new Posicion(6,6), mockSuministros);
        unidadManager.crearUnidad(sacoDeBoxAereoProtoss, new Posicion(8,8), mockSuministros);
    }


    @Test
    public void unZerlingAtacaDentroDeSuRango(){
        Zerling unidad = new Zerling(economia, new Posicion(3,2));
        int danioEsperado = 4;

        for (int i = 0; i<4; i++)
            unidad.pasarTurno();

        assertEquals(danioEsperado, unidad.atacar(sacoDeBoxTerrestreZerg) );
    }


    @Test
    public void unZerlingNoAtacaFueraDeSuRango(){
        Zerling unidad = new Zerling(economia, new Posicion(3,1));
        for (int i = 0; i<4; i++)
            unidad.pasarTurno();
        assertThrows(RuntimeException.class, () -> unidad.atacar(sacoDeBoxTerrestreZerg));
    }

    @Test
    public void unHidraliscoAtacaDentroDeSuRango(){
        Posicion pos = new Posicion(5,8);
        Hidralisco unidad = new Hidralisco(economia, pos);
        int danioEsperado = 10;

        for (int i = 0; i<4; i++)
            unidad.pasarTurno();

        for (int i = 0; i < 10; i++)
            unidad.atacar(sacoDeBoxAereoProtoss);

        assertEquals(danioEsperado, unidad.atacar(sacoDeBoxAereoProtoss) );
    }


    @Test
    public void unHidraliscoNoAtacaFueraDeSuRango(){
        Posicion pos = new Posicion(3,8);
        Hidralisco unidad = new Hidralisco(economia, pos);
        for (int i = 0; i<4; i++)
            unidad.pasarTurno();
        assertThrows(RuntimeException.class, () -> unidad.atacar(sacoDeBoxAereoProtoss) );
    }

    @Test
    public void unMutaliscoAtacaDentroDeSuRango(){
        Posicion pos = new Posicion(6,8);
        Mutalisco unidad = new Mutalisco(economia, pos);
        int danioEsperado = 9;

        for (int i = 0; i<8; i++)
            unidad.pasarTurno();

        for (int i = 0; i < 6; i++)
            unidad.atacar(sacoDeBoxTerrestreProtoss);

        assertEquals(danioEsperado, unidad.atacar(sacoDeBoxTerrestreProtoss) );
    }

    @Test
    public void unMutaliscoNoAtacaFueraDeSuRango(){
        Posicion pos = new Posicion(4,8);
        Mutalisco unidad = new Mutalisco(economia, pos);
        for (int i = 0; i<7; i++)
            unidad.pasarTurno();
        assertThrows(RuntimeException.class, () -> unidad.atacar(sacoDeBoxAereoZerg) );
    }

    @Test
    public void unDragonAtacaDentroDeSuRango(){
        Posicion pos = new Posicion(4,8);
        Dragon unidad = new Dragon(economia, pos);
        int danioEsperado = 20;

        for (int i = 0; i<6; i++)
            unidad.pasarTurno();

        for (int i = 0; i < 5; i++)
            unidad.atacar(sacoDeBoxAereoProtoss);

        assertEquals(danioEsperado, unidad.atacar(sacoDeBoxAereoProtoss) );
    }

    @Test
    public void unDragonNoAtacaFueraDeSuRango(){
        Posicion pos = new Posicion(3,8);
        Dragon unidad = new Dragon(economia, pos);
        for (int i = 0; i<6; i++)
            unidad.pasarTurno();
        assertThrows(RuntimeException.class, () -> unidad.atacar(sacoDeBoxAereoZerg) );
    }
}

