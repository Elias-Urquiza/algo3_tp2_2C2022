package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Hidralisco extends UnidadZerg {

    public Hidralisco(Economia economia, Posicion pos) {

        super(80, 75, 25, economia, pos, 4, 4, new Tierra(0, 0), new Tierra(0, 0));
        ataques.add(new Aire(10, 4));
        ataques.add(new Tierra(10, 4));
    }

    @Override
    public void agregate(HashMap<Raza, LinkedList> listas) {
        listas.get(Raza.ZERG).add(this);
    }
}
