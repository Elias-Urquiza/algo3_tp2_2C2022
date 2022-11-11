package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;


import java.util.ArrayList;
import java.util.List;

public class TileVacia implements FloorType{

    private static final List<Class> CRIADERO = List.of(
            Criadero.class
    );

    private static final List<Class> PILON = List.of(
            Criadero.class
    );

    private Construccion estructuraEnPosecion;


    private FloorType[][] tabla;
    ArrayList<ArrayList<Integer>> vecinos;
    private int posX;
    private int posY;

    public TileVacia(ArrayList<ArrayList<Integer>> vecinos, FloorType[][] tabla, int posX, int posY){
        estructuraEnPosecion = null;
        this.vecinos = vecinos;
        this.tabla = tabla;
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

    public void accionarPiso(){
        throw new RuntimeException("Este piso no se puede accionar");
    }

    public void buildOn(Construccion aConstruir) throws RuntimeException {

        if( CRIADERO.contains(aConstruir.getClass()) ) {
            Moho moho = new Moho(vecinos, tabla, posX, posY);
            infectate(moho);
            moho.setConstruccion(aConstruir);
        }
        if (PILON.contains(aConstruir.getClass())    ){
            Energia energia = new Energia(vecinos, tabla, posX, posY);
            infectate(energia);
            energia.setConstruccion(aConstruir);
        }

        throw new RuntimeException("You cannot build on top of this");
    }

}
