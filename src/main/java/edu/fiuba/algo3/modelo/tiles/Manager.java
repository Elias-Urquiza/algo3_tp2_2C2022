package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.Asimilador;
import edu.fiuba.algo3.modelo.buildings.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.*;

import java.util.LinkedList;

public class Manager {
    LinkedList<ConstruccionZerg> construccionesZerg;
    LinkedList<ConstruccionProtoss> construccionProtoss;
    LinkedList<Moho> moho;
    LinkedList<Cristales> cristales;
    LinkedList<Volcan> volcanes;
    LinkedList<Energia> energias;
    LinkedList<TileVacia> tilesVacias;


    public Manager() {
        this.construccionesZerg =new LinkedList<>();
        this.construccionProtoss = new LinkedList<>();
        this.moho = new LinkedList<>();
        this.cristales= new LinkedList<>();
        this.volcanes = new LinkedList<>();
        this.energias = new LinkedList<>();
        this.tilesVacias = new LinkedList<>();
    }

    public void construirCriaderoEn(int x, int y, Economia economia) {
        construccionesZerg.add(new Criadero(economia, x, y));
        moho.add(new Moho(x, y));
    }

    public void construirExtractorEn(int x, int y, Economia economia) {
        Extractor extr = new Extractor(economia, x, y);
        int size = construccionesZerg.size();

        for(Volcan v : volcanes) {
            v.construir(construccionesZerg, extr, x, y);
        }

        if(size == construccionesZerg.size())
            throw new RuntimeException("No hay un volcan en la posicion");
    }

    public void construirEspiralEn(int x, int y, Economia economia) {
        Espiral espiral = new Espiral(economia, x, y);
        int size = construccionesZerg.size();

        for(Moho m : moho) {
            m.construir(construccionesZerg, espiral, x, y);
        }

        if(size == construccionesZerg.size())
            throw new RuntimeException("No hay un moho en la posicion");
    }

    public void construirGuaridaEn(int x, int y, Economia economia) {
        Guarida guarida = new Guarida(economia, x, y);
        int size = construccionesZerg.size();

        for(Moho m : moho) {
            m.construir(construccionesZerg, guarida, x, y);
        }

        if(size == construccionesZerg.size())
            throw new RuntimeException("No hay un moho en la posicion");
    }

    public void construirReservaDeReproduccionEn(int x, int y, Economia economia) {
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(economia, x, y);
        int size = construccionesZerg.size();

        for(Moho m : moho) {
            m.construir(construccionesZerg, reservaDeReproduccion, x, y);
        }

        if(size == construccionesZerg.size())
            throw new RuntimeException("No hay un moho en la posicion");
    }

    public void construirAsimiladorEn(int x, int y, Economia economia) {
        Asimilador asimilador = new Asimilador(economia, x, y);
        int size = construccionProtoss.size();

        for(Volcan v : volcanes) {
            v.construir(construccionProtoss, asimilador, x, y);
        }

        if(size == construccionProtoss.size())
            throw new RuntimeException("No hay un volcan en la posicion");
    }

    public void construirNexoMineralEn(int x, int y, Economia economia) {
        NexoMineral asimilador = new NexoMineral(economia, x, y);
        int size = construccionProtoss.size();

        for(Cristales c : cristales) {
            c.construir(construccionProtoss, asimilador, x, y);
        }

        if(size == construccionProtoss.size())
            throw new RuntimeException("No hay un mineral en la posicion");
    }

    public void construirAccesoEn(int x, int y, Economia economia) {
        Acceso acceso = new Acceso(economia, x, y);
        int size = construccionProtoss.size();

        for(Energia e : energias) {
            e.construir(construccionProtoss, acceso, x, y);
        }

        if(size == construccionProtoss.size())
            throw new RuntimeException("No esta energizada esta posicion");
    }

    public void construirPuertoEstelarEn(int x, int y, Economia economia) {
        PuertoEstelar puertoEstelar = new PuertoEstelar(economia, x, y);
        int size = construccionProtoss.size();

        for(Energia e : energias) {
            e.construir(construccionProtoss, puertoEstelar, x, y);
        }

        if(size == construccionProtoss.size())
            throw new RuntimeException("No esta energizada esta posicion");
    }

}
