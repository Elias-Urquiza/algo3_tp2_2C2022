package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;


import java.util.List;

public class TileVacia implements FloorType{

    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Criadero.class,
            Pilon.class
    );

    public TileVacia(){

    }

    public void buildOn(Construccion Aconstruir, Construccion guardar) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(Aconstruir.getClass() ) ) {
            guardar = Aconstruir;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }

}
