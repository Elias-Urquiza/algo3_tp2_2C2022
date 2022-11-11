package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestConstruccionProtoss {
    private static final Economia mockEconomia = new MockEconomia();
    private ConstruccionProtoss constr;

    @BeforeEach
    public void initEach() {
        constr = new ConstruccionProtoss(1000, 10, 10, 10, 0, mockEconomia);
    }


    @Test
    public void danioUnaConstruccionProtossSinSacarleElEscudoYNoPierdeVida() {
        Assertions.assertEquals(0, constr.daniar(100));
    }

    @Test
    public void danioUnaConstruccionProtossSacandoleElEscudoYPierdeVida() {
        Assertions.assertEquals(50, constr.daniar(100));
    }

    @Test
    public void curarUnaConstruccionProtossSoloLeRegeneraElEscudo() {
        Assertions.assertEquals(150, constr.daniar(200));
        Assertions.assertEquals(50, constr.curar());
        Assertions.assertEquals(0, constr.curar());
    }

    @Test
    public void curarUnaConstruccionProtossConEscudoMaximoNoLoCura() {
        Assertions.assertEquals(0, constr.daniar(50));
        Assertions.assertEquals(50, constr.curar());
        Assertions.assertEquals(0, constr.curar());
    }

    @Test
    public void creoUnaConstruccionProtossConCostoMineralMayorAlQueTengoYTiraExcepcion() {
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionProtoss(100, 100, 100, 50, 0, economia));
    }

    @Test
    public void creoUnaConstruccionProtossConCostoGasMayorAlQueTengoYTiraExcepcion() {
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionProtoss(100, 100, 20, 200, 0, economia));
    }


}
