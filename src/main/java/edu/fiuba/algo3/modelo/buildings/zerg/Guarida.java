package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

public class Guarida extends ConstruccionZerg implements Construccion, Turno {
    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 12;

    public Guarida(Economia economia, Posicion pos){
        super(1250, 200, 100, 12, economia, pos);
        turnosActivo = 0;
    }

    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }

    }

    @Override
    public void pasarTurno() {
        curar();
        turnosActivo++;
    }
}
