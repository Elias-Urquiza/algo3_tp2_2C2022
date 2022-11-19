package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Zerling extends UnidadZerg implements Ataque {

    public Zerling(Economia economia, Posicion pos) {
        super(35, 25, 0, economia, pos, 2, 1);
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
