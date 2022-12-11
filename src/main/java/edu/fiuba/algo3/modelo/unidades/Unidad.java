package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Suministros;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.Turno;


import java.util.HashMap;
import java.util.LinkedList;

public abstract class Unidad implements Objetivo, Turno {

    protected Posicion pos;
    protected int tiempoDeConstruccion;
    private int rango;
    protected int suministro;
    protected LinkedList<Ataque> ataques;
    protected Ataque superficieAtaque;
    protected int turnos;
    protected Movimiento superficie;

    public Unidad(Economia economia, int costoMineral, int costoGas, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie,
                  int suministro) {
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
        this.suministro = suministro;
    }

    @Override
    public abstract int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion pos);

    public int atacar(Objetivo objetivo) {

        if(turnos < tiempoDeConstruccion)
            throw new RuntimeException("Unidad todavia en preparacion");

        int danio = 0;
        for (Ataque ataque : ataques) {
            danio += ataque.atacar(objetivo, pos);
        }
        return danio;
    }

    public void morirConstruccion(){

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

    public abstract void agregate(HashMap<Raza, LinkedList> listas, HashMap<Raza, Suministros> suministros);

    public void pasarTurno(){
        turnos++;
    }
}
