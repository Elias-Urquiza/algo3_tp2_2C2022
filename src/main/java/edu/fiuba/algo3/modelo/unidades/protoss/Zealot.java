package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

import java.util.HashMap;
import java.util.LinkedList;

public class Zealot extends UnidadProtoss  {
    public Zealot(Economia economia, Posicion pos) {
        super(100, 60, 100, 0, economia, pos, 4, 1);
    }

    public void atacar(Objetivo unObjetivo) {

    }

    @Override
    public void agregate(HashMap<TipoDeUnidades, LinkedList> listas) {
        listas.get(TipoDeUnidades.PROTOSS).add(this);
    }
}
