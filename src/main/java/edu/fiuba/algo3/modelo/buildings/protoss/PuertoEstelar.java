package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;

public class PuertoEstelar extends ConstruccionProtoss implements Turno, Construccion {


    private static final int TIEMPO_CONSTRUCCION = 10;

    private static final int MAX_ESCUDO = 600;

    public PuertoEstelar(Economia economia, Posicion pos){
        super(600, 600, 150, 150, 10, economia, pos, true);
        turnos = 0;
        correlativity.add(Acceso.class);
    }
    @Override
    public void pasarTurno(){
        curar();
        turnos ++;

    }


    @Override
    public void usar() {
        if(turnos < TIEMPO_CONSTRUCCION || !energizado)
            throw new RuntimeException("Edificio en construccion");

    }
}
