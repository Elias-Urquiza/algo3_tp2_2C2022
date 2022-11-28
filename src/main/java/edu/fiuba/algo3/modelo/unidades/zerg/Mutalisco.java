package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Mutalisco extends UnidadZerg {

    public Mutalisco(Economia economia, Posicion pos) {

        super(120, 100, 100, economia, pos, 7, 3, new Aire(0), new Aire(0));
        ataques.add(new Aire(9));
        ataques.add(new Tierra(9));
        correlatividad.add(Espiral.class);
    }


    @Override
    public void agregate(HashMap<TipoDeUnidades, LinkedList> listas) {
        listas.get(TipoDeUnidades.ZERG).add(this);
    }
}
