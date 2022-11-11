package edu.fiuba.algo3.entrega_1.Buildings.Zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import org.junit.Test;

public class TestNoConstruccionZerg {

    @Test
    public void ConstruirCriaderoSinRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();

        try{
            Criadero criadero = new Criadero(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirCriaderoConPocosRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(30);
        economia.ingresarGasVespeno(30);

        try{
            Criadero criadero = new Criadero(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirEspiralSinRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();


        try{
            Espiral espiral = new Espiral(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirEspiralConPocosRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(30);
        economia.ingresarGasVespeno(30);

        try{
            Espiral espiral = new Espiral(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirExtractorSinRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();


        try{
            Extractor extractor = new Extractor(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirExtractorConPocosRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(30);
        economia.ingresarGasVespeno(30);

        try{
            Extractor extractor = new Extractor(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }


    @Test
    public void ConstruirGuaridaSinRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();


        try{
            Guarida guarida = new Guarida(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirGuaridaConPocosRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(30);
        economia.ingresarGasVespeno(30);

        try{
            Guarida guarida = new Guarida(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }


    @Test
    public void ConstruirReservaSinRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();


        try{
            ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirReservaConPocosRecursosLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(30);
        economia.ingresarGasVespeno(30);

        try{
            Guarida guarida = new Guarida(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirReservaConPocoGasLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(300);
        economia.ingresarGasVespeno(30);

        try{
            Guarida guarida = new Guarida(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirReservaConPocoMineralLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(30);
        economia.ingresarGasVespeno(300);

        try{
            Guarida guarida = new Guarida(economia);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void ConstruirReservaConMineralesNoLanzaError(){
        boolean afirmacion = true;
        Economia economia = new Economia();
        economia.ingresarMineral(300);
        economia.ingresarGasVespeno(300);

        try{
            Guarida guarida = new Guarida(economia);
        }
        catch (RuntimeException e){
            afirmacion = false;
        }
        assert(afirmacion);
    }

}
