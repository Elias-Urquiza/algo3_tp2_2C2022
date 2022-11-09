package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;

import java.util.List;

public class Cristales implements FloorType {
    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            NexoMineral.class
    );

    private Construccion construccionEncima;

    public Cristales() {
        this.construccionEncima = null;
    }

    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            this.construccionEncima = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }

    public Construccion getConstruccionEncima() {
        return construccionEncima;
    }

}
