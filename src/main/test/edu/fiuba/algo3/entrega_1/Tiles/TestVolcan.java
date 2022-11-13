package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.tiles.Recurso;
import edu.fiuba.algo3.modelo.tiles.Volcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVolcan {

    Recurso rec;

    @BeforeEach
    public void init() { rec = new Volcan(0, 0);}
    @Test
    public void tratoDeExtraerYDevuelveCorrectamente() {
        Assertions.assertEquals(100, rec.extraer(100));
    }

    @Test
    public void extraigoTodosLosRecursosYCuandoVuelvoAExtraerFalla() {
        Assertions.assertEquals(5000, rec.extraer(5000));
        Assertions.assertThrows(RuntimeException.class, () -> rec.extraer(10));
    }

    @Test
    public void siQuedaPocoRecursoYQuieroExtraerMasDeLoQueQuedaEntoncesDevuelveLoQueQueda() {
        Assertions.assertEquals(4950, rec.extraer(4950));
        Assertions.assertEquals(50, rec.extraer(100));
    }
}
