package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.VidaProtoss;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class UnidadProtoss extends Unidad {
    private VidaProtoss vida;

    public UnidadProtoss(int puntosDeVidaMaximo, int escudoMaximo, int costoMineral, int costoGas, Economia econ, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie) {
        super(econ, costoMineral, costoGas, pos, tiempoDeConstruccion, rango, superficieAtaque, superficie);
        this.vida = new VidaProtoss(puntosDeVidaMaximo, escudoMaximo);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion posicionAtacante) {
        if (superficieAtaque.equals(tipoDeAtaque) && tipoDeAtaque.inRange(pos, posicionAtacante)) {
            return vida.daniar(danio);
        }
        return 0;
    }



    @Override
    public abstract void agregate(HashMap<TipoDeUnidades, LinkedList> listas);
}
