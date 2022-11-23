package edu.fiuba.algo3.entrega_2.Unidades.Zerg;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHidralisco {

    @Test
    public void hidraliscoHaceDiezDeDanioDeTierraCorrectamente(){
        int esperado = 10;
        Hidralisco hidralisco1 = new Hidralisco(new MockEconomia(), new Posicion(1,1));
        Hidralisco hidralisco2 = new Hidralisco(new MockEconomia(), new Posicion(1,2));


        int resultado1 = hidralisco1.atacar(new Guarida(new MockEconomia(), new Posicion( 3,3)));
        int resultado2 = hidralisco2.atacar(hidralisco1);

        boolean afirmacion1 = esperado == resultado2;
        boolean afirmacion2 = esperado == resultado1;

        assert(afirmacion1 && afirmacion2);
    }

    @Test
    public void hidraliscoHaceDiezDeDanioDeAireCorrectamente(){
        int esperado = 10;
        Hidralisco hidralisco1 = new Hidralisco(new MockEconomia(), new Posicion(1,1));
        Mutalisco mutalisco = new Mutalisco(new MockEconomia(), new Posicion(1,2));

        int resultado1 = hidralisco1.atacar(mutalisco);

        assertEquals(esperado, resultado1);
    }

    @Test
    public void recibeDanioSoloTerrestre(){
        Hidralisco hidralisco = new Hidralisco(new MockEconomia(), new Posicion(1,1));
        Aire aire = new Aire(20);
        int esperado = 0;

        int resultado = hidralisco.recibirDanio(20, aire);

        assertEquals(esperado, resultado);
    }

}

