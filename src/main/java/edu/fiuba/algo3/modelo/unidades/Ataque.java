package edu.fiuba.algo3.modelo.unidades;

public interface Ataque {
    void atacar(Objetivo unObjetivo);
    boolean equals(Ataque ataque);
    String getNombre();
}
