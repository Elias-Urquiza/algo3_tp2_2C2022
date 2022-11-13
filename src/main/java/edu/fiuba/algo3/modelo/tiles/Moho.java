package edu.fiuba.algo3.modelo.tiles;


import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

import java.util.LinkedList;


public class Moho {
    private Posicion pos;

    public Moho(Posicion pos){
        this.pos = pos;
    }

    public void construir(LinkedList list, ConstruccionZerg construccionZerg, Posicion posicion) {
        if (!pos.equals(posicion)) {
            return;
        }
        list.add(construccionZerg);
    }

    public void pasarTurno(LinkedList<Moho> mohos) {
        //logica de expansion de mohos
    }

}
