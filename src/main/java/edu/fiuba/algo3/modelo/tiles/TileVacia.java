package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import javafx.geometry.Pos;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
}
