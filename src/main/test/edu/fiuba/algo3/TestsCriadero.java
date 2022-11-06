package edu.fiuba.algo3;

import org.junit.Test;



public class TestsCriadero {

    @Test
    public void seExtraeUnaLarvaDelCriaderoCorrectamente(){

        Criadero unCriadero = new Criadero();

        try{unCriadero.extraerLarva(1);}
        catch (RuntimeException unaExcepcion){
            assert(false);
        }
        assert(true);
    }
}
