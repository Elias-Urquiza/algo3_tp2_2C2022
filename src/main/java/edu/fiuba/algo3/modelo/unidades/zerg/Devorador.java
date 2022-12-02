package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.unidades.Aire;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

import java.util.HashMap;
import java.util.LinkedList;

public class Devorador extends UnidadZerg {


    public Devorador(Economia economia, Posicion pos) {

        super(200, 150, 50, economia, pos, 4, 5, new Aire(0, 0), new Aire(0, 0));


        correlativity.add(Mutalisco.class);

        ataques.add(new Aire(15, 5));
    }

    @Override
    public void agregate(HashMap<Raza, LinkedList> listas) {
        listas.get(Raza.ZERG).add(this);
    }
}
