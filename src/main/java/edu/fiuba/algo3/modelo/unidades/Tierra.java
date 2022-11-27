package edu.fiuba.algo3.modelo.unidades;

public class Tierra implements Ataque {

    private static String nombre = "tierra";
    private int danio;
    public Tierra(int danio){
        this.danio = danio;
    }

    @Override
    public int atacar(Objetivo objetivo) {
        return objetivo.recibirDanio(danio, this);
    }

    @Override
    public Posicion moverse(Boolean esVacio, Posicion posNueva, Posicion posVieja){
        if(!esVacio)
           return posNueva;

        return posVieja;
    }

    @Override
    public boolean equals(Ataque ataque) {
        return nombre.equals(ataque.getNombre());
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}
