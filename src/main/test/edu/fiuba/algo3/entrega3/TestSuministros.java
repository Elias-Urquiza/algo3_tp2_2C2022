package edu.fiuba.algo3.entrega3;

import edu.fiuba.algo3.modelo.Suministros;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestSuministros {

    Suministros suministros;
    @Before
    public void init() {
        suministros = new Suministros();
    }

    @Test
    public void aumentoLosSuministrosYDevuelveLosSuministrosCorrectos() {
        Assertions.assertEquals(5,  suministros.suministrar(5));
    }

    @Test
    public void aumentoLosSuministrosMayormenteAlLimiteYTiraExcepcion() {
        Assertions.assertThrows(RuntimeException.class, () -> suministros.suministrar(1000));
    }

    @Test
    public void aumentoLosSuministrosOkYDespuesMePasoYTiraExcepcion() {
        Assertions.assertEquals(5,  suministros.suministrar(5));
        Assertions.assertThrows(RuntimeException.class, () -> suministros.suministrar(1000));
    }

    @Test
    public void aumentoLosSuministrosMaximosYLuegoSuministrarDevuelveCorrectamente() {
        Assertions.assertEquals(10200,  suministros.aumentarMaxSuminstros(10000));
        Assertions.assertEquals(1000,  suministros.suministrar(1000));
    }

    @Test
    public void aumentoLosSuministrosMaximosYAlSuministrarMasTiraExcepcion() {
        Assertions.assertEquals(10200,  suministros.aumentarMaxSuminstros(10000));
        Assertions.assertThrows(RuntimeException.class, () -> suministros.suministrar(10201));
    }

    @Test
    public void disminuyoLosSuministrosTotalmenteYNoPuedoConstruir() {
        Assertions.assertEquals(0, suministros.disminuirMaximo(300));
        Assertions.assertThrows(RuntimeException.class, () -> suministros.suministrar(10));
    }
}
