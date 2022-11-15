package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Volcan extends Recurso{

    public Volcan(Posicion posicion) {
        super(posicion);
        this.capacidad = 5000;
    }

}
