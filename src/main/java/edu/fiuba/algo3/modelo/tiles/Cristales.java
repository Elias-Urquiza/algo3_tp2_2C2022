package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cristales extends Recurso{

    public Cristales(Posicion posicion) {
        super(posicion);
        this.capacidad = 2000;
    }

    public Posicion getPos(){
        return pos;
    }

    // no se si esta bien implementarlo aca o en recurso --> Repite codigo?
}
