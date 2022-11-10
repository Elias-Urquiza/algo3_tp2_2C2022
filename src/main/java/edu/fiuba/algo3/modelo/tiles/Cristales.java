package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;

import java.util.List;

public class Cristales implements FloorType {
    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            NexoMineral.class
    );

    public Cristales() {

    }

    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }
}
