package edu.fiuba.algo3.modelo.jugadores;

import java.util.HashMap;

public class PartidaJugadores {
    private HashMap<Raza,Jugador> jugadores;

    public PartidaJugadores() {
        this.jugadores = new HashMap<>();
    }

    public void setJugador(Raza raza, String nombre, Color color) throws RuntimeException {
        if (jugadores.containsKey(raza)) {
            throw new RuntimeException("Ya hay un jugador con la raza elegida");
        }

        Jugador jugador = new Jugador(nombre, raza, color);
        jugadores.put(raza,jugador);
    }

    public Jugador getJugador(Raza raza) {
        return jugadores.get(raza);
    }
}
