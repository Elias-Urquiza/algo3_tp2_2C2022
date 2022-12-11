package edu.fiuba.algo3.modelo.buildings;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.FloorManager;
import edu.fiuba.algo3.modelo.unidades.Ataque;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.Tierra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConstruccionZerg implements Turno, Objetivo, Estructura {
    protected VidaZerg vida;
    private int costoMineral;
    private int costoGas;
    protected int tiempoDeConstruccion;

    protected int turnos;
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
        superficie = new Tierra(0, 0);
        this.turnos = 0;
    }

    public int curar() {
        return vida.curar(CURACION_ZERG);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion posicionAtacante) {
        if(tipoDeAtaque.equals(superficie) && tipoDeAtaque.inRange(pos, posicionAtacante)) {
            return vida.daniar(danio);
        }
        return 0;
    }

    @Override
    public void morirUnidad(HashMap<Raza, LinkedList> unidades) {
        return;
    }

    public void construida(){
        if(turnos < tiempoDeConstruccion) throw new RuntimeException("No se termino de construir el edificio");
    }

    public Boolean sePuedeDestruir(Posicion pos) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            afirmacion = true;
        }

        return afirmacion;
    }

    public void chequearCorrelatividad(LinkedList<Estructura> lista) {
        boolean match = false;
        boolean afirmacion = false;

        for (Estructura z : lista) {
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
        turnos++;
    }


    @Override
    public void destruir(LinkedList<ConstruccionZerg> construccionesZerg, LinkedList<ConstruccionProtoss> construccionProtoss, LinkedList<ExtraeRecurso> extraeRecursos, FloorManager floorManager) {
        LinkedList<Estructura> list = (LinkedList<Estructura>) (List<?>)  construccionesZerg;
        vida.eliminarConstruccion(list, this);
    }

}
