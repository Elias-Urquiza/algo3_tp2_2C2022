package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.VidaProtoss;

public class UnidadProtoss extends Unidad {
    private VidaProtoss vida;

    public UnidadProtoss(int puntosDeVidaMaximo, int escudoMaximo, int costoMineral, int costoGas, Economia econ, Posicion pos, int tiempoDeConstruccion, int rango) {
        super(econ, costoMineral, costoGas, pos, tiempoDeConstruccion, rango);
        this.vida = new VidaProtoss(puntosDeVidaMaximo, escudoMaximo);
    }

    @Override
    public int recibirDanio(int danio) {
        return vida.daniar(danio);
    }
}
