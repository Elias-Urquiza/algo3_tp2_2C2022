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

public class ConstruccionProtoss implements Turno, Objetivo, Estructura {
    protected VidaProtoss vida;
    protected int costoMineral;
    protected int costoGas;
    protected int tiempoDeConstruccion;
    private static final int CURACION_PROTOSS = 100;
    protected Posicion pos;
    protected LinkedList<Class> correlativity;
    protected Tierra superficie;
    protected int turnos;
    protected boolean energizado;
    //PODRIAMOS HACER QUE EL PASAR TURNO DE CONSTRUCCION PROTOSSS SE CURE O REGENERE ESCUDO

    public ConstruccionProtoss(int puntosDeVidaMaxima, int escudoMaximo, int costoMineral, int costoGas, int tiempoDeConstruccion, Economia economia, Posicion pos, boolean energizado) {
        try {
            if (costoGas != 0){
                economia.gastarGasVespeno(costoGas);
            }
            if (costoMineral != 0){
                economia.gastarMineral(costoMineral);
            }
        } catch(final RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        this.costoMineral = costoMineral;
        this.costoGas = costoGas;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.pos = pos;
        this.energizado = energizado;
        this.vida = new VidaProtoss(puntosDeVidaMaxima, escudoMaximo);
        this.correlativity = new LinkedList<>();
        this.superficie = new Tierra(0, 0);
        this.turnos = 0;
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

    public int curar() {
        return vida.curar(CURACION_PROTOSS);
    }
    public void desactivar(){
        energizado = false;
    }
    public void activar(){
        energizado = true;
    }//a lo mejor usar interfaz

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

        for (Estructura p : lista) {
            match = correlativity.stream().anyMatch(any -> any.equals(p.getClass()));
            if(match)
                afirmacion = true;
        }

        if (afirmacion || correlativity.isEmpty())
            lista.add(this);
        else
            throw new RuntimeException("No existe su correlativa");

    }

    public void construida(){
        if(turnos < tiempoDeConstruccion) throw new RuntimeException("No se termino de construir el edificio");
    }

    @Override
    public int getVida() {
        return vida.getVida();
    }

    public void pasarTurno() {
        turnos++;
    }

    public Posicion getPosicion() {
        return pos;
    }

    @Override
    public void destruir(LinkedList<ConstruccionZerg> construccionesZerg, LinkedList<ConstruccionProtoss> construccionProtoss,LinkedList<ExtraeRecurso> extraeRecursos, FloorManager floorManager) {
        LinkedList<Estructura> list = (LinkedList<Estructura>) (List<?>)  construccionProtoss;
        vida.eliminarConstruccion(list, this);

        floorManager.desactivarEstructurasProtoss();
    }

    @Override
    public LinkedList<String> getInformacion() {
        LinkedList<String> list = new LinkedList();
        list.addAll(vida.getInformacion());
        try {
            construida();
            list.add("Edificio activo");
        } catch (RuntimeException e) {
            list.add(String.format("Turnos hasta activarse: %s", tiempoDeConstruccion-turnos));
        }
        list.add(energizado ? "Edificio energizado!" : "Edificio sin energia");
        list.add(String.format("Ubicado en: %s - %s", pos.getX(), pos.getY()));
        return list;
    }

}
