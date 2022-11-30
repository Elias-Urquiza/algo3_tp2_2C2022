package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.tiles.Vacio;
import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.LinkedList;



public class UnidadManager  {

    final HashMap<TipoDeUnidades, LinkedList> unidades;

    public UnidadManager(){
        unidades = new HashMap<>();
        unidades.put(TipoDeUnidades.PROTOSS, new LinkedList<Unidad>());
        unidades.put(TipoDeUnidades.ZERG, new LinkedList<Unidad>());
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

        LinkedList<Unidad> zergs= unidades.get(TipoDeUnidades.ZERG);
        //System.out.println(zergs);
        for (Unidad u : zergs) {
            afirmacion = (u.getPosicion()).equals(pos);
            if (afirmacion)  ocupado = true;
        }
        LinkedList<Unidad> protoss= unidades.get(TipoDeUnidades.PROTOSS);
        for (Unidad u : protoss) {
            afirmacion = (u.getPosicion()).equals(pos);
            if (afirmacion)  ocupado = true;
        }
        return ocupado;
    }

    public void hacerPasarDeTurno(){
        LinkedList<Unidad> zergs= unidades.get(TipoDeUnidades.ZERG);
        for (Unidad u :zergs)
            u.pasarTurno();

        LinkedList<Unidad> protoss= unidades.get(TipoDeUnidades.PROTOSS);
        for (Unidad u :protoss)
            u.pasarTurno();
    }

    public void chequeoEvolucion(UnidadZerg unidadAEvolucionar, UnidadZerg unidadEvolucionada){

        LinkedList<Unidad> lista = unidades.get(TipoDeUnidades.ZERG);
        Unidad zergAEliminar = null;
        Posicion posUnidadVieja = unidadAEvolucionar.getPosicion();
        boolean encontrado = false;

        for (Unidad zerg : lista ) {
            if (zerg.getPosicion().equals(posUnidadVieja) && !encontrado) {
                zergAEliminar = zerg;
                unidadEvolucionada.setPosicion(posUnidadVieja);
                encontrado =true;
            }
        }

        if(encontrado) {
            lista.remove(zergAEliminar);
            lista.add(unidadEvolucionada); //Agregue esto creo que esta bien?
        }else{
            throw new RuntimeException("La unidad que se desea evolucionar no existe");
        }
    }

}
