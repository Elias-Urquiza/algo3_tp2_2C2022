package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Mutalisco extends UnidadZerg implements Ataque {

    public Mutalisco(Economia economia, Posicion pos) {
        super(120, 100, 100, economia, pos, 7, 3);
    }



    @Override
    public void ataqueTerrestre(Objetivo unObjetivo) {

    }

    @Override
    public void ataqueAereo(Objetivo unObjetivo) {

    }
}
