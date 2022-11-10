package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestConstruccionProtoss {
    @Test
    public void danioUnaConstruccionProtossSinSacarleElEscudoYNoPierdeVida() {
        final ConstruccionProtoss construccion = new ConstruccionProtoss(1000, 200);
        Assertions.assertEquals(0, construccion.daniar(100));
    }

    @Test
    public void danioUnaConstruccionProtossSacandoleElEscudoYPierdeVida() {
        final ConstruccionProtoss construccion = new ConstruccionProtoss(1000, 50);
        Assertions.assertEquals(50, construccion.daniar(100));
    }

    @Test
    public void curarUnaConstruccionProtossSoloLeRegeneraElEscudo() {
        final ConstruccionProtoss construccion = new ConstruccionProtoss(1000, 50);
        Assertions.assertEquals(150, construccion.daniar(200));
        Assertions.assertEquals(50, construccion.curar());
        Assertions.assertEquals(0, construccion.curar());
    }

    @Test
    public void curarUnaConstruccionProtossConEscudoMaximoNoLoCura() {
        final ConstruccionProtoss construccion = new ConstruccionProtoss(1000, 50);
        Assertions.assertEquals(0, construccion.daniar(50));
        Assertions.assertEquals(50, construccion.curar());
        Assertions.assertEquals(0, construccion.curar());
    }


}
