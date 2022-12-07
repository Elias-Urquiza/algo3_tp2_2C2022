package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.tiles.FloorManager;

import java.util.LinkedList;

public interface Estructura {

    void destruir(LinkedList<ConstruccionZerg> construccionesZerg, LinkedList<ConstruccionProtoss> construccionProtoss, FloorManager floorManager);

    void construida();

}
