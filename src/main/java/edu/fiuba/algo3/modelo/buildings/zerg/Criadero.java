package edu.fiuba.algo3.modelo.buildings.zerg;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.FloorManager;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.tiles.Moho;

import java.util.LinkedList;

public class Criadero extends ConstruccionZerg implements Turno, Construccion {

    private int numeroDeLarvas;
    private int expansion;
    private Suministros suministrosZerg;
    private static final int MAX_LARVAS = 3;
    private FloorManager floorManager;

    public Criadero(Economia economia, Posicion pos) {
        super(500, 200, 0, 4, economia, pos);
        numeroDeLarvas = 3;
        expansion = 0;
        this.floorManager = null;
    }
    

    public void extraerLarvas(int quitarLarvas) throws RuntimeException {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0))
            throw new RuntimeException("Numero de Larvas incorrecto");
        if (turnos < tiempoDeConstruccion)
            throw new RuntimeException("Edificio en construccion");

        numeroDeLarvas -= quitarLarvas;
    }

    public void setFloorManager(FloorManager floorManager){ this.floorManager = floorManager; }
    public void setSuministrosZerg(Suministros suministros) {
        this.suministrosZerg = suministros;
    }

    public int preguntarTurno(){
        return turnos;
    }

    @Override
    public void pasarTurno() {
        turnos++;

        if(numeroDeLarvas < MAX_LARVAS) {
            numeroDeLarvas++;
        }

        if(turnos >= tiempoDeConstruccion && turnos%2 == 0) {
            floorManager.mohificar(this.pos, expansion);
            expansion += 1;
        }
        curar();
    }

    @Override
    public Boolean sePuedeDestruir(Posicion pos) {
        boolean afirmacion = false;

        if (pos.equals(this.pos)) {
            afirmacion = true;
            suministrosZerg.disminuirMaximo(5);
        }

        return afirmacion;
    }

    public void reponerLarva(){
        if(numeroDeLarvas < 3)
            numeroDeLarvas++;
        else
            throw new RuntimeException("no se pueden reponer una larva");
    }

    @Override
    public void usar() {

    }

    @Override
    public LinkedList<String> getInformacion() {
        LinkedList<String> list = super.getInformacion();
        list.add(String.format("Numero de larvas: %s", numeroDeLarvas));
        return list;
    }
    /*
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 M 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
          - 0 0 0 0 0 0 0 0
     */

}
