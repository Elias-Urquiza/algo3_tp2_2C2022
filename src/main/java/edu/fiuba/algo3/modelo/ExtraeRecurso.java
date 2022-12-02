package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tiles.Recurso;

public interface ExtraeRecurso extends Turno {
    void extraer();
    void setRecurso(Recurso recurso);
    Posicion getPosicion();
    void pasarTurno();

}
