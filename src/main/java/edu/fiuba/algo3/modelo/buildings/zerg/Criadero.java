package edu.fiuba.algo3.modelo.buildings.zerg;


import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.Moho;

import java.util.LinkedList;

public class Criadero extends ConstruccionZerg implements Turno, Construccion {

    private int numeroDeLarvas;
    private int turnosActivo;

    // TODO incluir atributo de ubicacion ?

    private static final int MAX_LARVAS = 3;

    public Criadero(Economia economia, int posX, int posY) {
        super(500, 50, 0, 4, economia, posX, posY);
        numeroDeLarvas = 3;
        turnosActivo = 0;
    }

    public void extraerLarvas(int quitarLarvas) throws RuntimeException {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0))
            throw new RuntimeException("Numero de Larvas incorrecto");
        if (turnosActivo < tiempoDeConstruccion)
            throw new RuntimeException("Edificio en construccion");

        numeroDeLarvas -= quitarLarvas;
    }

    @Override
    public void pasarTurno() {
        if(numeroDeLarvas < MAX_LARVAS)
            numeroDeLarvas++;
        curar();
        turnosActivo++;
    }

    @Override
    public void usar() {

    }
    /*
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 M 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
     */


    public void mohificar(int x, int y, int maxX, int maxY, LinkedList<Moho> mohos) {
        mohos.add(new Moho(x, y));

        int posicion_x = pos.getX() -5;
        if (posicion_x<0)
            posicion_x = 0;

        int posicion_y = pos.getY() -5;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = pos.getX() + 6;
        if(topeX > maxX)
            topeX = maxX;

        int topeY = pos.getY() + 6;
        if(topeY > maxY)
            topeY = maxY;

        for(int i = posicion_x; i<(topeX) ; i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                Moho moho = new Moho(i, j);
                mohos.add(moho);
            }
        }
    }
}
