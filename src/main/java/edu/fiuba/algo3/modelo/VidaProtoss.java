package edu.fiuba.algo3.modelo;

public class VidaProtoss extends Vida {

    private int escudoMaximo;
    private int escudo;
    public VidaProtoss(int puntosDeVidaMaximo, int escudoMaximo) {
        super(puntosDeVidaMaximo);
        this.escudoMaximo = escudoMaximo;
        this.escudo = escudoMaximo;
    }

    @Override
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

    @Override
    public int curar(int curacionProtoss) {
        final int escudoPreCuracion = escudo;
        final int curacion = escudo + curacionProtoss;
        if (curacion > escudoMaximo) {
            escudo = escudoMaximo;
        } else {
            escudo += curacionProtoss;
        }
        return escudo - escudoPreCuracion;
    }
}
