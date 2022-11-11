package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.zerg.Extractor;
import edu.fiuba.algo3.modelo.tiles.FloorType;

import java.util.ArrayList;
import java.util.List;

public class Volcan implements FloorType {

    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Extractor.class,
            Asimilador.class
    );

    Construccion estructuraEnPosecion;
    private FloorType[][] tabla;
    ArrayList<ArrayList<Integer>> vecinos;

    public Volcan(ArrayList<ArrayList<Integer>> vecinos, FloorType[][] tabla) {
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

    @Override
    public void buildOn(Construccion construccion) throws RuntimeException {
        if(AVAILABLE_BUILDINGS.contains(construccion.getClass() ) ) {
            estructuraEnPosecion = construccion;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }// Se repite codigo en volcan, moho, energia y mineral (tipo de piso) --> plantear un refactor con el Strategy NO REPETIR CODIGO.

}
