package edu.fiuba.algo3.entrega_2.Unidades;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnidad {

    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {
        manager = new Manager(40, 40);

        Pilon pilon = new Pilon(economia, new Posicion(6,6));
        manager.construirPilonEn(new Posicion(6,6), pilon);

        pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();pilon.pasarTurno();

        manager.construirZerg(new Posicion(34,34) , new ReservaDeReproduccion(economia, new Posicion(34,34) ) );
        manager.construirProtoss(new Posicion(6,8), new Acceso(economia, new Posicion(6,8)));

        for (int i = 0; i < 12; i++) {
            manager.pasarTurno();
        }

    }


    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoNoHayNada(){
        Posicion posConstruccion = new Posicion(6,8);
        Posicion posEsperada = new Posicion(5,7);
        Unidad bicho = new Zerling(economia, posConstruccion);

        manager.crearZerg(posConstruccion,  bicho);

        assert(posEsperada.equals(bicho.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayConstrucciones(){


        Posicion posConstruccionOrigenUnidad = new Posicion(6,8);
        Posicion posEsperada = new Posicion(7,8);
        Unidad bicho = new Dragon(economia, posConstruccionOrigenUnidad);
        manager.pasarTurno();

        Posicion posConstruccion1 = new Posicion(5,7);
        Posicion posConstruccion2 = new Posicion(5,8);
        Posicion posConstruccion3 = new Posicion(5,9);
        Posicion posConstruccion4 = new Posicion(6,7);
        Posicion posConstruccion5 = new Posicion(6,9);
        Posicion posConstruccion6 = new Posicion(7,7);

        manager.construirProtoss(posConstruccion1, new Acceso(economia, posConstruccion1) );
        manager.construirProtoss(posConstruccion2, new Acceso(economia, posConstruccion2) );

        manager.pasarTurno();
        manager.pasarTurno();

        manager.construirProtoss(posConstruccion3, new Acceso(economia, posConstruccion3) );
        manager.construirProtoss(posConstruccion4, new Acceso(economia, posConstruccion4) );

        manager.pasarTurno();
        manager.pasarTurno();

        manager.construirProtoss(posConstruccion5, new Acceso(economia, posConstruccion5) );
        manager.construirProtoss(posConstruccion6, new Acceso(economia, posConstruccion6) );

        manager.pasarTurno();
        manager.pasarTurno();

        manager.crearZerg(posConstruccionOrigenUnidad,  bicho);
        assert(posEsperada.equals(bicho.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayOtrasUnidades(){
        Posicion posConstruccionOrigenUnidad = new Posicion(37,37);
        Posicion posEsperada = new Posicion(38,37);

        Posicion posConstruccion1 = new Posicion(31,1);
        Posicion posConstruccion2 = new Posicion(32,2);
        Posicion posConstruccion3 = new Posicion(33,3);
        Posicion posConstruccion4 = new Posicion(34,4);

        Criadero criadero1 = new Criadero(economia, posConstruccion1);
        Criadero criadero2 = new Criadero(economia, posConstruccion2);
        Criadero criadero3 = new Criadero(economia, posConstruccion3);
        Criadero criadero4 = new Criadero(economia, posConstruccion4);

        manager.construirCriaderoEn(posConstruccion1, criadero1);
        criadero1.pasarTurno();criadero1.pasarTurno();criadero1.pasarTurno();criadero1.pasarTurno();
        manager.construirCriaderoEn(posConstruccion2, criadero2);
        manager.construirCriaderoEn(posConstruccion3, criadero3);
        manager.construirCriaderoEn(posConstruccion4, criadero4);

        for(int i = 0; i < 4; i++){
            criadero4.pasarTurno();criadero3.pasarTurno();criadero2.pasarTurno();
        }

        Unidad bicho1 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho2 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho3 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho4 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho5 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho6 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho7 = new Zerling(economia, posConstruccionOrigenUnidad);

        manager.crearZerg(posConstruccionOrigenUnidad, bicho1);
        manager.crearZerg(posConstruccionOrigenUnidad, bicho2);
        manager.crearZerg(posConstruccionOrigenUnidad, bicho3);
        manager.crearZerg(posConstruccionOrigenUnidad, bicho4);
        manager.crearZerg(posConstruccionOrigenUnidad, bicho5);
        manager.crearZerg(posConstruccionOrigenUnidad, bicho6);

        manager.crearZerg(posConstruccionOrigenUnidad, bicho7);

        assert(posEsperada.equals(bicho7.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayOtrasUnidadesYConstrucciones(){
        Posicion posConstruccionOrigenUnidad = new Posicion(38,33);
        Posicion posEsperada                 = new Posicion(39,34);
        Posicion posConstruccion2 = new Posicion(37,33);
        Posicion posConstruccion5 = new Posicion(38,34);
        Posicion posConstruccion7 = new Posicion(39,33);

        Posicion pos1 = new Posicion(39,2);
        Posicion pos2 = new Posicion(39,3);
        Posicion pos3 = new Posicion(39,0);
        Posicion pos4 = new Posicion(39,1);

        Criadero criadero1 = new Criadero(economia, pos1);
        Criadero criadero2 = new Criadero(economia, pos2);
        Criadero criadero3 = new Criadero(economia, pos3);
        Criadero criadero4 = new Criadero(economia, pos4);

        manager.construirCriaderoEn(pos1, criadero1);
        criadero1.pasarTurno();criadero1.pasarTurno();criadero1.pasarTurno();criadero1.pasarTurno();
        manager.construirCriaderoEn(pos2,criadero2);
        criadero2.pasarTurno();criadero2.pasarTurno();criadero2.pasarTurno();criadero2.pasarTurno();
        manager.construirCriaderoEn(pos3, criadero3);
        manager.construirCriaderoEn(pos4, criadero4);

        for(int i = 0; i < 4; i++){
            criadero4.pasarTurno();criadero3.pasarTurno();
        }

        ReservaDeReproduccion reproduccion= new ReservaDeReproduccion(economia, posConstruccionOrigenUnidad);
        manager.construirZerg(posConstruccionOrigenUnidad, reproduccion );
        for (int i =0; i< 12; i++) reproduccion.pasarTurno();

        Unidad bicho1 = new Zerling(economia, posConstruccionOrigenUnidad);// (33,33)
        Unidad bicho3 = new Zerling(economia, posConstruccionOrigenUnidad);// (33,35)
        Unidad bicho4 = new Zerling(economia, posConstruccionOrigenUnidad);// (34,33)
        Unidad bicho6 = new Zerling(economia, posConstruccionOrigenUnidad);// (35,33)
        Unidad bicho7 = new Zerling(economia, posConstruccionOrigenUnidad);// (35,)

        manager.crearZerg(posConstruccionOrigenUnidad, bicho1);
        manager.construirZerg(posConstruccion2, new ReservaDeReproduccion(economia, posConstruccion2));
        manager.crearZerg(posConstruccionOrigenUnidad, bicho3);
        manager.crearZerg(posConstruccionOrigenUnidad, bicho4);
        manager.construirZerg(posConstruccion5, new ReservaDeReproduccion(economia, posConstruccion5) );
        manager.crearZerg(posConstruccionOrigenUnidad, bicho6);
        manager.construirZerg(posConstruccion7, new ReservaDeReproduccion(economia, posConstruccion7) );

        manager.crearZerg(posConstruccionOrigenUnidad, bicho7);

        assert(posEsperada.equals(bicho7.getPosicion()));

    }


    /*
    -----------------------------------------------------------------------------------------------------------
    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayOtrasUnidadesYConstrucciones(){
        Posicion posConstruccionOrigenUnidad = new Posicion(3,3);
        Posicion posEsperada = new Posicion(4,4);            y
        Posicion posConstruccion2 = new Posicion(2,3);    x 1234
        Posicion posConstruccion5 = new Posicion(3,4);      2
        Posicion posConstruccion7 = new Posicion(4,3);      3

        Unidad bicho1 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho3 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho4 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho6 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho7 = new Zerling(economia, posConstruccionOrigenUnidad);

        manager.crearUnidad(posConstruccionOrigenUnidad, bicho1);
        manager.construirZerg(posConstruccion2, new ReservaDeReproduccion(economia, posConstruccion2));
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho3);
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho4);
        manager.construirZerg(posConstruccion5, new ReservaDeReproduccion(economia, posConstruccion5) );
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho6);
        manager.construirZerg(posConstruccion7, new ReservaDeReproduccion(economia, posConstruccion7) );

        manager.crearUnidad(posConstruccionOrigenUnidad, bicho7);

        assert(posEsperada.equals(bicho7.getPosicion()));
    }
    ----------------------------------------------------------------------------------------------------------
     */

    @Test
    public void unaUnidadParaLaCualPasoSuTiempoDeCreacionSePuedeMover(){
        Posicion pos0 = new Posicion(3,3);
        Posicion pos1 = new Posicion(4,4);

        Unidad bicho1 = new Zerling(economia, pos0);

        bicho1.pasarTurno();
        bicho1.pasarTurno();

        assertDoesNotThrow( () -> bicho1.movete(pos1, false));
    }
    @Test
    public void unaUnidadParaLaCualPasoSuTiempoDeCreacionPuedeAtacar(){
        Posicion pos0 = new Posicion(3,3);
        Posicion pos1 = new Posicion(3,4);

        Unidad bicho1 = new Zerling(economia, pos0);

        bicho1.pasarTurno();
        bicho1.pasarTurno();

        assertDoesNotThrow( () -> bicho1.atacar(new Pilon(economia, pos1) ) );
    }

    @Test
    public void unaUnidadParaLaCualNoPasoSuTiempoDeCreacionNoFunciona(){
        Posicion pos0 = new Posicion(3,3);
        Posicion pos1 = new Posicion(4,4);

        Unidad bicho1 = new Zerling(economia, pos0);

        Assertions.assertThrows( RuntimeException.class, () -> bicho1.movete(pos1, false) );
    }

    @Test
    public void noSePuedeConstruirUnZergSobreUnaUnidad(){
        Posicion pos0 = new Posicion(3,3);
        Posicion pos1 = new Posicion(2,2);

        Unidad bicho1 = new Zerling(economia, pos0);
        manager.crearZerg(pos0, bicho1);

        assertThrows( RuntimeException.class , ()-> manager.construirZerg(pos1, new ReservaDeReproduccion(economia,  pos1) ) );
    }

    @Test
    public void noSePuedeConstruirUnProtossSobreUnaUnidad(){
        Posicion pos0 = new Posicion(31,31);
        Posicion pos1 = new Posicion(30,31);

        Unidad bicho1 = new Dragon(economia, pos0);
        manager.crearProtoss(pos0, bicho1);

        assertThrows( RuntimeException.class , ()-> manager.construirProtoss(pos1, new Acceso(economia,  pos1) ) );
    }

}
