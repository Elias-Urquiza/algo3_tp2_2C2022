package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Dragon extends UnidadProtoss {

    public Dragon(Economia econ, Posicion pos) {

        super(100, 80, 125, 50, econ, pos, 6, 4, new Tierra(0), new Tierra(0));
        ataques.add(new Tierra(20));
        ataques.add(new Aire(20));
    }

    @Override
    public void agregate(HashMap<TipoDeUnidades, LinkedList> listas) {
        listas.get(TipoDeUnidades.PROTOSS).add(this);
    }


}
