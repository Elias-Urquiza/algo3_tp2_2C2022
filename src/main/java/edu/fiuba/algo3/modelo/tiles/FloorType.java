package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Tablero;

import java.util.ArrayList;

public interface FloorType {
    public void buildOn(Construccion construccion) throws RuntimeException;
    public void cargarVecinos(ArrayList<FloorType> vecinos);
    void accionarPiso(Tablero tablero, int i, int j);

    public Construccion getConstruccion
}
