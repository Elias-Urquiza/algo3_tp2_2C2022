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

    private int cantidadGas;

    private static final int GAS_POR_VOLCAN = 5000;

    public Volcan() {
        cantidadGas = GAS_POR_VOLCAN;
    }

    @Override
    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }// Se repite codigo en volcan, moho, energia y mineral (tipo de piso) --> plantear un refactor con el Strategy NO REPETIR CODIGO.

}
