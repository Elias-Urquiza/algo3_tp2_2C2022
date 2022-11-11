package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.tiles.Tile;

import java.util.ArrayList;
import java.util.List;

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

    public List<Tile> getNeighbours(int col, int row) {
        List<Tile> neighbors = new ArrayList<>();
        //find all serouding cell by adding +/- 1 to col and row
        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {
            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {
                //if not the center cell
                if(! ((colNum == col) && (rowNum == row))) {
                    //make sure it is within  grid
                    if(withinGrid (colNum, rowNum)) {
                        System.out.println("Neighbor of "+ col+ " "+ row + " - " + colNum +" " + rowNum );
                        neighbors.add(tabla[col][row]);
                    }
                }
            }
        }
        return neighbors;
    }

    private boolean withinGrid(int colNum, int rowNum) {
        if((colNum < 0) || (rowNum <0) ) {
            return false;
        }
        if((colNum >= maxX) || (rowNum >= maxY)) {
            return false;
        }
        return true;
    }
}
