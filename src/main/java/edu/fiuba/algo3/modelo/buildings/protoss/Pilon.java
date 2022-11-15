package edu.fiuba.algo3.modelo.buildings.protoss;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.FloorManager;

import java.util.LinkedList;

public class Pilon extends ConstruccionProtoss implements Turno, Construccion {
    private int turnosActivo;

    private static final int TIEMPO_CONSTRUCCION = 5;
    private FloorManager floorManager;

    private int id;

    public Pilon(Economia economia, Posicion pos) {
        super(350, 350, 100, 0, 5, economia, pos, true);
        turnosActivo = 0;
        this.id = 0;
        this.floorManager = null;
    }


    @Override
    public void pasarTurno() {
        curar();
        turnosActivo++;
        //no se como implementar que sume 20 de gas por tiempo, Si el gas es guardado en minerales
    }

    @Override
    public void usar() {
        if (turnosActivo < TIEMPO_CONSTRUCCION && energizado)
            throw new RuntimeException("Edificio en construccion");
    }


    @Override
    public Boolean destruir(Posicion pos, int maxX, int maxY, LinkedList<ConstruccionProtoss> construccionProtoss) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            floorManager.desenergizar(maxX, maxY, pos, id);
            afirmacion = true;
        }
        return afirmacion;
    }

    public void setID(int idNuevo){
        id = idNuevo;
    }

    public void setFloorManager(FloorManager manager) {floorManager = manager;}

    @Override
    public void desactivar() {
        energizado = true;
    }
}
