package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.Estructura;
import edu.fiuba.algo3.modelo.tiles.FloorManager;
import edu.fiuba.algo3.modelo.tiles.Recurso;

import java.util.LinkedList;
import java.util.List;

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
    public void destruir(LinkedList<ConstruccionZerg> construccionesZerg, LinkedList<ConstruccionProtoss> construccionProtoss, LinkedList<ExtraeRecurso> extraeRecursos, FloorManager floorManager) {
        LinkedList<Estructura> list = (LinkedList<Estructura>) (List<?>)  extraeRecursos;
        vida.eliminarConstruccion(  list, this);
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

    @Override
    public void extraer() {
        try {
            economia.ingresarMineral(recurso.extraer(MINERAL_POR_TURNO));
        } catch (RuntimeException ignored) {}
    }

    @Override
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}
