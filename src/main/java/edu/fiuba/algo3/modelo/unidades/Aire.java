package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

public class Aire implements Ataque, Movimiento {

    private static String nombre = "Aire";
    private int danio;
    public Aire(int danio){
        this.danio = danio;
    }
    @Override
    public int atacar(Objetivo objetivo) {
        return objetivo.recibirDanio(danio, this);
    }

    @Override
    public boolean equals(Ataque ataque){
        return nombre.equals(ataque.getNombre());
    }

    @Override
    public Posicion moverse(Boolean esVacio, Posicion posNueva, Posicion posVieja){
        return posNueva;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
