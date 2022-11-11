package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.Economia;

public class ConstruccionZerg {
    private int puntosDeVida;
    private int puntosDeVidaMaxima;
    private int costoMineral;
    private int costoGas;
    protected int tiempoDeConstruccion;
    private static final int CURACION_ZERG = 100;

    public ConstruccionZerg(int puntosDeVidaMaxima, int costoMineral, int costoGas, int tiempoDeConstruccion, Economia economia,
                            int posX, int posY) {
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
        this.puntosDeVida = puntosDeVidaMaxima;
        this.puntosDeVidaMaxima = puntosDeVidaMaxima;
        this.costoGas = costoGas;
        this.costoMineral = costoMineral;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }

    public int curar() {
        final int vidaPreCuracion = puntosDeVida;
        final int curacion = puntosDeVida + CURACION_ZERG;
        if (curacion > puntosDeVidaMaxima) {
            puntosDeVida = puntosDeVidaMaxima;
        } else {
            puntosDeVida += CURACION_ZERG;
        }
        return puntosDeVida - vidaPreCuracion;
    }

    public int daniar(int danio) {
        final int vidaPreDanio = puntosDeVida;
        final int dmg = puntosDeVida - danio;
        if (dmg <= 0) {
            puntosDeVida = 0;
        } else {
            puntosDeVida -= danio;
        }
        return vidaPreDanio - puntosDeVida;
    }
}
