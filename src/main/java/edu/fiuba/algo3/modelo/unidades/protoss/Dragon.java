package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Dragon extends UnidadProtoss {

    public Dragon(Economia econ, Posicion pos) {
        super(100, 80, 125, 50, econ, pos, 6);
    }
}
