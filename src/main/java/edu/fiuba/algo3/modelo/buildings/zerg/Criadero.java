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

    public void mohificar(int x, int y, LinkedList<Moho> mohos) {
        mohos.add(new Moho(x, y));

        int posicion_x = posX -5;
        if (posicion_x<0){
            posicion_x = 0;
        }
        int posicion_y = posY -5;
        if (posicion_y < 0){
            posicion_y = 0;
        }
        for(int i = posicion_x; i<(posX+5) ; i++) {
            for (int j = posicion_y; j < (posY + 5); j++) {
                Moho moho = new Moho(i, j);
                mohos.add(moho);
            }
        }
    }
}
