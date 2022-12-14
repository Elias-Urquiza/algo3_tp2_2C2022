package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestConstruccionProtoss {
    private static final Economia mockEconomia = new MockEconomia();
    private ConstruccionProtoss constr;
    private static Ataque terrestre = new Tierra(0, 10000);

    @BeforeEach
    public void initEach() {
        constr = new ConstruccionProtoss(1000, 50, 10, 10, 0, mockEconomia, new Posicion(0,0), true );
    }


    @Test
    public void danioUnaConstruccionProtossSinSacarleElEscudoYNoPierdeVida() {
        int vida = constr.getVida();
        Assertions.assertEquals(50, constr.recibirDanio(50, terrestre, new Posicion(3,3)));
        Assertions.assertEquals(vida, constr.getVida());
    }

    @Test
    public void danioUnaConstruccionProtossSacandoleElEscudoYPierdeVida() {
        int vidaAntes = constr.getVida();
        Assertions.assertEquals(100, constr.recibirDanio(100, terrestre, new Posicion(3,3)));
        Assertions.assertEquals(constr.getVida(), vidaAntes-50);
    }

    @Test
    public void curarUnaConstruccionProtossSoloLeRegeneraElEscudo() {
        Assertions.assertEquals(200, constr.recibirDanio(200, terrestre, new Posicion(3,3)));
        Assertions.assertEquals(50, constr.curar());
        Assertions.assertEquals(0, constr.curar());
    }

    @Test
    public void curarUnaConstruccionProtossConEscudoMaximoNoLoCura() {
        Assertions.assertEquals(50, constr.recibirDanio(50, terrestre, new Posicion(3,3) ));
        Assertions.assertEquals(50, constr.curar());
        Assertions.assertEquals(0, constr.curar());
    }

    @Test
    public void creoUnaConstruccionProtossConCostoMineralMayorAlQueTengoYTiraExcepcion() {
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionProtoss(100, 100, 100, 50, 0, economia, new Posicion(0,0),true));
    }

    @Test
    public void creoUnaConstruccionProtossConCostoGasMayorAlQueTengoYTiraExcepcion() {
        final Economia economia = new Economia();
        economia.ingresarGasVespeno(100);
        economia.ingresarMineral(50);
        Assertions.assertThrows(RuntimeException.class, () -> new ConstruccionProtoss(100, 100, 20, 200, 0, economia, new Posicion(0,0), true));
    }


}
