package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Energia {
    Posicion pos;
    public Energia(Posicion posicion){
        this.pos = posicion;
    }

    public void construir(LinkedList list, ConstruccionProtoss construccionProtoss, int x, int y) {
        if (new Posicion(x, y).equals(pos)) {
            list.add(construccionProtoss);
        }
        return;
    }

    public Posicion getPos() {
        return pos;
    }
}
