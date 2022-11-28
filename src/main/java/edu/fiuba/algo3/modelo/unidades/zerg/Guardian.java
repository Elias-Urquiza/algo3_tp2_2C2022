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

public class Guardian extends UnidadZerg {

    public Guardian(Economia economia, Posicion pos) {

        super(100, 50, 100, economia, pos, 4, 10, new Aire(0),new Aire(0));

        ataques.add(new Tierra(25));
        correlatividad.add(Mutalisco.class);
    }

    @Override
    public void agregate(HashMap<TipoDeUnidades, LinkedList> listas) {
        listas.get(TipoDeUnidades.ZERG).add(this);
    }
}
