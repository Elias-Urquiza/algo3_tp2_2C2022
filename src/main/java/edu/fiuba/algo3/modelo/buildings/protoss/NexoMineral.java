package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;

public class NexoMineral extends ConstruccionProtoss implements Turno, Construccion {

    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 4;

    public NexoMineral(){
        super(250, 250);
        turnosActivo = 0;
    }
    @Override
    public void pasarTurno(){
        curar();
        turnosActivo ++;
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales

    }

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

    }
}
