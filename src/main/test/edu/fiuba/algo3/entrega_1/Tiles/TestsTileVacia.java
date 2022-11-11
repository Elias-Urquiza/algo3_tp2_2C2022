package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.tiles.TileVacia;
import org.junit.Test;

public class TestsTileVacia {

    private final Economia mockEconomia = new MockEconomia();
    @Test
    public void aceptaUnCriadero(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = true;

        try{
            vacia.buildOn(new Criadero(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =false;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnPilon(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = true;

        try{
            vacia.buildOn(new Pilon(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =false;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnAcceso(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Acceso(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnPuertoEstelar(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new PuertoEstelar(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnAsimilador(){;
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Asimilador(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnNexoMineral(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new NexoMineral(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }
    @Test
    public void aceptaUnEsprial(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Espiral(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnExtractor(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Extractor(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnaGuarida(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new Guarida(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }

    @Test
    public void aceptaUnaReservaDeReproduccion(){
        TileVacia vacia = new TileVacia();
        boolean afirmacion = false;

        try{
            vacia.buildOn(new ReservaDeReproduccion(mockEconomia));
        }catch (RuntimeException e){
            afirmacion =true;
        }
        assert(afirmacion);
    }
}
