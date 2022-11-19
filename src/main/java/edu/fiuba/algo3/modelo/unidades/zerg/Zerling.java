package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Zerling extends UnidadZerg {

    public Zerling(Economia economia, Posicion pos) {
        super(35, 25, 0, economia, pos, 2, 1);
    }
}
