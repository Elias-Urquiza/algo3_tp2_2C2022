package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Zealot extends UnidadProtoss  {
    public Zealot(Economia economia, Posicion pos) {

        super(100, 60, 100, 0, economia, pos, 4, 1, new Tierra(0, 0), new Tierra(0, 0));
        ataques.add(new Tierra(8, 1));
    }

    @Override
    public void agregate(HashMap<Raza, LinkedList> listas) {
        listas.get(Raza.PROTOSS).add(this);
    }
}
