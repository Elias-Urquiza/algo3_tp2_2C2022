package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;

public class Extractor implements Construccion, Turno {

    private int turnosActivo;
    private int vida;
    private static final int MAX_LARVAS = 3;
    private static final int PRODUCCION_POR_ZANGANO=10;
    private int zanganos;
    private Economia economia;
    private static final int TIEMPO_CONSTRUCCION = 6;

    public Extractor(Economia economiaZerg){
        turnosActivo = 0           ;
        vida         = 750         ;
        economia     = economiaZerg;
        zanganos     = 0           ;
    }

    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }


    }

    public void agregarZangano(Criadero unCriadero){ // AGREGA DE A UNO
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }

        try{
            unCriadero.extraerLarvas(1);
        }catch (RuntimeException e){
            throw new RuntimeException("No se pudo agregar un zangano");
        }

        if(zanganos < MAX_LARVAS)
            zanganos++;
    }

    @Override
    public void pasarTurno() {
        turnosActivo++;
        economia.ingresarGasVespeno(zanganos * PRODUCCION_POR_ZANGANO);

        if(turnosActivo >= TIEMPO_CONSTRUCCION){

        }

    }
}
