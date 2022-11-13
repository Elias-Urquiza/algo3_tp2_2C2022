package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
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
    private int posX;
    private int posY;
    public Energia(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void construir(LinkedList list, ConstruccionProtoss construccionProtoss, int x, int y) {
        if (x != posX || y != posY) {
            return;
        }
        list.add(construccionProtoss);
    }
}
