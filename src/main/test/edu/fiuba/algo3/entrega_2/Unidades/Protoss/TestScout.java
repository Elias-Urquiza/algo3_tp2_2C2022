package edu.fiuba.algo3.entrega_2.Unidades.Protoss;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContextSpi;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScout {

    @Test
    public void ScoutHaceOchoDeDanioDeTierraCorrectamente(){
        int esperado = 8;
        Scout unidad1 = new Scout(new MockEconomia(), new Posicion(1,1));
        Zerling unidad2 = new Zerling(new MockEconomia(), new Posicion(1,2));
        for (int i = 0; i < 9; i++)
            unidad1.pasarTurno();
        int resultado1 = unidad1.atacar(new Guarida(new MockEconomia(), new Posicion( 3,3)));
        int resultado2 = unidad1.atacar(unidad2);

        boolean afirmacion1 = esperado == resultado2;
        boolean afirmacion2 = esperado == resultado1;

        assert(afirmacion1 && afirmacion2);
    }

    @Test
    public void scoutHaceCatorceDeDanioDeAireCorrectamente(){
        int esperado = 14;
        Scout unidad1 = new Scout(new MockEconomia(), new Posicion(1,1));
        Mutalisco unidad2 = new Mutalisco(new MockEconomia(), new Posicion(1,2));
        for (int i = 0; i < 9; i++)
            unidad1.pasarTurno();
        int resultado1 = unidad1.atacar(unidad2);

        assertEquals(esperado, resultado1);
    }

    @Test
    public void recibeDanioSoloAereo(){
        Scout unidad = new Scout(new MockEconomia(), new Posicion(1,1));
        Tierra tierra = new Tierra(20, 100);
        int esperado = 0;
        for (int i = 0; i < 9; i++)
            unidad.pasarTurno();
        int resultado = unidad.recibirDanio(20, tierra, new Posicion(3, 3));

        assertEquals(esperado, resultado);
    }

}
