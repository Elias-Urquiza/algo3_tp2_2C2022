package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.tiles.Cristales;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestCristales {

    private static final Economia mockEconomia = new MockEconomia();
    @Test
    public void construyoUnCriaderoSobreLosCristalesYTiraExcepcion() {
        final Cristales cristal = new Cristales();
        Criadero criadero = new Criadero(mockEconomia);
        Construccion guardar = null;

        Assertions.assertThrows(RuntimeException.class, () -> cristal.buildOn(criadero));
    }

    @Test
    public void construyoUnNexoMineralSobreLosCristalesYNoHayProblema() {
        final Cristales cristal = new Cristales();
        NexoMineral nexoMineral = new NexoMineral(mockEconomia);
        Construccion guardar = null;
        boolean afirmacion = true;


        try{
            cristal.buildOn(nexoMineral);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }


}
