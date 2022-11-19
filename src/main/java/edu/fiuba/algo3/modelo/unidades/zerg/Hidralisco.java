package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

import java.util.HashMap;
import java.util.LinkedList;

public class Hidralisco extends UnidadZerg {

    public Hidralisco(Economia economia, Posicion pos) {
        super(80, 75, 25, economia, pos, 4, 4);
    }

    public void atacar(Objetivo unObjetivo) {

    }

    @Override
    public void agregate(HashMap<TipoDeUnidades, LinkedList> listas) {
        listas.get(TipoDeUnidades.ZERG).add(this);
    }
}
