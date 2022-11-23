package edu.fiuba.algo3.modelo.unidades;

public interface Ataque {
    int atacar(Objetivo unObjetivo);
    boolean equals(Ataque ataque);
    String getNombre();
}
