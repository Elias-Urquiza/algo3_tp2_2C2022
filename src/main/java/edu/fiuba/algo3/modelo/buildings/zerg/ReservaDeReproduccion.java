package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

public class ReservaDeReproduccion extends ConstruccionZerg implements Construccion, Turno {


    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 12;

    public ReservaDeReproduccion(Economia economia, int posX, int posY){
        super(1000, 150, 0, 12, economia, posX, posY);
        turnosActivo = 0;
    }

    public void evolucionarLarvas(int larvasEvolucionar)throws RuntimeException{
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");
    }
    public void pasarTurno() {
        curar();
        turnosActivo++;
    }
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");
    }
}
