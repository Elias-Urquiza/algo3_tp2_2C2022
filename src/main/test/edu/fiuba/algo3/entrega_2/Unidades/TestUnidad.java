package edu.fiuba.algo3.entrega_2.Unidades;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnidad {

    private Manager manager;
    private static final Economia economia = new MockEconomia();

    @BeforeEach
    public void initEach() {
//16 - 24
        Posicion posCriadero = new Posicion(5, 5);
        Posicion posPilon = new Posicion(30, 30);

        Criadero criaderoPrincip = new Criadero(economia, posCriadero);

        manager = new Manager(40, 40);
        manager.construirCriaderoEn(posCriadero, criaderoPrincip);
        manager.construirPilonEn(posPilon, new Pilon(economia, posPilon));

        for (int i = 0; i < 5; i++) {
            manager.pasarTurno();
        }

        manager.construirZerg(new Posicion(3,3), new   ReservaDeReproduccion(economia, new Posicion(3,3) ) );
        manager.construirProtoss(new Posicion(31,31), new Acceso(economia, new Posicion(31,31)));

        for (int i = 0; i < 12; i++) {
            manager.pasarTurno();
        }

    }


    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoNoHayNada(){
        Posicion posConstruccion = new Posicion(3,3);
        Posicion posEsperada = new Posicion(2,2);
        Unidad bicho = new Zerling(economia, posConstruccion);

        manager.crearZerg(posConstruccion,  bicho);

        assert(posEsperada.equals(bicho.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayConstrucciones(){


        Posicion posConstruccionOrigenUnidad = new Posicion(3,3);
        Posicion posEsperada = new Posicion(4,3);
        Unidad bicho = new Zerling(economia, posConstruccionOrigenUnidad);
        manager.pasarTurno();

        Posicion posConstruccion1 = new Posicion(2,2);
        Posicion posConstruccion2 = new Posicion(2,3);
        Posicion posConstruccion3 = new Posicion(2,4);
        Posicion posConstruccion4 = new Posicion(3,2);
        Posicion posConstruccion5 = new Posicion(3,4);
        Posicion posConstruccion6 = new Posicion(4,2);

        manager.construirZerg(posConstruccion1, new ReservaDeReproduccion(economia, posConstruccion1) );
        manager.construirZerg(posConstruccion2, new ReservaDeReproduccion(economia, posConstruccion2) );

        manager.pasarTurno();
        manager.pasarTurno();

        manager.construirZerg(posConstruccion3, new ReservaDeReproduccion(economia, posConstruccion3) );
        manager.construirZerg(posConstruccion4, new ReservaDeReproduccion(economia, posConstruccion4) );

        manager.pasarTurno();
        manager.pasarTurno();

        manager.construirZerg(posConstruccion5, new ReservaDeReproduccion(economia, posConstruccion5) );
        manager.construirZerg(posConstruccion6, new ReservaDeReproduccion(economia, posConstruccion6) );

        manager.pasarTurno();
        manager.pasarTurno();

        manager.crearZerg(posConstruccionOrigenUnidad,  bicho);
        assert(posEsperada.equals(bicho.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayOtrasUnidades(){
        Posicion posConstruccionOrigenUnidad = new Posicion(3,3);
        Posicion posEsperada = new Posicion(4,3);

        Posicion posConstruccion1 = new Posicion(1,1);
        Posicion posConstruccion2 = new Posicion(1,2);
        Posicion posConstruccion3 = new Posicion(1,3);
        Posicion posConstruccion4 = new Posicion(1,4);

        manager.construirCriaderoEn(posConstruccion1, new Criadero(economia, posConstruccion1));
        manager.construirCriaderoEn(posConstruccion2, new Criadero(economia, posConstruccion2));
        manager.construirCriaderoEn(posConstruccion3, new Criadero(economia, posConstruccion3));
        manager.construirCriaderoEn(posConstruccion4, new Criadero(economia, posConstruccion4));


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
        Posicion posConstruccionOrigenUnidad = new Posicion(3,3);
        Posicion posEsperada = new Posicion(4,4);
        Posicion posConstruccion2 = new Posicion(2,3);
        Posicion posConstruccion5 = new Posicion(3,4);
        Posicion posConstruccion7 = new Posicion(4,3);

        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1,2);

        manager.construirCriaderoEn(pos1, new Criadero(economia, pos1));
        manager.construirCriaderoEn(pos2, new Criadero(economia, pos2));

        Unidad bicho1 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho3 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho4 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho6 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho7 = new Zerling(economia, posConstruccionOrigenUnidad);

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

    @Test
    public void siSoloSeTieneUnCriaderoSinLarvasNoSePuedeConstruirAlgo() {

    }

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
        Posicion pos1 = new Posicion(4,4);

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
