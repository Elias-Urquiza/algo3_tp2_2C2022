package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Criadero;
import org.junit.Test;



public class TestsCriadero {

    @Test
    public void seExtraeUnaLarvaDeUnCriaderoConTres(){

        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        try{
            unCriadero.extraerLarvas(1);
        }
        catch (Exception unaExcepcion){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void seExtraeTodasLasLarvasDeUnCriadero(){

        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        try{
            unCriadero.extraerLarvas(3);
        }
        catch (Exception unaExcepcion){
            afirmacion = false;
        }
        assert(afirmacion);

    }

    @Test//pruebo un caso negativo, osea que falle y lance excepcion
    public void extraerMasLarvasDeLasDisponiblesResultanEnExecpcion(){
        Criadero unCriadero = new Criadero();
        boolean afirmacion = false;

        try{
            unCriadero.extraerLarvas(4);
        }
        catch (Exception unaExcepcion){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    //FALTA PRUEBA: Probar que pasado un turno si el criadero no tenia 3 larvas, que genere una mas. se puede hacer
    //              sacando una larva y dejar pasar un turno y ahora sacar 3.
}
