package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import org.junit.Test;

public class TestConstrucciones {

    @Test
    public void construirLuegoDeConstruirYsinTenerMineralsLanzaUnaExcepcion(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarGasVespeno(0);
        economia.ingresarMineral(150);
        Extractor extractor = new Extractor(economia);
        Criadero criadero = new Criadero(economia);

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
            Extractor extractorDos = new Extractor(economia);
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
        Extractor extractor = new Extractor(economia);
        Criadero criadero = new Criadero(economia);

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
            Extractor extractorDos = new Extractor(economia);
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
        Extractor extractor = new Extractor(economia);
        Criadero criadero = new Criadero(economia);

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
            Guarida guarida = new Guarida(economia);
        }
        catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);



    }

    

 // TODO :)


}
