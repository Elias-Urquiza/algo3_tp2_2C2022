package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.Estructura;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.FloorManager;

import java.util.LinkedList;

public class Pilon extends ConstruccionProtoss implements Turno, Construccion {


    private static final int TIEMPO_CONSTRUCCION = 5;
    private FloorManager floorManager;
    private Suministros suministrosProtoss;

    private int id;

    public Pilon(Economia economia, Posicion pos) {
        super(350, 350, 100, 0, 5, economia, pos, true);
        turnos = 0;
        this.id = 0;
        this.floorManager = null;
        this.suministrosProtoss = null;
    }


    @Override
    public void pasarTurno() {
        curar();
        turnos++;

        if(turnos == tiempoDeConstruccion){
            floorManager.energizar(pos, id);
        }
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales
    }

    public void energizarDespuesDeEliminarUnPilon(){
        if(turnos >= tiempoDeConstruccion){
            floorManager.energizar(pos, id);
        }
    }

    @Override
    public void usar() {
        if (turnos < TIEMPO_CONSTRUCCION )
            throw new RuntimeException("Edificio en construccion");
    }


    @Override
    public Boolean sePuedeDestruir(Posicion pos) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            floorManager.desenergizar(pos, id);
            suministrosProtoss.disminuirMaximo(5);
            afirmacion = true;
        }
        return afirmacion;
    }

    public void setID(int idNuevo){
        id = idNuevo;
    }

    public void setFloorManager(FloorManager floorManager) {this.floorManager = floorManager;}
    public void setSuministrosProtoss(Suministros sum) {this.suministrosProtoss = sum;}

    @Override
    public void desactivar() {
        energizado = true;
    }

    public boolean seQuitaPilon(Posicion pos) {
        return pos.equals(this.pos);
    }
}
