package edu.fiuba.algo3.modelo.buildings;

public class ConstruccionProtoss {
    private int puntosDeVidaMaxima;
    private int puntosDeVida;
    private int escudo;
    private int escudoMaximo;
    private static final int CURACION_PROTOSS = 100;
    public ConstruccionProtoss(int puntosDeVidaMaxima, int escudoMaximo) {
        this.puntosDeVidaMaxima = puntosDeVidaMaxima;
        this.puntosDeVida = puntosDeVidaMaxima;
        this.escudo = escudoMaximo;
        this.escudoMaximo = escudoMaximo;
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
