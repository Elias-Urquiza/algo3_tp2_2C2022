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
        if (posicion.equals(this.pos)) {
            try {
                construccionZerg.chequearCorrelatividad(list);
            } catch (RuntimeException e){
                throw e;
            }
        }
    }

    public void pasarTurno(LinkedList<Moho> mohos) {
        //logica de expansion de mohos
    }

    public Posicion getPos(){
        return pos;
    }

}
