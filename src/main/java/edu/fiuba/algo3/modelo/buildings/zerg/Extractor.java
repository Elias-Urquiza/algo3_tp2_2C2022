package edu.fiuba.algo3.modelo.buildings.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.tiles.FloorManager;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.tiles.Recurso;

import java.util.LinkedList;

public class Extractor extends ConstruccionZerg implements Construccion, Turno, ExtraeRecurso {

    private int vida;
    private static final int MAX_LARVAS = 3;
    private static final int PRODUCCION_POR_ZANGANO = 10;
    private LinkedList<Zangano> zanganos;
    private Economia economia;
    private Recurso recurso;
    private static final int TIEMPO_CONSTRUCCION = 6;
    private Manager manager;

    public Extractor(Economia economiaZerg, Posicion pos) {
        super(750, 100, 0, 6, economiaZerg, pos);
        economia = economiaZerg;
        zanganos = new LinkedList<Zangano>();
        this.manager = null;
    }

    public void usar() {
        if (turnos < TIEMPO_CONSTRUCCION) {
            throw new RuntimeException("Edificio en construccion");
        }
    }

    public void agregarZangano(Manager manager) {
        if (turnos < TIEMPO_CONSTRUCCION) {
            throw new RuntimeException("Edificio en construccion");
        }

        if (zanganos.size() < MAX_LARVAS) {
            try {
                Zangano zangano = new Zangano(economia, pos);
                zanganos.add(zangano);
                manager.crearZanganoParaExtractor(this.pos, zangano);
                this.manager = manager;
            } catch (RuntimeException e) {
                throw new RuntimeException("No se pudo agregar un zangano");
            }
        }
    }
// si se destruye el extractor deben morirse los zanganos que en el estaban

    @Override
    public void destruir(LinkedList<ConstruccionZerg> construccionesZerg, LinkedList<ConstruccionProtoss> construccionProtoss, LinkedList<ExtraeRecurso> extraeRecursos,FloorManager floorManager) {

        int size = extraeRecursos.size();

        extraeRecursos.removeIf(construccion -> (construccion.getPosicion().equals(pos) ) );
        if(size == extraeRecursos.size()) {
            throw new RuntimeException("No hay nada para destruir");
        }
        else{
            manager.destruirZanganosDeExtractor(zanganos);
        }
    }

    public Posicion getPosicion(){
        return pos;
    }

    @Override
    public void pasarTurno() {
        curar();
        if(turnos >= TIEMPO_CONSTRUCCION){
            //Asumo que va sumando de a un por turno
            extraer();
        }
        turnos++;
    }

    @Override
    public void extraer() {
        economia.ingresarGasVespeno(recurso.extraer(zanganos.size() * PRODUCCION_POR_ZANGANO));
    }

    @Override
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}
