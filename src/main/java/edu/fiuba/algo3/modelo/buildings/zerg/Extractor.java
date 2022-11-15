package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.tiles.Recurso;

public class Extractor extends ConstruccionZerg implements Construccion, Turno, ExtraeRecurso {

    private int turnosActivo;
    private int vida;
    private static final int MAX_LARVAS = 3;
    private static final int PRODUCCION_POR_ZANGANO=10;
    private int zanganos;
    private Economia economia;
    private Recurso recurso;
    private static final int TIEMPO_CONSTRUCCION = 6;

    public Extractor(Economia economiaZerg, Posicion pos){
        super(750, 100, 0, 6, economiaZerg, pos);
        turnosActivo = 0;
        economia = economiaZerg;
        zanganos = 0;
    }

    public void usar() {
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }
    }

    public void agregarZangano(Criadero unCriadero){ // AGREGA DE A UNO
        if(turnosActivo < TIEMPO_CONSTRUCCION){
            throw new RuntimeException("Edificio en construccion");
        }

        try{
            unCriadero.extraerLarvas(1);
        }catch (RuntimeException e){
            throw new RuntimeException("No se pudo agregar un zangano");
        }

        if(zanganos < MAX_LARVAS)
            zanganos++;
    }

    public Posicion getPosicion(){
        return pos;
    }

    @Override
    public void pasarTurno() {
        curar();
        if(turnosActivo >= TIEMPO_CONSTRUCCION){
            //Asumo que va sumando de a un por turno
            extraer();
        }
        turnosActivo++;
    }

    @Override
    public void extraer() {
        economia.ingresarGasVespeno(recurso.extraer(zanganos * PRODUCCION_POR_ZANGANO));
    }

    @Override
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}
