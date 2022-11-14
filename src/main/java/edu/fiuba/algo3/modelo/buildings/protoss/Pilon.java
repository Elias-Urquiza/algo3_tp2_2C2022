package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Energia;

import java.util.LinkedList;

public class Pilon extends ConstruccionProtoss implements Turno, Construccion {
    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 5;
    private LinkedList<Energia> energias;

    private int id;

    public Pilon(Economia economia, Posicion pos) {
        super(350, 350, 100, 0, 5, economia, pos, true);
        turnosActivo = 0;
        this.id = 0;
        this.energias = null;
    }


    @Override
    public void pasarTurno() {
        curar();
        turnosActivo++;
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales
    }

    @Override
    public void usar() {
        if (turnosActivo < TIEMPO_CONSTRUCCION && energizado)
            throw new RuntimeException("Edificio en construccion");
    }

    public void energizar(Posicion pos, int maxX, int maxY, LinkedList<Energia> listaDeEnergias) {
        //hacer que energice segun acordado
        this.energias = listaDeEnergias;
        int posicion_x = pos.getX() - 3;
        if (posicion_x < 0)
            posicion_x = 0;   // aca hay que ver como hacer pra el cso del borde de coordenadas


        int posicion_y = pos.getY() - 3;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = pos.getX() + 4;
        if (topeX > maxX)
            topeX = maxX;

        int topeY = pos.getY() + 4;
        if (topeY > maxY)
            topeY = maxY;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                Energia energia = new Energia(new Posicion(i, j), id);
                energias.add(energia);
            }
        }
    }


    @Override
    public Boolean destruir(Posicion pos, int maxX, int maxY, LinkedList<ConstruccionProtoss> construccionProtoss) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            desenergizar(maxX, maxY, energias);
            afirmacion = true;
        }
        return afirmacion;
    }

    private void desenergizar(int maxX, int maxY, LinkedList<Energia> energias) {
        int posicion_x = pos.getX() - 3;
        if (posicion_x < 0)
            posicion_x = 0;   // aca hay que ver como hacer pra el cso del borde de coordenadas
        int posicion_y = pos.getY() - 3;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = pos.getX() + 4;
        if (topeX > maxX)
            topeX = maxX;

        int topeY = pos.getY() + 4;
        if (topeY > maxY)
            topeY = maxY;

        int contador= 0;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                final int pos_i = i;
                final int pos_j = j;
                Posicion posicion = new Posicion(pos_i, pos_j);
                energias.removeIf(energia ->  ( (energia.getPos()).equals(posicion) && this.id == energia.getID() )  );

            }
        }

    }

    @Override
    public void desactivar() {
        energizado = true;
    }
}
