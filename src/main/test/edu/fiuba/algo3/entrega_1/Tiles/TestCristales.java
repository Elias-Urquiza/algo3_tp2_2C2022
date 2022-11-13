package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.tiles.Cristales;
import edu.fiuba.algo3.modelo.tiles.Recurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCristales {
    Recurso rec;

    @BeforeEach
    public void init() { rec = new Cristales(new Posicion(0,0));}
    @Test
    public void tratoDeExtraerYDevuelveCorrectamente() {
        Assertions.assertEquals(100, rec.extraer(100));
    }

    @Test
    public void extraigoTodosLosRecursosYCuandoVuelvoAExtraerFalla() {
        Assertions.assertEquals(2000, rec.extraer(2000));
        Assertions.assertThrows(RuntimeException.class, () -> rec.extraer(10));
    }

    @Test
    public void siQuedaPocoRecursoYQuieroExtraerMasDeLoQueQuedaEntoncesDevuelveLoQueQueda() {
        Assertions.assertEquals(1950, rec.extraer(1950));
        Assertions.assertEquals(50, rec.extraer(100));
    }

}
