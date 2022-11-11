package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.protoss.Pilon;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;


import java.util.ArrayList;
import java.util.List;

public class TileVacia implements FloorType{

    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Criadero.class,
            Pilon.class
    );


    private Construccion estructuraEnPosecion;

    private static final int CRIADERO = 0;
    private static final int PILON = 1;
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
        else
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

        if( AVAILABLE_BUILDINGS.indexOf(aConstruir.getClass() ) == CRIADERO ) {
            Moho moho = new Moho(vecinos, tabla, posX, posY);
            infectate(moho);
            moho.setConstruccion(aConstruir);
        }
        else if (AVAILABLE_BUILDINGS.indexOf(aConstruir.getClass() )  == PILON){
            Energia energia = new Energia(vecinos, tabla, posX, posY);
            infectate(energia);
            energia.setConstruccion(aConstruir);
        }else {
            throw new RuntimeException("You cannot build on top of this");
        }
    }
}
