package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Economia;
import org.junit.jupiter.api.Test;

public class TestsEconomia {


    @Test
    public void agregarGasVespenoNoDevuelveExcepcion(){
        Economia unaEconomia = new Economia();
        boolean afirmacion = true;

        try {
            unaEconomia.ingresarGasVespeno(200);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void gastarGasVespenoSeLlevaACaboSinExecpciones(){

        Economia unaEconomia = new Economia();
        boolean afirmacion = true;

        unaEconomia.ingresarGasVespeno(200);
        try {
            unaEconomia.gastarGasVespeno(200);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void agregarMineralNoDevuelveExcepcion(){
        Economia unaEconomia = new Economia();
        boolean afirmacion = true;

        try {
            unaEconomia.ingresarMineral(200);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void gastarMineralSeLlevaACaboSinExecpciones(){

        Economia unaEconomia = new Economia();
        boolean afirmacion = true;

        unaEconomia.ingresarMineral(200);
        try {
            unaEconomia.gastarMineral(200);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

}
