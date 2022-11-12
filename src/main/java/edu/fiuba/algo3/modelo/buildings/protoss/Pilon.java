package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Energia;

import java.util.LinkedList;

public class Pilon extends ConstruccionProtoss implements Turno, Construccion {
    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 5;

    public Pilon(Economia economia, int posX, int posY) {
        super(350, 350, 100, 0, 5, economia, posX, posY);
        turnosActivo = 0;
    }


    @Override
    public void pasarTurno(){
        curar();
        turnosActivo++;
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales
    }

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");
    }

    public void energizar(int x, int y, int maxX, int maxY, LinkedList<Energia> listaDeEnergias) {
        //hacer que energice segun acordado

        int posicion_x = posX -3;
        if (posicion_x<0)
            posicion_x = 0;   // aca hay que ver como hacer pra el cso del borde de coordenadas


        int posicion_y = posY -3;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = posX + 4;
        if(topeX > maxX)
            topeX = maxX;

        int topeY = posY + 4;
        if(topeY > maxY)
            topeY = maxY;

        for(int i = posicion_x; i <(topeX) ; i++){
            for(int j = posicion_y ; j<(topeY); j++){
                Energia energia = new Energia(i, j);
                listaDeEnergias.add(energia);
            }
        }
    }
}
