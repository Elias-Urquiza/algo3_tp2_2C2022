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

    @Test
    public void construyoUnCriaderoSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Criadero()) );
    }

    @Test
    public void construyoUnaEspiralSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Espiral()) );
    }

    @Test
    public void construyoUnaGuaridaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Guarida()) );
    }

    @Test
    public void construyoUnaReservaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new ReservaDeReproduccion()) );
    }

    @Test
    public void construyoUnPilonSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia();
        Pilon pilon = new Pilon();
        boolean afirmacion = true;

        try{
            energia.buildOn(pilon);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnAccesoSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia();
        boolean afirmacion = true;
        Acceso acceso = new Acceso();

        try{
            energia.buildOn(acceso);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnNexoSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia();
        boolean afirmacion = true;
        NexoMineral nexoMineral = new NexoMineral();

        try{
            energia.buildOn(nexoMineral);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

    @Test
    public void construyoUnPuertoEstelarSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia();
        boolean afirmacion = true;
        PuertoEstelar puertoEstelar = new PuertoEstelar();

        try{
            energia.buildOn(puertoEstelar);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

}
