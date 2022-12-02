package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.jugadores.Color;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestJugadores {

    @Test
    public void unJugadorConNombreVacioLanzaExcepcion() {
        PartidaJugadores partidaJugadores = new PartidaJugadores();
        RuntimeException e = assertThrows( RuntimeException.class, () -> partidaJugadores.setJugador(Raza.ZERG, "", Color.BLANCO));
        assertEquals("nombre no valido", e.getMessage());
    }

    @Test
    public void unJugadorConNombreDeMasDe20CaracteresLanzaExcepcion() {
        PartidaJugadores partidaJugadores = new PartidaJugadores();
        RuntimeException e = assertThrows( RuntimeException.class, () -> partidaJugadores.setJugador(Raza.ZERG, "ughasidhaisudhiahandsnmxcnmzxncdijoushdiugfygdfgafiyugewdfjdfhhsydidndsifjdfjnfzfdgnfkngklfngorruierieutotiurofjkdskjlfdsjkfdlsvcnmxvnmcx,mnvcx", Color.BLANCO));
        assertEquals("nombre no valido", e.getMessage() );
    }

    @Test
    public void unJugadorConColorNoValidoLanzaExcepcion() {
        PartidaJugadores partidaJugadores = new PartidaJugadores();
        RuntimeException e = assertThrows( RuntimeException.class, () -> partidaJugadores.setJugador(Raza.ZERG, "unNombrePiola", null));
        assertEquals("Ese color no esta disponible o no existe", e.getMessage());
    }

    @Test
    public void unJugadorConRazaOcupadaLanzaExcepcion() {
        PartidaJugadores partidaJugadores = new PartidaJugadores();
        partidaJugadores.setJugador(Raza.ZERG, "unNombrePiola", Color.AMARILLO);
        RuntimeException e = assertThrows( RuntimeException.class, () -> partidaJugadores.setJugador(Raza.ZERG, "unNombrePiola2", Color.ROJO));
        assertEquals("Ya hay un jugador con la raza elegida", e.getMessage());
    }
    @Test
    public void unJugadorConNombreOcupadoLanzaExcepcion() {
        PartidaJugadores partidaJugadores = new PartidaJugadores();
        partidaJugadores.setJugador(Raza.ZERG, "unNombrePiola", Color.AMARILLO);
        RuntimeException e = assertThrows( RuntimeException.class, () -> partidaJugadores.setJugador(Raza.PROTOSS, "unNombrePiola", Color.ROJO));
        assertEquals("nombre no valido", e.getMessage());
    }
}
