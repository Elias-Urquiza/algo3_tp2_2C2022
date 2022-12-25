package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.Estructura;
import edu.fiuba.algo3.modelo.tiles.FloorManager;
import edu.fiuba.algo3.modelo.tiles.Recurso;

import java.util.LinkedList;
import java.util.List;

public class Asimilador extends ConstruccionProtoss implements Turno, Construccion, ExtraeRecurso {



    private Economia economia;
    private Recurso recurso;

    private static final int GAS_POR_TURNO = 20;

    private static final int TIEMPO_CONSTRUCCION = 6;

    public Asimilador(Economia economiaProto, Posicion pos) {  //Debo agregar una economia a los ytest asimilador
        super(450, 450, 100, 0, 6, economiaProto, pos, true);
        turnos =0;
        economia = economiaProto;
    }

    @Override
    public void destruir(LinkedList<ConstruccionZerg> construccionesZerg, LinkedList<ConstruccionProtoss> construccionProtoss, LinkedList<ExtraeRecurso> extraeRecursos, FloorManager floorManager) {
        LinkedList<Estructura> list = (LinkedList<Estructura>) (List<?>)  extraeRecursos;
        vida.eliminarConstruccion(  list, this);

    }

    @Override
    public void pasarTurno(){
        curar();  //Asumo que va sumando de a un por turno
        if(turnos >= TIEMPO_CONSTRUCCION && energizado){
            extraer();
        }
        turnos++;
    }

    @Override
    public void desactivar() {
        energizado = true;
    }


    @Override
    public void usar() {
        if(turnos < TIEMPO_CONSTRUCCION || !energizado)
            throw new RuntimeException("Edificio en construccion");

    }

    @Override
    public void extraer() {
        try {
            economia.ingresarGasVespeno(recurso.extraer(GAS_POR_TURNO));
        } catch (RuntimeException ignored) {}
    }

    @Override
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}
