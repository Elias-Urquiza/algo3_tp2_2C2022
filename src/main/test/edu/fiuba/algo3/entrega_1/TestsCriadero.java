package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import org.junit.Test;



public class TestsCriadero {

    @Test
    public void seExtraeUnaLarvaDeUnCriaderoConTres(){

        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        try{
            unCriadero.extraerLarvas(1);
        }
        catch (RuntimeException unaExcepcion){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void seExtraeTodasLasLarvasDeUnCriadero(){

        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        try{
            unCriadero.extraerLarvas(3);
        }
        catch (RuntimeException unaExcepcion){
            afirmacion = false;
        }
        assert(afirmacion);

    }

    @Test//pruebo un caso negativo, osea que falle y lance excepcion
    public void extraerMasLarvasDeLasDisponiblesResultanEnExecpcion(){
        Criadero unCriadero = new Criadero();
        boolean afirmacion = false;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        try{
            unCriadero.extraerLarvas(4);
        }
        catch (RuntimeException unaExcepcion){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void siSeExtrajoLarvasEntoncesDespuesDeUnTurnoSeRegeneraUna() {
        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        unCriadero.extraerLarvas(1);
        unCriadero.pasarTurno();

        try {
            unCriadero.extraerLarvas(3);
        } catch (RuntimeException unaExcepcion) {
            afirmacion = false;
        }
        assert (afirmacion);
    }

    @Test
    public void siSePasaUnTurnoYLasLarvasEstanAlMaximoNoSeGeneraNingunaNueva() {
        Criadero unCriadero = new Criadero();
        boolean afirmacion = false;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        unCriadero.extraerLarvas(1);
        unCriadero.pasarTurno();

        try {
            unCriadero.extraerLarvas(4);
        } catch (RuntimeException unaExcepcion) {
            afirmacion = true;
        }
        assert (afirmacion);
    }

    @Test
    public void seExtraenDosLarvasEntoncesEnDosTurnosSeRepusieron() {
        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        unCriadero.extraerLarvas(3);
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        try {
            unCriadero.extraerLarvas(2);
        } catch (RuntimeException unaExcepcion) {
            afirmacion = false;
        }
        assert (afirmacion);
    }
    @Test
    public void seExtraenTresLarvasEntoncesEnTresTurnosSeRepusieron() {
        Criadero unCriadero = new Criadero();
        boolean afirmacion = true;

        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        unCriadero.extraerLarvas(3);
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();
        unCriadero.pasarTurno();

        try {
            unCriadero.extraerLarvas(3);
        } catch (RuntimeException unaExcepcion) {
            afirmacion = false;
        }
        assert (afirmacion);
    }

    //FALTA PRUEBA: Probar que pasado un turno si el criadero no tenia 3 larvas, que genere una mas. se puede hacer
    //              sacando una larva y dejar pasar un turno y ahora sacar 3.
}
