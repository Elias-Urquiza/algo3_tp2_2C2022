package edu.fiuba.algo3.modelo.buildings.zerg;


import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.FloorManager;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.tiles.Moho;

import java.util.LinkedList;

public class Criadero extends ConstruccionZerg implements Turno, Construccion {

    private int numeroDeLarvas;
    private int turnosActivo;

    // TODO incluir atributo de ubicacion ?

    private static final int MAX_LARVAS = 3;

    private FloorManager floorManager;

    public Criadero(Economia economia, Posicion pos) {
        super(500, 50, 0, 4, economia, pos);
        numeroDeLarvas = 3;
        turnosActivo = 0;
        floorManager = null;
    }
    

    public void extraerLarvas(int quitarLarvas) throws RuntimeException {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0))
            throw new RuntimeException("Numero de Larvas incorrecto");
        if (turnosActivo < tiempoDeConstruccion)
            throw new RuntimeException("Edificio en construccion");

        numeroDeLarvas -= quitarLarvas;
    }

    public int preguntarTurno(){
        return turnosActivo;
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

}
