package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Scout extends UnidadProtoss implements Ataque {
    public Scout(Economia economia, Posicion posicion) {
        super(150, 100, 300, 150, economia, posicion, 9, 4);
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
