package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Posicion;

import java.util.LinkedList;

public class TileVacia {
    private Posicion posicion;

    public TileVacia(Posicion posicion){
        this.posicion = posicion;
    }

    public void construir(LinkedList list, Object building, Posicion pos) {
        if (pos.getX() != posicion.getX() || pos.getY() != posicion.getY()) {
            return;
        }
        list.add(building);
    }

    public Posicion getPos() {
        return posicion;
    }
}
