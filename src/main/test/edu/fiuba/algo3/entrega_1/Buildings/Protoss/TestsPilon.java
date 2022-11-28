package edu.fiuba.algo3.entrega_1.Buildings.Protoss;


import com.tngtech.archunit.thirdparty.com.google.common.base.Ticker;
import com.tngtech.archunit.thirdparty.com.google.common.math.Quantiles;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.tiles.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.LinkedList;

public class TestsPilon {

    private static final Economia mockEconomia = new MockEconomia();
    
    @Mock
    private FloorManager fm;
    @Test
    public void unPilonSeVuelveOperativoDespuesDeQuePasenSeisTurnos(){
        
        fm = new FloorManager( (new LinkedList<Moho>()), new LinkedList< Cristales >(),new LinkedList< Volcan >(), new LinkedList< Energia >(), 
             new LinkedList< TileVacia >(), new LinkedList< ConstruccionZerg >(), new LinkedList< ConstruccionProtoss >(), 
             new LinkedList< ExtraeRecurso >(), new LinkedList<Vacio>(),20, 20);

        Posicion pos = new Posicion(0,0);

        Pilon pilon = new Pilon(mockEconomia, pos);

        pilon.setFloorManager(fm);

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
        final Pilon pilon = new Pilon(mockEconomia, new Posicion(0,0));
        Assertions.assertThrows(RuntimeException.class, () -> pilon.usar());
    }


}
