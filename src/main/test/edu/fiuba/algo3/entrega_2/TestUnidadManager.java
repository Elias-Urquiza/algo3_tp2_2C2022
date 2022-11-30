package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.UnidadManager;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUnidadManager {

    private UnidadManager unidadManager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach(){
        unidadManager = new UnidadManager();
    }

    @Test
    public void QuieroEvolucionarUnaUnidadYEsCorrecto(){
        Boolean chequeo = true;
        Posicion pos = new Posicion(5,5);
        Mutalisco unidad1 = new Mutalisco(economia, pos );
        Guardian guardian = new Guardian(economia, new Posicion(3,3));
        unidadManager.crearUnidad(unidad1, pos);
        try {
            unidadManager.chequeoEvolucion(unidad1, guardian);
        }catch (RuntimeException e){
            chequeo = false;
        }

        assert(chequeo);


    }

    @Test
    public void QuieroEvolucionarUnaUnidadYEsIncorrecto(){
        Boolean chequeo = false;
        Posicion pos = new Posicion(5,5);
        Mutalisco unidad1 = new Mutalisco(economia, pos );
        Guardian guardian = new Guardian(economia, new Posicion(3,3));
        unidadManager.crearUnidad(unidad1, pos);
        try {
            unidadManager.chequeoEvolucion(new Mutalisco(economia, new Posicion(2, 2)), guardian);
        }catch (RuntimeException e){
            chequeo = true;
        }

        assert(chequeo);


    }
}
