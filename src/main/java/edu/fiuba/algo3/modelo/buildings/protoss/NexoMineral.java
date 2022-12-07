package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Recurso;

public class NexoMineral extends ConstruccionProtoss implements Turno, Construccion, ExtraeRecurso {

    private int turnosActivo;
    private Recurso recurso;
    private Economia economia;
    private static final int TIEMPO_CONSTRUCCION = 4;

    private static final int MINERAL_POR_TURNO = 20;

    public NexoMineral(Economia economia, Posicion pos){
        super(250, 250, 50, 0, 4, economia, pos, true);
        turnosActivo = 0;
        this.economia = economia;
    }
    @Override
    public void pasarTurno(){
        curar();
        turnosActivo ++;
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales

    }



    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION || !energizado)
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
