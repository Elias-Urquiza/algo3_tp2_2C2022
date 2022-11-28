package edu.fiuba.algo3.modelo;

import javafx.geometry.Pos;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Posicion other) {
        return other.getX() == x && other.getY() == y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Posicion incrementar(int incrementoX, int incrementoY, int maxX, int maxY){
        if((this.x)+incrementoX < 0 || (this.y)+incrementoY < 0  || (this.y)+incrementoY >= maxY || (this.x)+incrementoX >= maxX){
            throw new RuntimeException("Esa posicion invalida");
        }
        Posicion posicionNueva = new Posicion( (this.x)+incrementoX, (this.y)+incrementoY ) ;
        return posicionNueva;
    }

    @Override
    public String toString() {
        String x = String.valueOf(this.x);
        String y = String.valueOf(this.y);
        return x +", " + y;
    }
}
