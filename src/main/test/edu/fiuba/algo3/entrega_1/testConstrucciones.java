package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import org.junit.Test;

public class testConstrucciones {

    @Test
    public void unCriaderoSeConstruyeEnElTiempoEstipulado(){
        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        try{
            unCriadero.extraerLarvas(1);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }
}
