package edu.fiuba.algo3.modelo.tiles;




import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.tiles.FloorType;
import java.util.List;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;


public class Moho implements Turno, FloorType {


    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Criadero.class,
            Espiral.class,
            Guarida.class,
            ReservaDeReproduccion.class
    );

    public Moho(){

    }

    @Override
    public void pasarTurno() {

    }

    public void buildOn(Construccion construirEncima) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construirEncima.getClass() ) ) {
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }


}
