package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Tablero;

import java.util.ArrayList;

public interface FloorType {
    public void buildOn(Construccion construccion) throws RuntimeException;

    void accionarPiso();

    public Construccion getConstruccion();

    public ArrayList<ArrayList<Integer>> getVecinos();

    public void infectate(FloorType nuevoPiso);
}
