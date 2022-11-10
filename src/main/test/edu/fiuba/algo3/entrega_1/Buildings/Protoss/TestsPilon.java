package edu.fiuba.algo3.entrega_1.Buildings.Protoss;


import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsPilon {

    @Test
    public void unPilonSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Pilon pilon = new Pilon();
        boolean afirmacion = true;

        for(int i = 0; i < 5; i++)
            pilon.pasarTurno();

        try{
            pilon.usar();
        }catch (RuntimeException e){
            afirmacion = false;
        }

        assert(afirmacion);
    }

    @Test
    public void noSePuedeUsarElPilonAntesDeQueSeTermineDeConstruir(){
        final Pilon pilon = new Pilon();
        Assertions.assertThrows(RuntimeException.class, () -> pilon.usar());
    }


}
