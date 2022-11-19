package edu.fiuba.algo3.modelo.unidades;

public class Aire implements Ataque {

    private static String nombre = "aire";
    private int danio;
    public Aire(int danio){
        this.danio = danio;
    }
    @Override
    public void atacar(Objetivo objetivo) {
        objetivo.recibirDanio(danio, this);
    }

    @Override
    public boolean equals(Ataque ataque){
        return nombre.equals(ataque.getNombre());
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
