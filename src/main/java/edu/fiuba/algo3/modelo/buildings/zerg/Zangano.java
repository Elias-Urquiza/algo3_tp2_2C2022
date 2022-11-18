package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.tiles.Recurso;

public class Zangano extends ConstruccionZerg implements Construccion, Turno, ExtraeRecurso{

    private int vida;
    private static final int PRODUCCION_POR_ZANGANO=10;
    private Economia economia;
    private Recurso recurso;


    public Zangano(Economia economiaZerg, Posicion pos, Criadero unCriadero){
        super(25, 0, 25, 0, economiaZerg, pos);
        // el super tendra que ser despues de que se verifique si se puede extraer larva
        try{
            unCriadero.extraerLarvas(1);
        }catch (RuntimeException e){
            throw new RuntimeException("No se pudo posicionar un zangano");
        }
        economia = economiaZerg;
    }

    public Posicion getPosicion(){
        return pos;
    }

    public void usar() {
        //Se necesita???
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
