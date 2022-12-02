package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

public interface Objetivo {
    // Devuelve el danio hecho.
    int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion posicionAtacante);
}
