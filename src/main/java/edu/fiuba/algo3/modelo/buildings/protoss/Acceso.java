package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Turno;

public class Acceso implements Turno {
    private int puntosDeVida;

    private int turnosActivo;

    private int puntosDeEscudo;

    private static final int MAX_ESCUDO = 500;

    public NexoMineral(){
        puntosDeVida = 500;
        turnosActivo = 0;
        puntosDeEscudo = 500;
    }
    @Override
    public void pasarTurno(){
        if(puntosDeEscudo < MAX_ESCUDO){
            puntosDeEscudo++; //Aqui solo hago un ++ ya que no se de q manera va subiendo el escudo
        }
        turnosActivo ++;

    }
}
