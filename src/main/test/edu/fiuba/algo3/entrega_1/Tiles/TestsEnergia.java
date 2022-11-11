package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.Moho;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsEnergia {

    private static final Economia mockEconomia = new MockEconomia();

    @Test
    public void construyoUnCriaderoSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Criadero(mockEconomia)) );
    }

    @Test
    public void construyoUnaEspiralSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Espiral(mockEconomia)) );
    }

    @Test
    public void construyoUnaGuaridaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new Guarida(mockEconomia)) );
    }

    @Test
    public void construyoUnaReservaSobreEnergiaYTiraExecpcion() {
        final Energia energia = new Energia();
        Construccion guardar = null;
        Assertions.assertThrows(RuntimeException.class, () -> energia.buildOn(new ReservaDeReproduccion(mockEconomia)) );
    }

    @Test
    public void construyoUnPilonSobreEnergiaYNoHayProblema() {
        final Energia energia = new Energia();
        Pilon pilon = new Pilon(mockEconomia);
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
        Acceso acceso = new Acceso(mockEconomia);

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
        NexoMineral nexoMineral = new NexoMineral(mockEconomia);

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
        PuertoEstelar puertoEstelar = new PuertoEstelar(mockEconomia);

        try{
            energia.buildOn(puertoEstelar);
        }catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

}
