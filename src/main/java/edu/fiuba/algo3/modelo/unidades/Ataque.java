package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

public interface Ataque {
    int atacar(Objetivo unObjetivo, Posicion atacante);
    boolean equals(Ataque ataque);
    boolean inRange(Posicion posicionObjetivo, Posicion posicionAtacante);
    String getNombre();
}
