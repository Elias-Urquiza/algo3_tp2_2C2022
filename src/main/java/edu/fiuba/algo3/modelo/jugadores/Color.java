package edu.fiuba.algo3.modelo.jugadores;

public enum Color {

    ROJO("#FF0000"),
    VERDE("#008000"),
    AZUL("#0000FF"),
    NARANJA("FF8000"),
    AMARILLO("#ffff00"),
    ROSA("ff0080"),
    VIOLETA("4c2882"),
    MAGENTA("#ff00ff"),
    CELESTE("#87CEEB"),
    BLANCO("#FFFFFF"),
    NEGRO( "#000000");
    private final String hex;

    Color(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}
