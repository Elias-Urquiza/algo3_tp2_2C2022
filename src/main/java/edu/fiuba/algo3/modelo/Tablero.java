package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.tiles.Moho;
import edu.fiuba.algo3.modelo.tiles.Tile;

public class Tablero {

    private Tile[][] tabla;

    private final int maxX;
    private final int maxY;

    public Tablero(int dimensionX, int dimensionY){

        maxX = dimensionX;
        maxY = dimensionY;

        tabla = new Tile[dimensionX][dimensionY];
        llenarTableroConTilesVacias(tabla);
    }

    private void llenarTableroConTilesVacias(Tile[][] tabla){
        for(int i=0; i < maxX; i++){
            for (int j =0; j < maxY; j++)
                (tabla[i][j]) = new Tile();
        }
    }

    public void construirEn(int posX, int posY, Construccion estructura){
        //a lo mejor debe recibir la excepcion que le manda construir en caso de error.
        (tabla [posX][posY]).construir(estructura);
    }

    public void expandirMoho(){
        for(int i=0; i < maxX; i++){
            for (int j =0; j < maxY; j++)
                if((tabla[i][j]).getConstruccion() == Moho ){
                    for(int k=i; 5 >= (k-i); k++){
                        tabla[k][j] = new Moho();
                    }
                    for(int k=i; (-5) <= (k-i); k--){
                        tabla[k][j] = new Moho();
                    }
                    for(int k=j; 5 >= (k-i); k++){
                        tabla[i][k] = new Moho();
                    }
                    for(int k=j; (-5) <= (k-i); k--){
                        tabla[i][k] = new Moho();   //Plantie una idea aasi, quizas esta mal
                    }
                }
        }
    }

}
