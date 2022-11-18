package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.tiles.*;

import java.util.LinkedList;

public class CriaderoActivo extends Criadero {

    private FloorManager fm;

    public CriaderoActivo() {
        super(new MockEconomia(), new Posicion(0,0));

        fm = new FloorManager( (new LinkedList<Moho>()), new LinkedList<Cristales>(),new LinkedList<Volcan>(), new LinkedList<Energia>(),
                                new LinkedList< TileVacia >(), new LinkedList<ConstruccionZerg>(), new LinkedList<ConstruccionProtoss>(),
                                new LinkedList<ExtraeRecurso>(),20, 20);

        setFloorManager(fm);
        pasarTurno();
        pasarTurno();
        pasarTurno();
        pasarTurno();
    }

}
