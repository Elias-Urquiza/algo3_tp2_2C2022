package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

public class Espiral extends ConstruccionZerg implements Turno, Construccion {


    private static final int TIEMPO_CONSTRUCCION = 10;

    public Espiral(Economia economia, Posicion pos) {
        super(1300, 150, 100, 10, economia, pos);
        turnos = 0;
        correlativity.add(Guarida.class);
    }

    @Override
    public void usar() {
        if (turnos < TIEMPO_CONSTRUCCION) {
            throw new RuntimeException("No se puede usar todavia");
        }
    }

    @Override
    public void pasarTurno() {
        curar();
        turnos++;
    }
}
