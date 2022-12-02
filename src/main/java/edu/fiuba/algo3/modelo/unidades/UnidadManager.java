package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.Raza;

import java.util.HashMap;
import java.util.LinkedList;



public class UnidadManager {

    final HashMap<Raza, LinkedList> unidades;

    public UnidadManager(){
        unidades = new HashMap<>();
        unidades.put(Raza.PROTOSS, new LinkedList<Unidad>());
        unidades.put(Raza.ZERG, new LinkedList<Unidad>());
    }

    public void crearUnidad(Unidad unidad, Posicion pos) {
        unidad.setPosicion(pos);
        unidad.agregate(unidades);// se filtra por proto-zerg.
    }
    public void ejecutarComandoDeDaniar(Unidad agresor, Objetivo victima){
        agresor.atacar(victima);
    }

    public void moverUnidad(Unidad unaUnidad, Posicion nuevaPosicion, Boolean esVacio){
        unaUnidad.movete(nuevaPosicion, esVacio);
    }

    public  boolean posicionOcupada(Posicion pos){
        boolean afirmacion =  false;
        boolean ocupado = false;

        LinkedList<Unidad> zergs= unidades.get(Raza.ZERG);
        //System.out.println(zergs);
        for (Unidad u : zergs) {
            afirmacion = (u.getPosicion()).equals(pos);
            if (afirmacion)  ocupado = true;
        }
        LinkedList<Unidad> protoss= unidades.get(Raza.PROTOSS);
        for (Unidad u : protoss) {
            afirmacion = (u.getPosicion()).equals(pos);
            if (afirmacion)  ocupado = true;
        }
        return ocupado;
    }


}
