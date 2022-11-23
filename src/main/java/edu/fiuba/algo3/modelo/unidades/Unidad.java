package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Unidad implements Objetivo {

    private Posicion pos;
    private int tiempoDeConstruccion;
    private int rango;
    protected LinkedList<Ataque> ataques;
    protected Ataque superficie;

    public Unidad(Economia economia, int costoMineral, int costoGas, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficie) {
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
        this.rango = rango;
        this.pos = pos;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.superficie = superficie;
        this.ataques = new LinkedList<>();
    }

    @Override
    public abstract int recibirDanio(int danio, Ataque tipoDeAtaque);

    public int atacar(Objetivo objetivo) {
        int danio = 0;
        for (Ataque ataque : ataques) {
            danio += ataque.atacar(objetivo);
        }
        return danio;
    }

    public void setPosicion(Posicion nuevaPosicion){
        pos = nuevaPosicion;
    }

    public abstract void agregate(HashMap<TipoDeUnidades, LinkedList> listas);
}
