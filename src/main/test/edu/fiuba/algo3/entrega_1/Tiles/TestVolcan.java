package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.tiles.Volcan;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestVolcan {

    @Test
    public void construyoUnCriaderoSobreElVolcanYTiraExcepcion() {
        final Volcan volcan = new Volcan();
        Construccion guardar = null;
        Criadero criadero = new Criadero();

        Assertions.assertThrows(RuntimeException.class, () -> volcan.buildOn(criadero, guardar) );
    }

    @Test
    public void construyoUnExtractorSobreElVolcanYNoHayProblema() {
        final Volcan volcan = new Volcan();
        Construccion guardar = null;
        boolean afirmacion = true;

        try{
            volcan.buildOn(new Extractor( new Economia() ), guardar);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnAsimiladorSobreElVolcanYNoHayProblema() {
        final Volcan volcan = new Volcan();
        boolean afirmacion = true;
        Construccion guardar = null;

        try{
            volcan.buildOn(new Asimilador(new Economia()), guardar);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }


}
