package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Stats {
    HashMap<Class, Integer> mapaUnidadesBuilt;
    HashMap<Class, Integer> mapaConstruccionesBuilt;
    int ataquesExitosos;
    int danioRealizado;
    int mineralGenerado;
    int gasVespenoGenerado;

    public void ingresoGas(int gas) {
        gasVespenoGenerado += gas;
    }

    public void ingresoMineral(int mineral) {
        mineralGenerado += mineral;
    }

    public Stats() {
        this.mapaUnidadesBuilt = new HashMap<>();
        this.mapaConstruccionesBuilt = new HashMap<>();
        this.ataquesExitosos = 0;
        this.danioRealizado = 0;
        this.mineralGenerado = 0;
        this.gasVespenoGenerado = 0;
    }
    public void realizoDanio(int danio) {
        ataquesExitosos++;
        danioRealizado += danio;
    }

    public void construyoUnidad(Unidad u) {
        int value = mapaUnidadesBuilt.getOrDefault(u.getClass(), 0);
        mapaUnidadesBuilt.put(u.getClass(), value+1);
    }

    public void construyoConstruccion(Object o) {
        int value = mapaConstruccionesBuilt.getOrDefault(o.getClass(), 0);
        mapaConstruccionesBuilt.put(o.getClass(), value+1);
    }

    public LinkedList<String> getInformacion() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Edificaciones construidas:");
        mapaConstruccionesBuilt.forEach((k, v) -> {
            list.add(String.format("    %s: %s", k.getSimpleName(), v));
        });
        list.add("Unidades creadas:");
        mapaUnidadesBuilt.forEach((k, v) -> {
            list.add(String.format("    %s: %s", k.getSimpleName(), v));
        });
        list.add(String.format("Danio realizado: %s", danioRealizado));
        list.add(String.format("Ataques exitosos: %s", ataquesExitosos));
        return list;
    }
}