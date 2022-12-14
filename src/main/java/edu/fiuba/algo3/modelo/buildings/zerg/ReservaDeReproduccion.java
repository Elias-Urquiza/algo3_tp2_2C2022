package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

public class ReservaDeReproduccion extends ConstruccionZerg implements Construccion, Turno {




    private static final int TIEMPO_CONSTRUCCION = 12;

    public ReservaDeReproduccion(Economia economia, Posicion pos){
        super(1000, 150, 0, 12, economia, pos);
        turnos = 0;
    }

    public void evolucionarLarvas(int larvasEvolucionar)throws RuntimeException{
        if(turnos < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");
    }
    public void pasarTurno() {
        curar();
        turnos++;
    }
    public void usar() {
        if(turnos < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");
    }
}
