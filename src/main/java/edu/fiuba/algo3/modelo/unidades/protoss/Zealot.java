package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Zealot extends UnidadProtoss  {
    public Zealot(Economia economia, Posicion pos) {

        super(100, 60, 100, 0, economia, pos, 4, 1, new Tierra(0), new Tierra(0));
        ataques.add(new Tierra(8));
        correlatividad.add(Acceso.class);
    }

    @Override
    public void agregate(HashMap<TipoDeUnidades, LinkedList> listas) {
        listas.get(TipoDeUnidades.PROTOSS).add(this);
    }
}
