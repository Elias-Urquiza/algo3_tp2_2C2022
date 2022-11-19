package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Dragon extends UnidadProtoss implements Ataque {

    public Dragon(Economia econ, Posicion pos) {
        super(100, 80, 125, 50, econ, pos, 6, 4);
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
