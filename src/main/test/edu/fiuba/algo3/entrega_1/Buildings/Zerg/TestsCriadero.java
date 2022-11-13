package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.mocks.CriaderoActivo;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestsCriadero {
private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void seExtraeUnaLarvaDeUnCriaderoConTres(){
        Criadero unCriadero = new CriaderoActivo();
        boolean afirmacion = true;

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

    @Test//pruebo un caso negativo, osea que falle y lance excepcion
    public void extraerMasLarvasDeLasDisponiblesResultanEnExecpcion(){
        Criadero unCriadero = new Criadero(mockEconomia, 0, 0);
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
        Criadero unCriadero = new CriaderoActivo();
        boolean afirmacion = true;


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
        Criadero unCriadero = new CriaderoActivo();
        boolean afirmacion = false;

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
        Criadero unCriadero = new CriaderoActivo();
        boolean afirmacion = true;

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
        Criadero unCriadero = new CriaderoActivo();
        boolean afirmacion = true;

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

    @Test
    public void unCriaderoSeConstruyeEnElTiempoEstipulado(){
        Criadero unCriadero = new Criadero(mockEconomia, 0, 0);
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

    @Test
    public void noSePuedeUsarElCriaderoAntesDeQueSeTermineDeConstruir(){
        final Criadero criadero = new Criadero(mockEconomia, 0, 0);
        Assertions.assertThrows(RuntimeException.class, () -> criadero.extraerLarvas(1));
    }

}
