package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;

import java.util.LinkedList;

public class ConstruccionProtoss implements Turno {
    private int puntosDeVidaMaxima;
    private int puntosDeVida;
    private int escudo;
    private int escudoMaximo;
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
        this.puntosDeVidaMaxima = puntosDeVidaMaxima;
        this.puntosDeVida = puntosDeVidaMaxima;
        this.escudo = escudoMaximo;
        this.escudoMaximo = escudoMaximo;
        this.costoMineral = costoMineral;
        this.costoGas = costoGas;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.pos = pos;
        this.energizado = energizado;
    }

    public void desactivar(){
        energizado = false;
    }
    public void activar(){
        energizado = true;
    }//a lo mejor usar interfaz

    public int daniar(int danio) {
        int dmg = escudo - danio;
        if (dmg < 0) {
            int danioVida = daniarVida(danio - escudo);
            escudo = 0;
            return danioVida;
        } else {
            escudo -= danio;
            return 0;
        }
    }

    private int daniarVida(int danio) {
        final int vidaPreDanio = puntosDeVida;
        final int dmg = puntosDeVida - danio;
        if (dmg <= 0) {
            puntosDeVida = 0;
        } else {
            puntosDeVida -= danio;
        }
        return vidaPreDanio - puntosDeVida;
    }

    public int curar() {
        final int escudoPreCuracion = escudo;
        final int curacion = escudo + CURACION_PROTOSS;
        if (curacion > escudoMaximo) {
            escudo = escudoMaximo;
        } else {
            escudo += CURACION_PROTOSS;
        }
        return escudo - escudoPreCuracion;
    }

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
