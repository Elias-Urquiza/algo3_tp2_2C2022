package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.unidades.Objetivo;

import java.util.LinkedList;

public class ConstruccionProtoss implements Turno, Objetivo {
    private VidaProtoss vida;
    protected int costoMineral;
    protected int costoGas;
    protected int tiempoDeConstruccion;
    private static final int CURACION_PROTOSS = 100;
    protected Posicion pos;

    protected boolean energizado;
    //PODRIAMOS HACER QUE EL PASAR TURNO DE CONSTRUCCION PROTOSSS SE CURE O REGENERE ESCUDO

    public ConstruccionProtoss(int puntosDeVidaMaxima, int escudoMaximo, int costoMineral, int costoGas, int tiempoDeConstruccion, Economia economia, Posicion pos, boolean energizado) {
        try {
            if (costoGas != 0){
                economia.gastarGasVespeno(costoGas);
            }
            if (costoMineral != 0){
                economia.gastarMineral(costoMineral);
            }
        } catch(final RuntimeException e) {
            throw new RuntimeException("No tenes los minerales suficientes");
        }
        this.costoMineral = costoMineral;
        this.costoGas = costoGas;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.pos = pos;
        this.energizado = energizado;
        this.vida = new VidaProtoss(puntosDeVidaMaxima, escudoMaximo);
    }

    @Override
    public int daniar(int danio) {
       return vida.daniar(danio);
    }

    public int curar() {
        return vida.curar(CURACION_PROTOSS);
    }
    public void desactivar(){
        energizado = false;
    }
    public void activar(){
        energizado = true;
    }//a lo mejor usar interfaz

    public Boolean destruir(Posicion pos) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            afirmacion = true;
        }

        return afirmacion;
    }


    public void pasarTurno() {
        return;
    }

    public Posicion getPosicion() {
        return pos;
    }
}
