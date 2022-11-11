package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;

public class Acceso extends ConstruccionProtoss implements Turno, Construccion {

    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 8;

    public Acceso(Economia economia){
        super(500, 500, 150, 0, 8, economia);
        turnosActivo = 0;

    }
    @Override
    public void pasarTurno(){
        curar();
        turnosActivo ++;
    }

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en Construccion");
    }
}
