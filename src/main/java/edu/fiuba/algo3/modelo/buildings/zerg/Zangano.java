package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.tiles.Recurso;

public class Zangano extends ConstruccionProtoss implements Turno, Construccion, ExtraeRecurso {

    private int vida;
    private static final int PRODUCCION_POR_ZANGANO=10;
    private Economia economia;
    private Recurso recurso;


    public Zangano(Economia economiaZerg, Posicion pos, Criadero unCriadero){
        try{
            unCriadero.extraerLarvas(1);
        }catch (RuntimeException e){
            throw new RuntimeException("No se pudo posicionar un zangano");
        }
        super(25, 0, 25, 6, economiaZerg, pos);
        economia = economiaZerg;
    }

    public Posicion getPosicion(){
        return pos;
    }


    @Override
    public void pasarTurno() {
        curar();
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



}
