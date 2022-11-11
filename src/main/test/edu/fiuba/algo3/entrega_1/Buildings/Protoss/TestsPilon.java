package edu.fiuba.algo3.entrega_1.Buildings.Protoss;


import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsPilon {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void unPilonSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){

        Pilon pilon = new Pilon(mockEconomia, 0, 0);
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
        final Pilon pilon = new Pilon(mockEconomia, 0, 0);
        Assertions.assertThrows(RuntimeException.class, () -> pilon.usar());
    }


}
