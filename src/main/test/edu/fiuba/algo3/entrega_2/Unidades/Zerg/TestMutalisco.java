package edu.fiuba.algo3.entrega_2.Unidades.Zerg;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMutalisco {

    @Test
    public void mutaliscoHaceNueveDeDanioDeTierraCorrectamente(){
        int esperado = 9;
        Mutalisco unidad1 = new Mutalisco(new MockEconomia(), new Posicion(1,1));
        Zerling unidad2 = new Zerling(new MockEconomia(), new Posicion(1,2));


        int resultado1 = unidad1.atacar(new Guarida(new MockEconomia(), new Posicion( 3,3)));
        int resultado2 = unidad1.atacar(unidad2);

        boolean afirmacion1 = esperado == resultado2;
        boolean afirmacion2 = esperado == resultado1;

        assert(afirmacion1 && afirmacion2);
    }

    @Test
    public void mutaliscoHaceNueveDeDanioDeAireCorrectamente(){
        int esperado = 9;
        Mutalisco mutalisco1 = new Mutalisco(new MockEconomia(), new Posicion(1,1));
        Mutalisco mutalisco2 = new Mutalisco(new MockEconomia(), new Posicion(1,2));

        int resultado1 = mutalisco1.atacar(mutalisco2);

        assertEquals(esperado, resultado1);
    }

    @Test
    public void recibeDanioSoloAereo(){
        Mutalisco mutalisco = new Mutalisco(new MockEconomia(), new Posicion(1,1));
        Tierra tierra = new Tierra(20);
        int esperado = 0;

        int resultado = mutalisco.recibirDanio(20, tierra);

        assertEquals(esperado, resultado);
    }

}
