package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.Raza;

import java.util.HashMap;
import java.util.LinkedList;

public interface Objetivo {
    // Devuelve el danio hecho.
    int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion posicionAtacante);

    void morirUnidad(HashMap<Raza, LinkedList> unidades);
}
