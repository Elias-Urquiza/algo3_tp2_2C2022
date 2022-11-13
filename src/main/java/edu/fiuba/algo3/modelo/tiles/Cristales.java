package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cristales extends Recurso{

    public Cristales(int posX, int posY) {
        super(posX, posY);
        this.capacidad = 2000;
    }
}
