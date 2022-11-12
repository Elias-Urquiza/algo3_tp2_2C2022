package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.tiles.Volcan;
import org.junit.jupiter.api.Test;

public class TestConstrucciones {

    @Test
    public void construirLuegoDeConstruirYsinTenerMineralsLanzaUnaExcepcion(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(150);
        Extractor extractor = new Extractor(economia, 0, 0);
        Criadero criadero = new Criadero(economia, 0, 0);

        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();



        try{
            Extractor extractorDos = new Extractor(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);



    }
    @Test
    public void construirLuegoDeConstruirSinZanganosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(150);
        Extractor extractor = new Extractor(economia, 0, 0);
        Criadero criadero = new Criadero(economia, 0, 0);

        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();

        for (int i = 0; i<20 ;i++ ){
            criadero.pasarTurno();
        }

        try{
            Extractor extractorDos = new Extractor(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);

    }

    @Test
    public void construirRecolectandoFuncionaBien(){
        boolean afirmacion = true;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(350);
        Extractor extractor = new Extractor(economia, 0, 0);
        extractor.setRecurso(new Volcan(0 ,0));
        Criadero criadero = new Criadero(economia, 0, 0);

        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        extractor.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();
        criadero.pasarTurno();



        extractor.agregarZangano(criadero);
        extractor.agregarZangano(criadero);

        for (int i = 0; i<5 ;i++ ){
            extractor.pasarTurno();
        }

        try{
            Guarida guarida = new Guarida(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);



    }

    @Test
    public void construirSinMineralesProtossLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(250);
        Asimilador asimilador = new Asimilador(economia, 0, 0);


        for (int i = 0; i<1 ;i++ ){
            asimilador.pasarTurno();
        }

        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);



    }

    @Test
    public void construirRecolectandoMineralesProtossNoLanzaError(){
        boolean afirmacion = true;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(250);
        Asimilador asimilador = new Asimilador(economia, 0, 0);
        asimilador.setRecurso(new Volcan(0 ,0));

        for (int i = 0; i<14 ;i++ ){
            asimilador.pasarTurno();
        }

        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);



    }




    // TODO :)


}
