package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Hidralisco extends UnidadZerg implements Ataque {

    public Hidralisco(Economia economia, Posicion pos) {
        super(80, 75, 25, economia, pos, 4, 4);
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
