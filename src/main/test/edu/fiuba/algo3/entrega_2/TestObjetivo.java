package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestObjetivo {

    int muchoRango = 10000;
    Posicion posicionEnRangoParaTestear = new Posicion(3, 3);

    @Test
    public void unAtaqueTerrestreAUnaConstruccionSeRealizaCorrectamente(){
        int esperado = 40;
        Ataque ataque= new Tierra(esperado, muchoRango);
        Espiral espiral = new Espiral(new MockEconomia(), new Posicion(1,1));

        int resultado = espiral.recibirDanio(esperado, ataque, posicionEnRangoParaTestear);

        assertEquals(esperado, resultado);
    }

    @Test
    public void unAtaqueTerrestreAUnaUnidadTerrestreSeRealizaCorrectamente(){
        int esperado = 20;
        Ataque ataque= new Tierra(esperado, muchoRango);
        Zerling bicho = new Zerling(new MockEconomia(), new Posicion(1,1));

        int resultado = bicho.recibirDanio(esperado, ataque, posicionEnRangoParaTestear);

        assertEquals(esperado, resultado);
    }

    @Test
    public void unAtaqueAereoAUnaUnidadAereaSeRealizaCorrectamente(){
        int esperado = 20;
        Ataque ataque= new Aire(esperado, muchoRango);
        Mutalisco bicho = new Mutalisco(new MockEconomia(), new Posicion(1,1));

        int resultado = bicho.recibirDanio(esperado, ataque, posicionEnRangoParaTestear);

        assertEquals(esperado, resultado);
    }

    @Test
    public void unAtaqueTerrestreAUnaUnidadAereaNoSeRealiza(){
        int esperado = 0;
        Ataque ataque= new Tierra(20,muchoRango);
        Mutalisco bicho = new Mutalisco(new MockEconomia(), new Posicion(1,1));

        int resultado = bicho.recibirDanio(20, ataque, posicionEnRangoParaTestear);

        assertEquals(esperado, resultado);
    }

    @Test
    public void unAtaqueAereoAUnaUnidadTerrestreNoSeRealiza(){
        int esperado = 0;
        Ataque ataque= new Aire(20, muchoRango);
        Dragon bicho = new Dragon(new MockEconomia(), new Posicion(1,1));

        int resultado = bicho.recibirDanio(20, ataque, posicionEnRangoParaTestear);

        assertEquals(esperado, resultado);
    }

    @Test
    public void unAtaqueQueMataDevuelveLaVidaRestanteDelObjetivo(){
        int esperado = 100;
        Ataque ataque= new Aire(esperado, muchoRango);
        Mutalisco bicho = new Mutalisco(new MockEconomia(), new Posicion(1,1));

        int resultado = bicho.recibirDanio(esperado, ataque, posicionEnRangoParaTestear);
        assertEquals(esperado, resultado);
        resultado = bicho.recibirDanio(esperado, ataque, posicionEnRangoParaTestear);
        assertEquals(20, resultado);
    }


}
