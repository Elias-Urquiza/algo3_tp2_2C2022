package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

import java.util.LinkedList;

public interface Ataque {
    int atacar(Objetivo unObjetivo, Posicion atacante);
    boolean es(Ataque ataque);
    boolean es(Movimiento mov);
    boolean inRange(Posicion posicionObjetivo, Posicion posicionAtacante);
    String getNombre();
    LinkedList<String> getInformacion();
}
