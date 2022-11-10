package edu.fiuba.algo3.modelo.tiles;

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

    public Volcan() {
    }

    @Override
    public void buildOn(Construccion construccion, Construccion guardar) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            guardar = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }// Se repite codigo en volcan, moho, energia y mineral (tipo de piso) --> plantear un refactor con el Strategy NO REPETIR CODIGO.

}
