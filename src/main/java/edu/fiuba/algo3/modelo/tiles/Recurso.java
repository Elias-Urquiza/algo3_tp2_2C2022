package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.ExtraeRecurso;

import java.util.LinkedList;

public abstract class Recurso {
    protected int posX;
    protected int posY;
    protected int capacidad;
    public Recurso(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public Recurso construir(LinkedList list, ExtraeRecurso unidadDeExtraccion, int x, int y) {
        if (x != posX || y != posY) {
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
}
