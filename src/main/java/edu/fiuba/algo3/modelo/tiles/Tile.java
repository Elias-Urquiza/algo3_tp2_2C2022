package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;

public class Tile {
    private FloorType floor;
    private Construccion miConstruccion;

    public Tile() {
        this.miConstruccion = null;
        this.floor = new TileVacia();
    }

    public void construir(Construccion estructura) throws RuntimeException{
        try{
            floor.buildOn(estructura, miConstruccion);
        }catch (RuntimeException e){
            throw new RuntimeException("No se puede construir es este espacio");
        }
    }

    public void cambiarPiso(FloorType floor){
        this.floor = floor;
    }

    public Construccion getConstruccion() {
        return miConstruccion;
    }
}
