package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class Extractor implements Construccion, Turno {



    private int turnosActivo;
    private int vida;

    private int zanganos;

    private int gas;

    private static final int TIEMPO_CONSTRUCCION = 6;

    private static final int MIN_ZANGANOS = 1;

    private static final int MAX_ZANGANOS = 3;

    private static final int MULTIPLICADOR_GAS = 10;

    public Extractor(){
        turnosActivo = 0;
        vida = 750;
        zanganos = 0;
        gas = 0;
    }

    public void extraer(){
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }
        if(zanganos < MIN_ZANGANOS ){
            throw new RuntimeException("No hay zanganos para trabajar");
        }
        gas = zanganos * MULTIPLICADOR_GAS; // tendria que mandarle el mensaje a la clase economia, y agregar gas
    }

    public void agregarZangano(){
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }
        if (zanganos  == MAX_ZANGANOS){
            throw new RuntimeException("Ya se llego al limite de zanganos");
        }
        zanganos++;
    }

    public int cantidadDeGas(){
        return gas;

    }


    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }

    }

    @Override
    public void pasarTurno() {
        turnosActivo++;
    }
}
