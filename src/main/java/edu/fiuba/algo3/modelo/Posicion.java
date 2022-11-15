package edu.fiuba.algo3.modelo;

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

    @Override
    public String toString() {
        String x = String.valueOf(this.x);
        String y = String.valueOf(this.y);
        return x +", " + y;
    }
}
