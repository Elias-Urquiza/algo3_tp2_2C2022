package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMovimiento {

    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {
//16 - 24
        Posicion posCriadero = new Posicion(25, 25);
        Posicion posPilon = new Posicion(15, 15);

        manager = new Manager(40, 40);
        manager.construirCriaderoEn(posCriadero, new Criadero(economia, posCriadero));
        manager.construirPilonEn(posPilon, new Pilon(economia, posPilon));

        for (int i = 0; i < 5; i++) {
            manager.pasarTurno();
        }
    }
    @Test
    public void unaUnidadAereaSeMuevePorElVacioSinDrama(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Scout scout = new Scout(economia, posInicial);

        scout.movete(posFinal, true);

        assert(scout.getPosicion().equals(posFinal));
    }

    @Test
    public void unaUnidadAereaSeMuevePorLaTierraSinDrama(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Scout scout = new Scout(economia, posInicial);

        scout.movete(posFinal, false);

        assert(scout.getPosicion().equals(posFinal));
    }


    @Test
    public void unaUnidadTerrestreNoSeMuevePorElVacio(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Dragon dragon = new Dragon(economia, posInicial);

        dragon.movete(posFinal, true);

        assert( !(dragon.getPosicion().equals(posFinal)) );
    }

    @Test
    public void unaUnidadTerrestreSeMuevePorLaTierra(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Dragon dragon = new Dragon(economia, posInicial);

        dragon.movete(posFinal, false);

        assert( (dragon.getPosicion().equals(posFinal)) );
    }

    //Ahora mas integral con manager y t0d0.


}
