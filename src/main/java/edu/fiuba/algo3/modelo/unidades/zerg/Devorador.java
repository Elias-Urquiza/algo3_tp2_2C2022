package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

import java.util.HashMap;
import java.util.LinkedList;

public class Devorador extends UnidadZerg {

    public Devorador(Economia economia, Posicion pos) {

        super(200, 150, 50, economia, pos, 4, 5, new Aire(0), new Aire(0));

        ataques.add(new Aire(15));
        correlatividad.add(Mutalisco.class);
    }

    @Override
    public void agregate(HashMap<TipoDeUnidades, LinkedList> listas) {
        listas.get(TipoDeUnidades.ZERG).add(this);
    }
}
