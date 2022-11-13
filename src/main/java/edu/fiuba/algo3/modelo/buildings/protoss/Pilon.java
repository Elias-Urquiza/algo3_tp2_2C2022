package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Energia;
import javafx.geometry.Pos;

import java.util.LinkedList;

public class Pilon extends ConstruccionProtoss implements Turno, Construccion {
    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 5;
    private LinkedList<Energia> energias;

    public Pilon(Economia economia, Posicion pos) {
        super(350, 350, 100, 0, 5, economia, pos);
        turnosActivo = 0;
        this.energias = null;
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

    public void energizar(Posicion pos, int maxX, int maxY, LinkedList<Energia> listaDeEnergias) {
        //hacer que energice segun acordado
        this.energias = listaDeEnergias;
        int posicion_x = pos.getX() -3;
        if (posicion_x<0)
            posicion_x = 0;   // aca hay que ver como hacer pra el cso del borde de coordenadas


        int posicion_y = pos.getY() -3;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = pos.getX() + 4;
        if(topeX > maxX)
            topeX = maxX;

        int topeY = pos.getY() + 4;
        if(topeY > maxY)
            topeY = maxY;

        for(int i = posicion_x; i <(topeX) ; i++){
            for(int j = posicion_y ; j<(topeY); j++){
                Energia energia = new Energia(new Posicion(i, j));
                energias.add(energia);
            }
        }
    }

    @Override
    public void destruir(Posicion pos, LinkedList<ConstruccionProtoss> construccionProtoss) {
        if (pos.equals(this.pos)) {
            construccionProtoss.remove(this);
            desenergizar(pos.getX(), pos.getY(), energias);
        }
    }

    private void desenergizar(int maxX, int maxY, LinkedList<Energia> energias) {
        int posicion_x = pos.getX() -3;
        if (posicion_x<0)
            posicion_x = 0;   // aca hay que ver como hacer pra el cso del borde de coordenadas
        int posicion_y = pos.getY() -3;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = pos.getX() + 4;
        if(topeX > maxX)
            topeX = maxX;

        int topeY = pos.getY() + 4;
        if(topeY > maxY)
            topeY = maxY;

        // Refactor??
        for (Energia e : energias) {
            for (int i = posicion_x; i < (topeX); i++) {
                for (int j = posicion_y; j < (topeY); j++) {
                    final int pos_i = i;
                    final int pos_j = j;
                    energias.removeIf(energia -> energia.getPos().equals(pos));
                }
            }
        }
    }
}
