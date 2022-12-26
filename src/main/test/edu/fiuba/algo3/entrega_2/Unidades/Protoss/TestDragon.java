package edu.fiuba.algo3.entrega_2.Unidades.Protoss;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDragon {
    @Test
    public void DragonHaceVeinteDeDanioDeTierraCorrectamente(){
        int esperado = 20;
        Dragon unidad1 = new Dragon(new MockEconomia(), new Posicion(1,1));
        Zerling unidad2 = new Zerling(new MockEconomia(), new Posicion(1,2));

        for (int i = 0; i < 6; i++)
            unidad1.pasarTurno();

        int resultado1 = unidad1.atacar(new Guarida(new MockEconomia(), new Posicion( 3,3)));
        int resultado2 = unidad1.atacar(unidad2);

        boolean afirmacion1 = esperado == resultado2;
        boolean afirmacion2 = esperado == resultado1;

        assert(afirmacion1 && afirmacion2);
    }

    @Test
    public void dragonHaceVeinteDeDanioDeAireCorrectamente(){
        int esperado = 20;
        Dragon unidad1 = new Dragon(new MockEconomia(), new Posicion(1,1));
        Mutalisco unidad2 = new Mutalisco(new MockEconomia(), new Posicion(1,2));
        for (int i = 0; i < 6; i++)
            unidad1.pasarTurno();
        int resultado1 = unidad1.atacar(unidad2);

        assertEquals(esperado, resultado1);
    }

    @Test
    public void recibeDanioSoloTerrestre(){
        Dragon unidad = new Dragon(new MockEconomia(), new Posicion(1,1));
        Aire aire = new Aire(20, 100);
        for (int i = 0; i < 9; i++)
            unidad.pasarTurno();
        assertThrows(RuntimeException.class, () -> unidad.recibirDanio(20, aire, new Posicion(3, 3)));
    }
}
