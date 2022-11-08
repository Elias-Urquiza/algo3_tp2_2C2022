package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class NexoMineral implements Turno, Construccion {

    private int puntosDeVida;

    private int turnosActivo;

    private int puntosDeEscudo;

    private static final int MAX_ESCUDO = 250;

    private static final int TIEMPO_CONSTRUCCION = 4;

    public NexoMineral(){
        puntosDeVida = 250;
        turnosActivo = 0;
        puntosDeEscudo = 250;
    }
    @Override
    public void pasarTurno(){
        if(puntosDeEscudo < MAX_ESCUDO){
            puntosDeEscudo++; //Aqui solo hago un ++ ya que no se de q manera va subiendo el escudo
        }
        turnosActivo ++;
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales

    }

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

    }
}
