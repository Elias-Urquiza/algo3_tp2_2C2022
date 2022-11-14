package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Recurso;

public class Asimilador extends ConstruccionProtoss implements Turno, Construccion, ExtraeRecurso {

    private int turnosActivo;

    private Economia economia;
    private Recurso recurso;

    private static final int GAS_POR_TURNO = 20;

    private static final int TIEMPO_CONSTRUCCION = 6;

    public Asimilador(Economia economiaProto, Posicion pos) {  //Debo agregar una economia a los ytest asimilador
        super(450, 450, 100, 0, 6, economiaProto, pos, true);
        turnosActivo =0;
        economia = economiaProto;
    }

    @Override
    public void pasarTurno(){
        curar();  //Asumo que va sumando de a un por turno
        if(turnosActivo >= TIEMPO_CONSTRUCCION && energizado){
            extraer();
        }
        turnosActivo++;
    }

    @Override
    public void desactivar() {
        energizado = true;
    }


    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION || !energizado)
            throw new RuntimeException("Edificio en construccion");

    }

    @Override
    public void extraer() {
        economia.ingresarGasVespeno(recurso.extraer(GAS_POR_TURNO));
    }

    @Override
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}
