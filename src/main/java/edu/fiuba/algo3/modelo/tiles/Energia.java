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

    private final int id;

    public Energia(Posicion posicion, int id){
        this.id = id;
        this.pos = posicion;
    }

    public void construir(LinkedList list, ConstruccionProtoss construccionProtoss, Posicion posicion) {
        if (posicion.equals(this.pos)) {
            try {
                construccionProtoss.chequearCorrelatividad(list);
            }catch (RuntimeException e){
                throw e;
            }
        }
    }

    public Posicion getPos() {
        return pos;
    }

    public int getID() {
        return id;
    }
}
