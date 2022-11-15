package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.Objects;

public class Manager {
    LinkedList<ConstruccionZerg> construccionesZerg;
    LinkedList<ConstruccionProtoss> construccionProtoss;
    LinkedList<ExtraeRecurso> construccionQueExtrae;
    LinkedList<Moho> moho;
    LinkedList<Cristales> cristales;
    LinkedList<Volcan> volcanes;
    LinkedList<Energia> energias;
    LinkedList<TileVacia> tilesVacias;
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
        for (int i = 0; i < maxX; i ++) {
            for (int j = 0; j < maxY; j++) {
                tilesVacias.add(new TileVacia(new Posicion(i, j)));
            }
        }

    }

    public void construirCriaderoEn(Posicion pos, Criadero criadero) {
        buscarCoincidencias(pos);

        int size = construccionesZerg.size();
        for (TileVacia t : tilesVacias) {
            t.construir(construccionesZerg, criadero, pos);
        }
        if(size == construccionesZerg.size())
            throw new RuntimeException("No se puede construir en esta posicion");
        criadero.mohificar(pos, maxX, maxY, moho);
    }

    public void construirPilonEn(Posicion pos, Pilon pilon) {
        buscarCoincidencias(pos);

        int size = construccionProtoss.size();

        pilon.setID(idPilones);
        idPilones  ++;

        for (TileVacia t : tilesVacias) {
            t.construir(construccionProtoss, pilon, pos);
        }
        if(size == construccionProtoss.size())
            throw new RuntimeException("No se puede construir en esta posicion");

        pilon.energizar(pos, maxX, maxY, energias);

        activarEstructurasProtoss();
    }

    public void construirEstructuraDeCristales(Posicion pos, ExtraeRecurso extrae){
        buscarCoincidencias(pos);

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
        buscarCoincidencias(pos);
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

    public void buscarCoincidencias(Posicion posicion){
        for (ConstruccionProtoss c: construccionProtoss){
            Posicion posicionProtoss = c.getPosicion();
            if(posicionProtoss.equals(posicion)){
                throw new RuntimeException("Ya hay una construccion en esa posicion");
            }
        }

        for (ConstruccionZerg c: construccionesZerg){
            Posicion posicionZerg = c.getPosicion();
            if(posicionZerg.equals(posicion)){
                throw new RuntimeException("Ya hay una construccion en esa posicion");
            }
        }

        for (ExtraeRecurso ext : construccionQueExtrae){
            Posicion posicionExt = ext.getPosicion();
            if(posicionExt.equals(posicion)){
                throw new RuntimeException("Ya hay una construccion en esa posicion");
            }
        }

        // Habria que tener en cuenta las construcciones que extraen
    }

    public void construirProtoss(Posicion pos, ConstruccionProtoss protoss) {

        buscarCoincidencias(pos);

        int size = construccionProtoss.size();

        for(Energia e : energias) {
            e.construir(construccionProtoss, protoss, pos);
        }

        if(size == construccionProtoss.size()) {
            throw new RuntimeException("No esta energizada esta posicion");
        }


//        activarEstructurasProtoss();
    }

    public void destruirProtoss(Posicion pos) {
        int size = construccionProtoss.size();

        construccionProtoss.removeIf(construccion -> (construccion.destruir(pos, maxX, maxY, construccionProtoss) ) );

        desactivarEstructurasProtoss();

        if(size == construccionProtoss.size()) {
            throw new RuntimeException("No hay nada para destruir");
        }

    }

    public void construirZerg(Posicion pos, ConstruccionZerg zerg) {
        int size = construccionesZerg.size();

        for(Moho m : moho) {
            m.construir(construccionesZerg, zerg, pos);
        }

        if(size == construccionesZerg.size())
            throw new RuntimeException("No hay un moho en la posicion");
    }

    private void desactivarEstructurasProtoss(){
        int contador =0;

        for(ConstruccionProtoss c: construccionProtoss){
            for (Energia e: energias){
                if( (c.getPosicion()).equals(e.getPos()) )
                    contador ++;
            }
            if(contador == 0)//si no encontre ninguna coincidencia
                c.desactivar();

            contador = 0;
        }
    }

    private void activarEstructurasProtoss(){
        int contador =0;
        for(ConstruccionProtoss c: construccionProtoss){
            for (Energia e: energias){
                if( (c.getPosicion()) .equals(e.getPos()) )
                    contador ++;
            }
            if(contador != 0)//si no encontre ninguna coincidencia
                c.activar();

            contador = 0;
        }
    }

    private void quitarTilesVacias(){
        for(Moho m : moho){

        }
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
        cristales.add(new Cristales(pos));
    }

    public void agregarVolcanes(Posicion pos) {
        volcanes.add(new Volcan(pos));
    }
}
