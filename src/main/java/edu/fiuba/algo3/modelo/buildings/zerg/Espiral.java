package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

public class Espiral extends ConstruccionZerg implements Turno, Construccion {

    private int turnosActivo;
    private static final int TIEMPO_CONSTRUCCION = 10;

    public Espiral(Economia economia, int posX, int posY) {
        super(1300, 150, 100, 10, economia, posX, posY);
        turnosActivo = 0;
    }

    @Override
    public void usar() {
        if (turnosActivo < TIEMPO_CONSTRUCCION) {
            throw new RuntimeException("No se puede usar todavia");
        }
    }

    @Override
    public void pasarTurno() {
        curar();
        turnosActivo++;
    }
}
