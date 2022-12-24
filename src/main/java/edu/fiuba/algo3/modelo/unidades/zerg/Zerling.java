package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Zerling extends UnidadZerg {

    public Zerling(Economia economia, Posicion pos) {

        super(35, 25, 0, economia, pos, 2, 1, new Tierra(0, 0), new Tierra(0, 0),
                1);
        ataques.add(new Tierra(150, 1));
    }
}
