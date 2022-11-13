package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Turno;

public class ConstruccionProtoss {
    private int puntosDeVidaMaxima;
    private int puntosDeVida;
    private int escudo;
    private int escudoMaximo;
    protected int costoMineral;
    protected int costoGas;
    protected int tiempoDeConstruccion;
    private static final int CURACION_PROTOSS = 100;
    protected int posX;
    protected int posY;

    public ConstruccionProtoss(int puntosDeVidaMaxima, int escudoMaximo, int costoMineral, int costoGas, int tiempoDeConstruccion, Economia economia, int posX, int posY) {
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
        this.posX=posX;
        this.posY=posY;
    }


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
}
