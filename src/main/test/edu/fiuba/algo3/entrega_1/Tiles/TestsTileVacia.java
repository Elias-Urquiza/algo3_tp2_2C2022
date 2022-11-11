package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.tiles.TileVacia;
import org.junit.Test;

public class TestsTileVacia {

    //Tablero tablero = new Tablero(5,5);

    @Test
    public void aceptaUnCriadero(){
        TileVacia vacia = new TileVacia(null, new FloorType[5][5], 1, 2);
        boolean afirmacion = true;

        try{
            vacia.buildOn(new Criadero());
        }catch (RuntimeException e){
            afirmacion =false;
        }
        assert(afirmacion);
    }
/*
    @Test
    public void aceptaUnPilon(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = true;

        try{
            vacia.buildOn(new Pilon(), guardar);
        }catch (RuntimeException e){
            afirmacion =false;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnAcceso(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Acceso(), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnPuertoEstelar(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new PuertoEstelar(), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnAsimilador(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Asimilador(new Economia()), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnNexoMineral(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new NexoMineral(), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }
    @Test
    public void aceptaUnEsprial(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Espiral(), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnExtractor(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Extractor(new Economia()), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnaGuarida(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Guarida(), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnaReservaDeReproduccion(){
        Construccion guardar = null;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new ReservaDeReproduccion(), guardar);
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

 */
}
