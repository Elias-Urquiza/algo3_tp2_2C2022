package edu.fiuba.algo3.modelo.jugadores;

public class Jugador {
    private final String nombre;
    private final Raza raza;
    private final Color color;

    public Jugador(String nombre, Raza raza, Color color) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
    }

    // TODO Comportamiento? Tal vez sirva como clase a la que la UI delega comportamiento como
    //  "display color", "display nombre", etc.

}
