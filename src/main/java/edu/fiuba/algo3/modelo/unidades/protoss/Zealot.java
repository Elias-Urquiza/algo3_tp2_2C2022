package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Zealot extends UnidadProtoss implements Ataque {
    public Zealot(Economia economia, Posicion pos) {
        super(100, 60, 100, 0, economia, pos, 4, 1);
    }

    public void atacar(Objetivo unObjetivo) {

    }

    @Override
    public void ataqueTerrestre(Objetivo unObjetivo) {

    }

    @Override
    public void ataqueAereo(Objetivo unObjetivo) {

    }
}
