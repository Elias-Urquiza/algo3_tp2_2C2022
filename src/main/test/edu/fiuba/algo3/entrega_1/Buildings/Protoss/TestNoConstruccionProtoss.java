package edu.fiuba.algo3.entrega_1.Buildings.Protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import org.junit.Test;

public class TestNoConstruccionProtoss {

    @Test
    public void construirUnAccesoSinMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        try{
            Acceso acceso = new Acceso(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void construirUnAccesoConPocosMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(50);
        economia.ingresarGasVespeno(50);
        try{
            Acceso acceso = new Acceso(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }



    @Test
    public void construirUnAsimiladorSinMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        try{
            Asimilador asimilador = new Asimilador(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void construirUnAsimiladorConPocosMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(50);
        economia.ingresarGasVespeno(50);
        try{
            Asimilador asimilador = new Asimilador(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }


    @Test
    public void construirUnNexoSinMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        try{
            NexoMineral nexoMineral = new NexoMineral(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void construirUnNexoConPocosMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(20);
        economia.ingresarGasVespeno(50);
        try{
            NexoMineral nexoMineral = new NexoMineral(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }


    @Test
    public void construirUnPilonSinMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        try{
            Pilon pilon = new Pilon(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void construirUnPilonConPocosMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(20);
        economia.ingresarGasVespeno(50);
        try{
            Pilon pilon = new Pilon(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }




    @Test
    public void construirUnPuertoSinMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void construirUnPuertoConAlgoMineralesLanzaError(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(50);
        economia.ingresarGasVespeno(50);
        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void construirUnPuertoConGasFaltante(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(500);
        economia.ingresarGasVespeno(50);
        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }

    @Test
    public void construirUnPuertoConMineralFaltante(){
        boolean afirmacion = false;
        Economia economia = new Economia();
        economia.ingresarMineral(50);
        economia.ingresarGasVespeno(500);
        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(economia, 0, 0);
        }
        catch (RuntimeException e){
            afirmacion = true;
        }
        assert(afirmacion);
    }
}
