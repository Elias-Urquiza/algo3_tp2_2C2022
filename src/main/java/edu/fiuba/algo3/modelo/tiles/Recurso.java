package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.LinkedList;

public abstract class Recurso {
    protected Posicion pos;
    protected int capacidad;

    public Recurso(Posicion pos) {
        this.pos = pos;
    }

    public Recurso construir(LinkedList list, ExtraeRecurso unidadDeExtraccion, Posicion posicion) {
        if (!pos.equals(posicion)) {
            return null;
        }
        list.add(unidadDeExtraccion);
        return this;
    }

    public int extraer(int cantidadAExtraer) {
        if (capacidad == 0) {
            throw new RuntimeException("No hay mas mineral");
        }
        final int capacidadPreExtraccion = capacidad;
        final int cantidad = capacidad - cantidadAExtraer;
        if (cantidad <= 0) {
            capacidad = 0;
        } else {
            capacidad -= cantidadAExtraer;
        }
        return capacidadPreExtraccion - capacidad;
    }

    public Posicion getPos() {
        return pos;
    }
}
