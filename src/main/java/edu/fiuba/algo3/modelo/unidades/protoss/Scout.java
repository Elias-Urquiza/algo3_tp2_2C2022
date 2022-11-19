package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Scout extends UnidadProtoss {
    public Scout(Economia economia, Posicion posicion) {
        super(150, 100, 300, 150, economia, posicion, 9, 4);
    }
}
