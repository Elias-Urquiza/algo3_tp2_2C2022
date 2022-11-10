package edu.fiuba.algo3.modelo.buildings;

public class ConstruccionZerg {
    private int puntosDeVida;
    private int puntosDeVidaMaxima;
    private static final int CURACION_ZERG = 100;

    public ConstruccionZerg(int puntosDeVidaMaxima) {
        this.puntosDeVida = puntosDeVidaMaxima;
        this.puntosDeVidaMaxima = puntosDeVidaMaxima;
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
