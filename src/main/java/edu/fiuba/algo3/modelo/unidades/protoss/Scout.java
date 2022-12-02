package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Scout extends UnidadProtoss {
    public Scout(Economia economia, Posicion posicion) {
        super(150, 100, 300, 150, economia, posicion, 9, 4, new Aire(0),new Aire(0));
        ataques.add(new Aire(14));
        ataques.add(new Tierra(8));
    }

    @Override
    public void agregate(HashMap<Raza, LinkedList> listas) {
        listas.get(Raza.PROTOSS).add(this);
    }
}
