package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.VidaZerg;
import edu.fiuba.algo3.modelo.unidades.Objetivo;

import java.util.LinkedList;

public class ConstruccionZerg implements Turno, Objetivo {
    private int puntosDeVida;
    private int puntosDeVidaMaxima;
    private VidaZerg vida;
    private int costoMineral;
    private int costoGas;
    protected int tiempoDeConstruccion;
    private static final int CURACION_ZERG = 100;
    protected Posicion pos;


    public ConstruccionZerg(int puntosDeVidaMaxima, int costoMineral, int costoGas, int tiempoDeConstruccion, Economia economia,
                            Posicion pos) {
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
        this.vida = new VidaZerg(puntosDeVidaMaxima);
        this.costoGas = costoGas;
        this.costoMineral = costoMineral;
        this.pos = pos;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }

    public int curar() {
        return vida.curar(CURACION_ZERG);
    }

    @Override
    public int recibirDanio(int danio) {
        return vida.daniar(danio);
    }

    public Boolean destruir(Posicion pos) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            afirmacion = true;
        }

        return afirmacion;
    }

    public Posicion getPosicion() {
        return pos;
    }

    public void pasarTurno() {
    }
}
