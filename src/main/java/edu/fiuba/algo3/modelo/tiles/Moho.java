package edu.fiuba.algo3.modelo.tiles;


import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

import java.util.LinkedList;

public class Moho {
    private int posX;
    private int posY;

    public Moho(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void construir(LinkedList list, ConstruccionZerg construccionZerg, int x, int y) {
        if (x != posX || y != posY) {
            return;
        }
        list.add(construccionZerg);
    }
}
