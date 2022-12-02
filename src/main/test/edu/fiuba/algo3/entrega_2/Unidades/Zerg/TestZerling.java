package edu.fiuba.algo3.entrega_2.Unidades.Zerg;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestZerling {

    @Test
    public void zerlingHaceCuatroDeDanioDeTierraCorrectamente(){
        int esperado = 4;
        Zerling zerling1 = new Zerling(new MockEconomia(), new Posicion(1,1));
        Zerling zerling2 = new Zerling(new MockEconomia(), new Posicion(1,2));
        for (int i = 0; i < 2; i++) {
            zerling1.pasarTurno();
            zerling2.pasarTurno();
        }
        int resultado1 = zerling1.atacar(new Guarida(new MockEconomia(), new Posicion( 1,0)));
        int resultado2 = zerling2.atacar(zerling2);

        boolean afirmacion1 = esperado == resultado2;
        boolean afirmacion2 = esperado == resultado1;

        assert(afirmacion1 && afirmacion2);
    }

    @Test
    public void recibeDanioSoloTerrestre(){
        Zerling zerling1 = new Zerling(new MockEconomia(), new Posicion(1,1));
        Aire aire = new Aire(20, 10000000);
        int esperado = 0;
        zerling1.pasarTurno();zerling1.pasarTurno();
        int resultado = zerling1.recibirDanio(20, aire, new Posicion(3, 3));

        assertEquals(esperado, resultado);
    }
}
