package edu.fiuba.algo3.modelo.unidades;

public class Aire implements Ataque {

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
    public String getNombre() {
        return nombre;
    }
}
