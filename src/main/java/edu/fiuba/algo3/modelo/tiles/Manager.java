package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.unidades.Objetivo;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadManager;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

import java.util.LinkedList;
import java.util.Objects;

public class Manager {
    FloorManager floorManager;
    UnidadManager unidadManager;
    LinkedList<ConstruccionZerg> construccionesZerg;
    LinkedList<ConstruccionProtoss> construccionProtoss;
    LinkedList<ExtraeRecurso> construccionQueExtrae;
    LinkedList<Moho> moho;
    LinkedList<Cristales> cristales;
    LinkedList<Volcan> volcanes;
    LinkedList<Energia> energias;
    LinkedList<TileVacia> tilesVacias;
    LinkedList<Vacio> tilesDeVacios;
    int maxX;
    int maxY;
    int idPilones;

    public Manager(int dimensionX, int dimensionY) {
        this.construccionesZerg =new LinkedList<>();
        this.construccionProtoss = new LinkedList<>();
        this.construccionQueExtrae = new LinkedList<>();
        this.moho = new LinkedList<>();
        this.cristales = new LinkedList<>();
        this.volcanes  = new LinkedList<>();
        this.energias = new LinkedList<>();
        this.tilesVacias = new LinkedList<>();
        this.maxX = dimensionX;
        this.maxY = dimensionY;
        this.idPilones = 0;
        floorManager = new FloorManager(moho, cristales, volcanes, energias, tilesVacias, construccionesZerg, construccionProtoss, construccionQueExtrae, tilesDeVacios, dimensionX, dimensionY);
        unidadManager = new UnidadManager();
        this.tilesDeVacios = new LinkedList<>();

        floorManager.ponerVacio(tilesDeVacios, dimensionX, dimensionY);

        for (int i = 0; i < maxX; i ++) {
            for (int j = 0; j < maxY; j++) {
                Posicion pos = new Posicion(i,j);
                if(floorManager.sinVacio(pos,dimensionX, dimensionY))
                    tilesVacias.add(new TileVacia(pos) );
            }
        }

    }

    public void construirCriaderoEn(Posicion pos, Criadero criadero) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        criadero.setFloorManager(floorManager);
        int size = construccionesZerg.size();

        floorManager.buscarCoincidencias(pos);

        for (TileVacia t : tilesVacias) {
            t.construir(construccionesZerg, criadero, pos);
        }
        if(size == construccionesZerg.size()) {
            for(Moho m : moho)//porque puedo tranquilamente construir un criadero sobre moho
                m.construir(construccionesZerg, criadero, pos);

            if(size == construccionesZerg.size())
                throw new RuntimeException("No se puede construir en esta posicion");

        }
    }

    public void construirPilonEn(Posicion pos, Pilon pilon) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");


        pilon.setFloorManager(floorManager);
        int size = construccionProtoss.size();
        pilon.setID(idPilones);

        floorManager.buscarCoincidencias(pos);

        for (TileVacia t : tilesVacias)
            t.construir(construccionProtoss, pilon, pos);

        if(size == construccionProtoss.size()) {
            for(Energia e : energias)//porque puedo tranquilamente construir un pilon sobre energia
                e.construir(construccionesZerg, pilon, pos);

            if(size == construccionProtoss.size())
                throw new RuntimeException("No se puede construir en esta posicion");
        }
        idPilones  ++;
    }

    public void construirEstructuraDeCristales(Posicion pos, ExtraeRecurso extrae){

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");


        floorManager.buscarCoincidencias(pos);
        int size = construccionQueExtrae.size();

        for(Cristales c : cristales) {
            Recurso recurso = c.construir(construccionQueExtrae, extrae, pos);
            if(Objects.nonNull(recurso)) {
                extrae.setRecurso(c);
                break;
            }
        }

        if(size == construccionQueExtrae.size())
            throw new RuntimeException("No hay un mineral en la posicion");
    }

    public void construirEstructuraDeVolcan(Posicion pos, ExtraeRecurso extrae){

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");


        floorManager.buscarCoincidencias(pos);
        int size = construccionQueExtrae.size();
        for(Volcan v : volcanes) {
            Recurso recurso = v.construir(construccionQueExtrae, extrae, pos);
            if(Objects.nonNull(recurso)) {
                extrae.setRecurso(v);
                break;
            }
        }
        if(size == construccionQueExtrae.size())
            throw new RuntimeException("No hay un volcan en la posicion");
    }

    public LinkedList<TileVacia> getTilesVacias(){
        return tilesVacias;
    }

    public LinkedList<Moho> getMohos(){
        return moho;
    }

    public LinkedList<Energia> getEnergias(){
        return energias;
    }

    public void construirProtoss(Posicion pos, ConstruccionProtoss protoss) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        floorManager.buscarCoincidencias(pos);

        int size = construccionProtoss.size();

        for(Energia e : energias) {
            try {
                e.construir(construccionProtoss, protoss, pos);
            } catch (RuntimeException err1) {
                throw err1;
            }
        }
        if(size == construccionProtoss.size())
            throw new RuntimeException("Este piso no esta energizado");
    }

    public void destruirProtoss(Posicion pos) {
        int size = construccionProtoss.size();

        construccionProtoss.removeIf(construccion -> (construccion.destruir(pos) ) );

        floorManager.desactivarEstructurasProtoss();
        if(size == construccionProtoss.size()) {
            throw new RuntimeException("No hay nada para destruir");
        }

    }

    public void destruirZerg(Posicion pos) {
        int size = construccionesZerg.size();

        construccionesZerg.removeIf(construccion -> (construccion.destruir(pos) ) );

        if(size == construccionesZerg.size()) {
            throw new RuntimeException("No hay nada para destruir");
        }

    }

    public void construirZerg(Posicion pos, ConstruccionZerg zerg) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        floorManager.buscarCoincidencias(pos);

        int size = construccionesZerg.size();

        for(Moho m : moho) {
            try {
                m.construir(construccionesZerg, zerg, pos);
            }catch (RuntimeException err2){
                throw err2;
            }
        }
        if(size == construccionesZerg.size())
            throw new RuntimeException("Este piso no tiene moho");
    }

    public void crearUnidad(Posicion posConstruccion, Unidad unidad){
        Posicion pos;
        boolean accionRealizada = false;

        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                pos = posConstruccion.incrementar(i, j, maxX, maxY);

                try {
                    floorManager.buscarCoincidenciasUnidades(pos);
                }catch (RuntimeException e){
                    continue;
                }

                if(floorManager.conVacio(pos, maxX, maxY) )
                    continue;

                if(unidadManager.posicionOcupada(pos))
                    continue;

                if(!accionRealizada) {
                    unidadManager.crearUnidad(unidad, pos);
                    accionRealizada = true;
                }
            }
        }
    }

    public void evolucionar(UnidadZerg unidadAEvolucionar, UnidadZerg unidadEvolucionada){
        unidadManager.chequeoEvolucion(unidadAEvolucionar, unidadEvolucionada);
    }

    public void moverUnidad(Posicion pos, Unidad unidad) {
        try {
            floorManager.buscarCoincidenciasUnidades(pos);
        }catch (RuntimeException e){
            return;
        }
        unidadManager.moverUnidad(unidad, pos, (floorManager.conVacio(pos, maxX, maxY) ));
    }

    public void unidadAtaca(Unidad unaUnidad, Objetivo unObjetivo){
        unidadManager.ejecutarComandoDeDaniar(unaUnidad, unObjetivo);
    }

    /*
    public void printMohos() {
        char[][] matrix = new char[maxX][maxY];
        for (int i =0; i < maxX; i++ ){
            for(int j =0; j < maxY; j++ ){
                matrix[i][j]='-';
            }
        }
        for(Moho m : moho){
            matrix[m.getX()][m.getY()] = 'm';
        }
        for (int i =0; i < maxX; i++ ){
            for(int j =0; j < maxY; j++ ){
                System.out.print(matrix[i][j]);
            }
            System.out.println("\n");
        }
    }

    public void printEnergias() {
        char[][] matrix = new char[maxX][maxY];
        for (int i =0; i < maxX; i++ ){
            for(int j =0; j < maxY; j++ ){
                matrix[i][j]='-';
            }
        }
        for(Energia e : energias){
            matrix[e.getPos().getX()][e.getPos().getY()] = 'e';
        }
        for (int i =0; i < maxX; i++ ){
            for(int j =0; j < maxY; j++ ){
                System.out.print(matrix[i][j]);
            }
            System.out.println("\n");
        }
    }*/

    public void agregarCristales(Posicion pos) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        cristales.add(new Cristales(pos));
        floorManager.quitarTilesVaciasParaCristales();
    }

    public void agregarVolcanes(Posicion pos) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        volcanes.add(new Volcan(pos));
        floorManager.quitarTilesVaciasParaVolcanes();
    }

    public void pasarTurno(){
        for(ConstruccionProtoss protoss :construccionProtoss)
            protoss.pasarTurno();

        for (ConstruccionZerg zerg : construccionesZerg)
            zerg.pasarTurno();

        for (ExtraeRecurso extrae : construccionQueExtrae)
            extrae.pasarTurno();

        unidadManager.hacerPasarDeTurno();
    }
}
