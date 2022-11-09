package edu.fiuba.algo3.modelo;




import edu.fiuba.algo3.modelo.tiles.FloorType;
import java.util.List;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;


public class Moho implements Turno, FloorType {

    private Construccion construccionEncima;
    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Criadero.class,
            Espiral.class,
            Guarida.class,
            ReservaDeReproduccion.class
    );

    public Moho(){
        construccionEncima = null;
    }

    @Override
    public void pasarTurno() {

    }

    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            this.construccionEncima = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }

}
