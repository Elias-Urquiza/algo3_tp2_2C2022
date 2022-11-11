package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.Moho;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsEnergia {

    /*
    @Test
    public void construyoUnCriaderoSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Criadero()) );
    }

    @Test
    public void construyoUnaEspiralSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Espiral()) );
    }

    @Test
    public void construyoUnaGuaridaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Guarida()) );
    }

    @Test
    public void construyoUnaReservaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia(null, null, 1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new ReservaDeReproduccion()) );
    }

    @Test
    public void construyoUnPilonSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            energia.buildOn(new Pilon());
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnAccesoSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            energia.buildOn(new Acceso());
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnNexoSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            energia.buildOn(new NexoMineral() );
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnPuertoEstelarSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia(null, null, 1, 2);
        boolean afirmacion = true;

        try{
            energia.buildOn(new PuertoEstelar());
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }
     */
}
