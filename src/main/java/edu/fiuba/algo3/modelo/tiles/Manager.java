package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;

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

    public Manager(int dimensionX, int dimensionY) {
        this.construccionesZerg =new LinkedList<>();
        this.construccionProtoss = new LinkedList<>();
        this.construccionQueExtrae = new LinkedList<>();
        this.moho = new LinkedList<>();
        this.cristales= new LinkedList<>();
        this.volcanes = new LinkedList<>();
        this.energias = new LinkedList<>();
        this.tilesVacias = new LinkedList<>();
        this.maxX = dimensionX;
        this.maxY = dimensionY;
        for (int i = 0; i < maxX; i ++) {
            for (int j = 0; j < maxY; j++) {
                tilesVacias.add(new TileVacia(i, j));
            }
        }
    }

    public void construirCriaderoEn(Posicion pos, Criadero criadero) {
        int size = construccionesZerg.size();
        for (TileVacia t : tilesVacias) {
            t.construir(construccionesZerg, criadero, pos);
        }
        if(size == construccionesZerg.size())
            throw new RuntimeException("No se puede construir en esta posicion");
        criadero.mohificar(pos, maxX, maxY, moho);
    }

    public void construirPilonEn(Posicion pos, Pilon pilon) {
        int size = construccionProtoss.size();
        for (TileVacia t : tilesVacias) {
            t.construir(construccionProtoss, pilon, x, y);
        }
        if(size == construccionProtoss.size())
            throw new RuntimeException("No se puede construir en esta posicion");
        pilon.energizar(x, y, maxX, maxY, energias);
    }

    public void construirEstructuraDeCristales(Posicion pos, ExtraeRecurso extrae){
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

    public void construirEstructuraDeVolcan(int x, int y, ExtraeRecurso extrae){
        int size = construccionQueExtrae.size();
        for(Volcan v : volcanes) {
            Recurso recurso = v.construir(construccionQueExtrae, extrae, x, y);
            if(Objects.nonNull(recurso)) {
                extrae.setRecurso(v);
                break;
            }
        }
        if(size == construccionQueExtrae.size())
            throw new RuntimeException("No hay un volcan en la posicion");
    }

    public void construirProtoss(int x, int y, ConstruccionProtoss protoss) {
        int size = construccionProtoss.size();
        for(Energia e : energias) {
            e.construir(construccionProtoss, protoss, x, y);
        }
        if(size == construccionProtoss.size())
            throw new RuntimeException("No esta energizada esta posicion");
    }

    public void destruirProtoss(Posicion pos) {
        // TODO: Refactor with hash maps
        /*
        int size = construccionProtoss.size();
        LinkedList<ConstruccionProtoss> clone = (LinkedList<ConstruccionProtoss>) construccionProtoss.clone();
        for(ConstruccionProtoss c : clone) {
            c.destruir(pos, construccionProtoss);
        }
        if(size == construccionProtoss.size())
            throw new RuntimeException("No hay nada para destruir");

         */
    }

    public void construirZerg(Posicion pos, ConstruccionZerg zerg) {
        int size = construccionesZerg.size();
        for(Moho m : moho) {
            m.construir(construccionesZerg, zerg, x, y);
        }
        if(size == construccionesZerg.size())
            throw new RuntimeException("No hay un moho en la posicion");
    }

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
    }

    public void agregarCristales(int x, int y) {
        cristales.add(new Cristales(x, y));
    }

    public void agregarVolcanes(int x, int y) {
        volcanes.add(new Volcan(x, y));
    }
}
