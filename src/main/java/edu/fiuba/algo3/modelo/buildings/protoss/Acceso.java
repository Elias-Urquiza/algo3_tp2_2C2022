package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;

public class Acceso extends ConstruccionProtoss implements Turno, Construccion {


    private static final int TIEMPO_CONSTRUCCION = 8;

    public Acceso(Economia economia, Posicion pos){
        super(500, 500, 150, 0, 8, economia, pos, true);
        turnos = 0;

    }

    @Override
    public void pasarTurno(){
        curar();
        turnos ++;
    }

    @Override
    public void usar() {
        if(turnos < TIEMPO_CONSTRUCCION || !energizado)
            throw new RuntimeException("Edificio no operativo");
    }
}
