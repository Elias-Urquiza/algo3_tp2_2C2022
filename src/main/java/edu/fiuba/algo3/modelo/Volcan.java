package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.tiles.FloorType;

import java.util.List;

public class Volcan implements FloorType {

    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Extractor.class,
            Asimilador.class
    );
    private Construccion construccionEncima;
    public Volcan() {
        this.construccionEncima = null;
    }
    @Override
    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass())) {
            this.construccionEncima = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }

    public Construccion getConstruccionEncima() {
        return construccionEncima;
    }
}
