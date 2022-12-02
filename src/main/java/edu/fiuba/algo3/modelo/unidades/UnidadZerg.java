package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.VidaZerg;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class UnidadZerg extends Unidad {
    private VidaZerg vida;

    public UnidadZerg(int puntosDeVidaMaximo, int costoMineral, int costoGas, Economia economia, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie) {
        super(economia, costoMineral, costoGas, pos, tiempoDeConstruccion, rango, superficieAtaque, superficie);
        this.vida = new VidaZerg(puntosDeVidaMaximo);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion posicionAtacante) {
        if (superficieAtaque.equals(tipoDeAtaque) && tipoDeAtaque.inRange(pos, posicionAtacante)) {
            return vida.daniar(danio);
        }
        return 0;//podemos poner una constante
    }

    @Override
    public abstract void agregate(HashMap<TipoDeUnidades, LinkedList> listas);
}
