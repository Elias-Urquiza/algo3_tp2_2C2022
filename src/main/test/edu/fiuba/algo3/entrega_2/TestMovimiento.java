package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestMovimiento {

    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {

        Posicion posCriadero = new Posicion(25, 25);
        Posicion posPilon = new Posicion(15, 15);

        manager = new Manager(40, 40);
        manager.construirCriaderoEn(posCriadero, new Criadero(economia, posCriadero));
        manager.construirPilonEn(posPilon, new Pilon(economia, posPilon));

        for (int i = 0; i < 5; i++) {
            manager.pasarTurno();
        }

        manager.construirZerg(new Posicion(25,26), new ReservaDeReproduccion(economia, new Posicion(25,26) ) );

     //   for (int i = 0; i < 12; i++) {
     //       manager.pasarTurno();
     //  }
    }
    @Test
    public void unaUnidadAereaSeMuevePorElVacioSinDrama(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Scout scout = new Scout(economia, posInicial);
        for (int i = 0; i < 9; i++)
            scout.pasarTurno();
        scout.movete(posFinal, true);

        assert(scout.getPosicion().equals(posFinal));
    }

    @Test
    public void unaUnidadAereaSeMuevePorLaTierraSinDrama(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Scout scout = new Scout(economia, posInicial);

        for (int i = 0; i < 9; i++)
            scout.pasarTurno();

        scout.movete(posFinal, false);

        assert(scout.getPosicion().equals(posFinal));
    }


    @Test
    public void unaUnidadTerrestreNoSeMuevePorElVacio(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Dragon dragon = new Dragon(economia, posInicial);

        for (int i = 0; i < 6; i++)
            dragon.pasarTurno();

        dragon.movete(posFinal, true);

        assert( !(dragon.getPosicion().equals(posFinal)) );
    }

    @Test
    public void unaUnidadTerrestreSeMuevePorLaTierra(){

        Posicion posInicial =new Posicion(0,0);
        Posicion posFinal =new Posicion(4,4);

        Dragon dragon = new Dragon(economia, posInicial);
        for (int i = 0; i < 6; i++)
            dragon.pasarTurno();

        dragon.movete(posFinal, false);

        assert( (dragon.getPosicion().equals(posFinal)) );
    }

    //Ahora mas integral con manager y t0d0.
    @Test
    public void unaUnidadAereaSeMuevePorElVacioSinDramaZergIntegral(){

        Posicion posInicial =new Posicion(21,25);
        Posicion posFinal =new Posicion(21,23);

        Guarida guarida = new Guarida(economia, posInicial);
        manager.construirZerg(posInicial, guarida);
        Unidad  mutalisco = new Mutalisco(economia, posInicial);

        for (int i = 0; i < 7; i++)
            mutalisco.pasarTurno();

        manager.crearUnidad(posInicial,mutalisco);

        manager.moverUnidad(posFinal ,mutalisco);

        assert(mutalisco.getPosicion().equals(posFinal));
    }

    @Test
    public void unaUnidadTerrestreNoSeMuevePorElVacioZergIntegral(){

        Posicion posInicial =new Posicion(21,25);
        Posicion posFinal =new Posicion(25,26);

        Unidad  zerling = new Zerling(economia, posInicial);
        manager.crearUnidad(posInicial,zerling);

        zerling.pasarTurno();zerling.pasarTurno();

        assertDoesNotThrow( () -> manager.moverUnidad(posFinal ,zerling) );
    }

    @Test
    public void unaUnidadAereaSeMuevePorElVacioSinDramaProtossIntegral(){
        Posicion posInicial =new Posicion(15,18);
        Posicion posFinal =new Posicion(17,19);
        Posicion posAcceso = new Posicion(13,13);

        manager.construirProtoss(posAcceso, new Acceso(economia, posAcceso));
        PuertoEstelar puertoEstelar = new PuertoEstelar(economia, posInicial);
        manager.construirProtoss(posInicial, puertoEstelar);
        Unidad  scout = new Scout(economia, posInicial);
        for (int i = 0; i < 9; i++)
            scout.pasarTurno();
        manager.crearUnidad(posInicial, scout);

        manager.moverUnidad(posFinal, scout);

        assert(scout.getPosicion().equals(posFinal));
    }

    @Test
    public void unaUnidadTerrestreNoSeMuevePorElVacioProtossIntegral(){

        Posicion posInicial =new Posicion(21,25);
        Posicion posFinal =new Posicion(25,26);

        Unidad  dragon = new Dragon(economia, posInicial);
        manager.crearUnidad(posInicial,dragon);

        for (int i = 0; i < 6; i++)
            dragon.pasarTurno();

        assertDoesNotThrow( () -> manager.moverUnidad(posFinal ,dragon) );
    }

}
