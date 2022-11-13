package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.mocks.CriaderoActivo;
import org.junit.jupiter.api.Test;

public class TestCriaderoActivo {
    @Test
    public void cuandoCreoUnCriaderoActivoEfectivamenteEstaActivo() {

        Criadero unCriadero = new CriaderoActivo();
        boolean afirmacion = true;

        try{
            unCriadero.extraerLarvas(3);
        }
        catch (RuntimeException unaExcepcion){
            afirmacion = false;
        }
        assert(afirmacion);
    }
}
