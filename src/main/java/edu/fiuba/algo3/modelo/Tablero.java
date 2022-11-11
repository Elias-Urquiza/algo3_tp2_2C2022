package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.tiles.TileVacia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tablero implements Turno{

    private FloorType[][] tabla;

    private final int maxX;
    private final int maxY;

    public Tablero(int dimensionX, int dimensionY){

        maxX = dimensionX;
        maxY = dimensionY;

        tabla = new FloorType[dimensionX][dimensionY];
        llenarTableroConTilesVacias(tabla);
        darVecinosACadaTile();
    }

    public void darVecinosACadaTile(){
        for(int i=0; i < maxX; i++){
            for (int j =0; j < maxY; j++)
                (tabla[i][j]).cargarVecinos(buscarVecinosDe(i, j));
        }
    }

    private void llenarTableroConTilesVacias(FloorType[][] tabla){
        for(int i=0; i < maxX; i++){
            for (int j =0; j < maxY; j++)
                (tabla[i][j]) = new TileVacia();
        }
    }

    public ArrayList<ArrayList<Integer>> buscarVecinosDe(int col, int fil) {
        ArrayList<ArrayList>
        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

            for (int filNum = fil - 1 ; filNum <= (fil + 1) ; filNum +=1  ) {

                if(! ((colNum == col) && (filNum == fil))) {

                    if(entreCeldas (colNum, filNum)) {

                    }
                }
            }
        }
        return neighbors;
    }

    private boolean entreCeldas(int colNum, int filNum) {

        if((colNum < 0) || (filNum <0) ) {
            return false;
        }
        if((colNum >= maxX) || (filNum >= maxY)) {
            return false;
        }
        return true;
    }

    public void pasarTurno(){
        LinkedList<FloorType> vecinos;

        for(int i=0; i < maxX; i++){
            for (int j =0; j < maxY; j++){
                  (tabla[i][j]).accionarPiso(this, i, j);
            }
        }
    }


    public void construirEn(int posX, int posY, Construccion estructura){
        //a lo mejor debe recibir la excepcion que le manda construir en caso de error.
        (tabla [posX][posY]).construir(estructura);
    }

}
