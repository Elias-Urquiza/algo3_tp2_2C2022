package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.tiles.Cristales;
import edu.fiuba.algo3.modelo.tiles.Recurso;
import edu.fiuba.algo3.modelo.unidades.Tierra;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

import java.util.LinkedList;

public class Zangano extends UnidadZerg implements Turno, ExtraeRecurso{

    private int vida;
    private static final int PRODUCCION_POR_ZANGANO=10;
    private Economia economia;
    private Recurso recurso;

    public Zangano(Economia economiaZerg, Posicion pos) {
        super(25, 25, 0, economiaZerg, pos, 1, 0, new Tierra(0, 0), new Tierra(0, 0), 1);
        this.economia = economiaZerg;
        ataques.add(new Tierra(0, 0));
        turnos = 0;
    }

    public Posicion getPosicion(){
        return pos;
    }

    @Override
    public void extraer() {
        economia.ingresarGasVespeno(recurso.extraer(PRODUCCION_POR_ZANGANO));
    }

    @Override
    public void setRecurso(Recurso recurso) {
        //Solo puede recibir un cristal
        this.recurso = recurso;
    }

    @Override
    public void agregaZangano(LinkedList<Zangano> posiblesZanganos){
        posiblesZanganos.add(this);
    }

    public void extraerMineral(Cristales cristal){
        if(turnos >= tiempoDeConstruccion)
            economia.ingresarMineral(cristal.extraer(PRODUCCION_POR_ZANGANO));
    }

    public void construida(){
    }

}
