package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Recurso;

public class NexoMineral extends ConstruccionProtoss implements Turno, Construccion, ExtraeRecurso {
    private Recurso recurso;
    private Economia economia;
    private static final int TIEMPO_CONSTRUCCION = 4;

    private static final int MINERAL_POR_TURNO = 20;

    public NexoMineral(Economia economia, Posicion pos){
        super(250, 250, 50, 0, 4, economia, pos, true);
        turnos = 0;
        this.economia = economia;
    }
    @Override
    public void pasarTurno(){
        curar();

        if(turnos >= TIEMPO_CONSTRUCCION){
            extraer();
        }

        turnos ++;
    }



    @Override
    public void usar() {
        if(turnos < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

    }

    @Override
    public void desactivar(){
        energizado = true;
    }

    @Override // no hace nada que onda
    public void extraer() {
        economia.ingresarMineral(recurso.extraer(MINERAL_POR_TURNO));
    }

    @Override
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}
