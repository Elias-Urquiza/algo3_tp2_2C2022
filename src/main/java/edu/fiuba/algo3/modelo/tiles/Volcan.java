package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Volcan {

    int posX;
    int posY;
    public Volcan(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean estasEn(int x, int y) {
        return x == posX && y == posY;
    }

    public void construir(LinkedList list, Extractor extr, int x, int y) {
        if (x != posX || y != posY) {
            return;
        }
        list.add(extr);
    }

    public void construir(LinkedList list, Asimilador asimilador, int x, int y) {

    }
}
