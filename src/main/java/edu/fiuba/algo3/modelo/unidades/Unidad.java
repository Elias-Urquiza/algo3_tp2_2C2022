package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;

public abstract class Unidad implements Objetivo {

    private Posicion pos;
    private int tiempoDeConstruccion;
    private int rango;

    public Unidad(Economia economia, int costoMineral, int costoGas, Posicion pos, int tiempoDeConstruccion, int rango) {
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
    }
    @Override
    public abstract int recibirDanio(int danio);
}
