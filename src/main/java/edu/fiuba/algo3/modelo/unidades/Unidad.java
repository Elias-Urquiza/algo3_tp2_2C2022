package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.Turno;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Unidad implements Objetivo, Turno {

    private Posicion pos;
    private int tiempoDeConstruccion;
    private int rango;
    protected LinkedList<Ataque> ataques;
    protected Ataque superficieAtaque;
    private int turnos;
    protected Movimiento superficie;

    public Unidad(Economia economia, int costoMineral, int costoGas, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie) {
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
        this.superficieAtaque = superficieAtaque;
        this.superficie = superficie;
        this.ataques = new LinkedList<>();
        this.turnos = 0;
    }

    @Override
    public abstract int recibirDanio(int danio, Ataque tipoDeAtaque);

    public int atacar(Objetivo objetivo) {

        if(turnos < tiempoDeConstruccion)
            throw new RuntimeException("Unidad todavia en preparacion");

        int danio = 0;
        for (Ataque ataque : ataques) {
            danio += ataque.atacar(objetivo);
        }
        return danio;
    }

    public Posicion getPosicion(){
        return pos;
    }

    public void movete(Posicion pos, Boolean esVacio){
        if(turnos < tiempoDeConstruccion)
            throw new RuntimeException("Unidad todavia en preparacion");

        this.pos = superficie.moverse(esVacio, pos, this.pos);
    }

    public void setPosicion(Posicion nuevaPosicion){
        pos = nuevaPosicion;
    }

    public abstract void agregate(HashMap<TipoDeUnidades, LinkedList> listas);

    public void pasarTurno(){
        turnos++;
    }
}
