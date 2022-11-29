package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.VidaZerg;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.Tierra;

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
    protected LinkedList<Class> correlativity;
    private Ataque superficie;


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
        this.correlativity = new LinkedList<>();
        superficie = new Tierra(0);
    }

    public int curar() {
        return vida.curar(CURACION_ZERG);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque) {
        if(tipoDeAtaque.equals(superficie)) {
            return vida.daniar(danio);
        }
        return 0;
    }

    public Boolean destruir(Posicion pos) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            afirmacion = true;
        }

        return afirmacion;
    }

    public void chequearCorrelatividad(LinkedList<ConstruccionZerg> lista) {
        boolean match = false;
        boolean afirmacion = false;

        for (ConstruccionZerg z : lista) {
            match = correlativity.stream().anyMatch(any -> any.equals(z.getClass()));
            if(match)
                afirmacion = true;
        }

        if (afirmacion || correlativity.isEmpty())
            lista.add(this);
        else
            throw new RuntimeException("No existe su correlativa");

    }

    public Posicion getPosicion() {
        return pos;
    }

    public void pasarTurno() {
    }
}
