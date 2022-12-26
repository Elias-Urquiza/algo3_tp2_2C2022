package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.tiles.FloorManager;

import java.util.LinkedList;

public interface Estructura {

    void destruir(LinkedList<ConstruccionZerg> construccionesZerg, LinkedList<ConstruccionProtoss> construccionProtoss, LinkedList<ExtraeRecurso> extraeRecursos, FloorManager floorManager);

    void construida();

    int getVida();

    Object getPosicion();
    LinkedList<String> getInformacion();
}
