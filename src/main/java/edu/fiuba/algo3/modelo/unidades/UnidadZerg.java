package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.VidaZerg;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class UnidadZerg extends Unidad {
    private VidaZerg vida;
    public UnidadZerg(int puntosDeVidaMaximo, int costoMineral, int costoGas, Economia economia, Posicion pos, int tiempoDeConstruccion, int rango) {
        super(economia, costoMineral, costoGas, pos, tiempoDeConstruccion, rango);
        this.vida = new VidaZerg(puntosDeVidaMaximo);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque) {
        if (superficie.equals(tipoDeAtaque)) {
            return vida.daniar(danio);
        }
        return 0;
    }

    @Override
    public abstract void agregate(HashMap<TipoDeUnidades, LinkedList> listas);
}
