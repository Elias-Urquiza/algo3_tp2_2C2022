package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.tiles.Volcan;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestVolcan {

    private final Economia mockEconomia = new MockEconomia();
    @Test
    public void construyoUnCriaderoSobreElVolcanYTiraExcepcion() {
        final Volcan volcan = new Volcan();
        Criadero criadero = new Criadero(mockEconomia);

        Assertions.assertThrows(RuntimeException.class, () -> volcan.buildOn(criadero) );
    }

    @Test
    public void construyoUnExtractorSobreElVolcanYNoHayProblema() {
        final Volcan volcan = new Volcan();
        boolean afirmacion = true;

        try{
            volcan.buildOn(new Extractor( new Economia() ));
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnAsimiladorSobreElVolcanYNoHayProblema() {
        final Volcan volcan = new Volcan();
        boolean afirmacion = true;

        try{
            volcan.buildOn(new Asimilador(new Economia()));
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }


}
