package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cristales {

    private int posX;
    private int posY;

    public Cristales(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void construir(LinkedList list, NexoMineral nexoMineral, int x, int y) {
        if (x != posX || y != posY) {
            return;
        }
        list.add(nexoMineral);
    }
    //TODO: ZANGANO?
}
