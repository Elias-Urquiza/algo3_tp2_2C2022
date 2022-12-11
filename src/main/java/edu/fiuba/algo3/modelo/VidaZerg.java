package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

import java.util.LinkedList;

public class VidaZerg extends Vida {

    public VidaZerg(int puntosDeVidaMaxima) {
        super(puntosDeVidaMaxima);
    }

    @Override
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

    @Override
    public int curar(int curacionZerg) {
        final int vidaPreCuracion = puntosDeVida;
        final int curacion = puntosDeVida + curacionZerg;
        if (curacion > puntosDeVidaMaxima) {
            puntosDeVida = puntosDeVidaMaxima;
        } else {
            puntosDeVida += curacionZerg;
        }
        return puntosDeVida - vidaPreCuracion;
    }
}
