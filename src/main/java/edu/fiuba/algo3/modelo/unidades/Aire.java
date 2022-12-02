package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

public class Aire implements Ataque, Movimiento {

    private static String nombre = "Aire";
    private int danio;
    private int rango;
    public Aire(int danio, int rango){
        this.rango = rango;
        this.danio = danio;
    }

    @Override
    public int atacar(Objetivo objetivo, Posicion atacante) {
        return objetivo.recibirDanio(danio, this, atacante);
    }

    @Override
    public boolean equals(Ataque ataque){
        return nombre.equals(ataque.getNombre());
    }

    @Override
    public boolean inRange(Posicion posicionAtacante, Posicion posicionObjetivo) {
        return posicionObjetivo.estaEnRangoDe(posicionAtacante, rango);
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
