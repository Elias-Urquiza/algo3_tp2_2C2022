package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;

import java.util.ArrayList;
import java.util.List;

public class Energia implements FloorType{

    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Acceso.class,
            Pilon.class,
            NexoMineral.class,
            PuertoEstelar.class
    );

    Construccion estructuraEnPosecion;
    private FloorType[][] tabla;
    ArrayList<ArrayList<Integer>> vecinos;
    private int posX;
    private int posY;
    public Energia(ArrayList<ArrayList<Integer>> vecinos, FloorType[][] tabla, int posX, int posY){
        this.tabla = tabla;
        this.vecinos = vecinos;
        estructuraEnPosecion = null;
        this.posX = posX;
        this.posY = posY;
    }

    public void infectate(FloorType nuevoPiso){
        if(estructuraEnPosecion == null)
            tabla[posX][posY] = nuevoPiso;

        throw new RuntimeException("No se puede quitar este piso");
    }

    public ArrayList<ArrayList<Integer>> getVecinos(){
        return vecinos;
    }

    public Construccion getConstruccion(){
        return estructuraEnPosecion;
    }

    public void setConstruccion(Construccion nuevaEstructura){
        estructuraEnPosecion = nuevaEstructura;
    }

    public void accionarPiso(){

    }

    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            estructuraEnPosecion = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }
}
