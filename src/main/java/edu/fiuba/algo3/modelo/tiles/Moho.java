package edu.fiuba.algo3.modelo.tiles;




import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.tiles.FloorType;

import java.util.ArrayList;
import java.util.List;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;


public class Moho implements FloorType{


    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Criadero.class,
            Espiral.class,
            Guarida.class,
            ReservaDeReproduccion.class
    );

    private int turnosExpandirMoho;

    private Construccion estructuraEnPosecion;

    public Moho(){
        estructuraEnPosecion = null;
        turnosExpandirMoho = 0;
    }

    public void accionarPiso(Tablero tablero, int posX, int posY){
        if(turnosExpandirMoho !=0 && turnosExpandirMoho%2 == 0){
            = tablero.buscarVecinosDe(posX, posY);
        }
        turnosExpandirMoho++;
    }

    public void buildOn(Construccion Aconstruir) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(Aconstruir.getClass() ) ) {
            estructuraEnPosecion = Aconstruir;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }
}
