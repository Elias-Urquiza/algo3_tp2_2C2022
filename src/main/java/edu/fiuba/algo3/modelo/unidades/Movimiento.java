package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

public interface Movimiento {

    Posicion moverse(Boolean esVacio, Posicion posNueva, Posicion posVieja);
    String getNombre();
}
