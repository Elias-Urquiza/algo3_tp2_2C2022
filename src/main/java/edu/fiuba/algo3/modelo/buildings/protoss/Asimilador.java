package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;

public class Asimilador extends ConstruccionProtoss implements Turno, Construccion {

    private int turnosActivo;

    private Economia economia;

    private static final int GAS_POR_TURNO = 20;

    private static final int TIEMPO_CONSTRUCCION = 6;

    public Asimilador(Economia economiaProto) {  //Debo agregar una economia a los ytest asimilador
        super(450, 450);
        turnosActivo =0;
        economia = economiaProto;
    }

    @Override
    public void pasarTurno(){
        curar();  //Asumo que va sumando de a un por turno
        if(turnosActivo >= TIEMPO_CONSTRUCCION){
            economia.ingresarGasVespeno(GAS_POR_TURNO);
        }
        turnosActivo++;
    }

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

    }
}
