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

        manager = new Manager(40, 40);
        manager.construirCriaderoEn(posCriadero, new Criadero(economia, posCriadero));
        manager.construirPilonEn(posPilon, new Pilon(economia, posPilon));

        for (int i = 0; i < 5; i++) {
            manager.pasarTurno();
        }

        manager.construirZerg(new Posicion(3,3), new ReservaDeReproduccion(economia, new Posicion(3,3) ) );

        for (int i = 0; i < 12; i++) {
            manager.pasarTurno();
        }
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoNoHayNada(){
        Posicion posConstruccion = new Posicion(3,3);
        Posicion posEsperada = new Posicion(2,2);
        Unidad bicho = new Zerling(economia, posConstruccion);

        manager.crearUnidad(posConstruccion,  bicho);

        assert(posEsperada.equals(bicho.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayConstrucciones(){
        Posicion posConstruccionOrigenUnidad = new Posicion(3,3);
        Posicion posEsperada = new Posicion(4,3);
        Unidad bicho = new Zerling(economia, posConstruccionOrigenUnidad);

        Posicion posConstruccion1 = new Posicion(2,2);
        Posicion posConstruccion2 = new Posicion(2,3);
        Posicion posConstruccion3 = new Posicion(2,4);
        Posicion posConstruccion4 = new Posicion(3,2);
        Posicion posConstruccion5 = new Posicion(3,4);
        Posicion posConstruccion6 = new Posicion(4,2);

        manager.construirZerg(posConstruccion1, new ReservaDeReproduccion(economia, posConstruccion1) );
        manager.construirZerg(posConstruccion2, new ReservaDeReproduccion(economia, posConstruccion2) );
        manager.construirZerg(posConstruccion3, new ReservaDeReproduccion(economia, posConstruccion3) );
        manager.construirZerg(posConstruccion4, new ReservaDeReproduccion(economia, posConstruccion4) );
        manager.construirZerg(posConstruccion5, new ReservaDeReproduccion(economia, posConstruccion5) );
        manager.construirZerg(posConstruccion6, new ReservaDeReproduccion(economia, posConstruccion6) );

        manager.crearUnidad(posConstruccionOrigenUnidad,  bicho);
        assert(posEsperada.equals(bicho.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayOtrasUnidades(){
        Posicion posConstruccionOrigenUnidad = new Posicion(3,3);
        Posicion posEsperada = new Posicion(4,3);
        Unidad bicho1 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho2 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho3 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho4 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho5 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho6 = new Zerling(economia, posConstruccionOrigenUnidad);
        Unidad bicho7 = new Zerling(economia, posConstruccionOrigenUnidad);


        manager.crearUnidad(posConstruccionOrigenUnidad, bicho1);
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho2);
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho3);
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho4);
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho5);
        manager.crearUnidad(posConstruccionOrigenUnidad, bicho6);

        manager.crearUnidad(posConstruccionOrigenUnidad, bicho7);

        assert(posEsperada.equals(bicho7.getPosicion()));
    }

    @Test
    public void seCreaUnaUnidadAlLadoDelEdificioQueLaCreaCuandoEnUnRadioDeUnoHayOtrasUnidadesYConstrucciones(){
        Posicion posConstruccionOrigenUnidad = new Posicion(3,3);
        Posicion posEsperada = new Posicion(4,4);
        Posicion posConstruccion2 = new Posicion(2,3);
        Posicion posConstruccion5 = new Posicion(3,4);
        Posicion posConstruccion7 = new Posicion(4,3);

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




}
