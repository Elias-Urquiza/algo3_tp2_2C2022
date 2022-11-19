package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Zealot extends UnidadProtoss {
    public Zealot(Economia economia, Posicion pos) {
        super(100, 60, 100, 0, economia, pos, 4);
    }
}
