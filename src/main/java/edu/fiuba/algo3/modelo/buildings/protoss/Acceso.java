package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;

public class Acceso implements Turno, Construccion {
    private int puntosDeVida;

    private int turnosActivo;

    private int puntosDeEscudo;

    private static final int MAX_ESCUDO = 500;

    private static final int TIEMPO_CONSTRUCCION = 8;

    public Acceso(){
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

    @Override
    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en Construccion");
    }
}
