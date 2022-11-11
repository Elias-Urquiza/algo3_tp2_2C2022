package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;

import java.util.ArrayList;
import java.util.List;

public class Cristales implements FloorType {
    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            NexoMineral.class
    );

    Construccion estructuraEnPosecion;
    private FloorType[][] tabla;
    ArrayList<ArrayList<Integer>> vecinos;

    public Cristales(ArrayList<ArrayList<Integer>> vecinos, FloorType[][] tabla) {
        this.tabla = tabla;
        this.vecinos =vecinos;
    }

    public void infectate(FloorType nuevoPiso){
        throw new RuntimeException("No se puede quitar este piso");
    }

    public void accionarPiso(){
        throw new RuntimeException("Este piso no se puede accionar");
    }

    public ArrayList<ArrayList<Integer>> getVecinos(){
        return vecinos;
    }
    public Construccion getConstruccion(){
        return estructuraEnPosecion;
    }

    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            estructuraEnPosecion = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }
}
