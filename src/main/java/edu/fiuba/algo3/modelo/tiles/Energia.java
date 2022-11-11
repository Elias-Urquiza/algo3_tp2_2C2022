package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;

import java.util.List;

public class Energia implements FloorType{

    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Acceso.class,
            Pilon.class,
            NexoMineral.class,
            PuertoEstelar.class
    );


    public Energia(){

    }

    public void accionarPiso

    public void buildOn(Construccion construccion, Construccion guardar) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            guardar = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }
}
