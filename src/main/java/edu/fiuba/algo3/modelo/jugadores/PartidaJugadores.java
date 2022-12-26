package edu.fiuba.algo3.modelo.jugadores;

import java.util.HashMap;
import java.util.PrimitiveIterator;


public class PartidaJugadores {
    private HashMap<Raza,Jugador> jugadores;

    private Jugador jugadorActivo;
    private int MAX_NOMBRE = 20;

    public PartidaJugadores() {
        this.jugadores = new HashMap<>();
        this.jugadorActivo = getJugador(Raza.PROTOSS);
    }


    public boolean chequearColor(Color color){
        if( color == Color.AZUL || color == Color.ROSA  ||color == Color.ROJO    ||color == Color.VERDE   ||color == Color.VIOLETA ||color == Color.MAGENTA ||color == Color.AMARILLO ||
            color == Color.NEGRO||color == Color.NARANJA||color == Color.BLANCO  ||color == Color.CELESTE)  return true;

        else return false;
    }

    public boolean chequearColorOcupado(Color color, Raza raza){
        Jugador jugador = null;
        boolean afirmacion = false;

        if(!jugadores.isEmpty() && raza == Raza.ZERG) {
            jugador = jugadores.get(Raza.PROTOSS); // Es mejor si delegamos en Jugador, con un equals

        } else if (!jugadores.isEmpty()) {
            jugador = jugadores.get(Raza.ZERG);
        }

        if(jugador != null)
            afirmacion =  color == jugador.getColor();

        return afirmacion;
    }

    public void setJugador(Raza raza, String nombre, Color color) throws RuntimeException {
        if ( jugadores.containsKey(raza)) {
             throw new RuntimeException("Ya hay un jugador con la raza elegida");
        }

        if ( nombre.isEmpty() || nombre.length() > MAX_NOMBRE || chequearNombreOcupado(nombre, raza)) //por poner puse una longitud max
             throw new RuntimeException("nombre no valido");

        if( color == null || chequearColorOcupado(color, raza) )
            throw new RuntimeException("Ese color no esta disponible o no existe");

        Jugador jugador = new Jugador(nombre, raza, color);
        jugadores.put(raza,jugador);
        if(jugadorActivo == null) {
            jugadorActivo = jugador;
        }
    }

    private boolean chequearNombreOcupado(String nombre, Raza raza) {
        boolean afirmacion = false;

        if(!jugadores.isEmpty()  && raza == Raza.PROTOSS) {
            afirmacion = ( jugadores.get(Raza.ZERG) ).getNombre() == nombre;
        } else if (!jugadores.isEmpty()) {
            afirmacion = ( jugadores.get(Raza.PROTOSS) ).getNombre() == nombre;
        }
        return afirmacion;
    }

    public Jugador getJugador(Raza raza) {
        return jugadores.get(raza);
    }
    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }

    public void cambiarTurno() {
        jugadorActivo = getJugador(Raza.PROTOSS).equals(jugadorActivo)
                ? getJugador(Raza.ZERG)
                : getJugador(Raza.PROTOSS);
    }
}
