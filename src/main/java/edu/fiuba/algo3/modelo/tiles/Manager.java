package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
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
    }


    public void construirCriaderoEn(int x, int y, Criadero criadero) {
        criadero.mohificar(x, y, maxX, maxY, moho);
        construccionesZerg.add(criadero);
    }

    public void construirPilonEn(int x, int y, Pilon pilon) {
        pilon.energizar(x, y, maxX, maxY, energias);
        construccionProtoss.add(pilon);
    }

    public void construirEstructuraDeCristales(int x, int y, ExtraeRecurso extrae){
        int size = construccionQueExtrae.size();
        for(Cristales c : cristales) {
            Recurso recurso = c.construir(construccionQueExtrae, extrae, x, y);
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

    public void construirZerg(int x, int y, ConstruccionZerg zerg) {
        int size = construccionesZerg.size();
        for(Moho m : moho) {
            m.construir(construccionesZerg, zerg, x, y);
        }
        if(size == construccionesZerg.size())
            throw new RuntimeException("No hay un moho en la posicion");
    }

    public void printMohos() {
        char[][] matrix = new char[30][30];

        for (int i =0; i < 30; i++ ){
            for(int j =0; j < 30; j++ ){
                matrix[i][j]='-';
            }
        }
        for(Moho m : moho){
            matrix[m.getX()][m.getY()] = 'm';
        }
        for (int i =0; i < 30; i++ ){
            for(int j =0; j < 30; j++ ){
                System.out.print(matrix[i][j]);
            }
            System.out.println("\n");
        }
    }
    public void buscarCoincidencias(int CoordenadaX, int CoordenadaY){
        for(ConstruccionProtoss cp: construccionProtoss){
            cp
        }
    }
}
