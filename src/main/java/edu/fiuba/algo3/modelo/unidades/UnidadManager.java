package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.LinkedList;

public class UnidadManager {

    final HashMap<TipoDeUnidades, LinkedList> unidades;

    public UnidadManager(){
        unidades = new HashMap<>();
        unidades.put(TipoDeUnidades.PROTOSS, new LinkedList<Unidad>());
        unidades.put(TipoDeUnidades.ZERG, new LinkedList<Unidad>());
    }

    public void crearUnidad(Unidad unidad) {

        unidad.agregate(unidades);// se filtra por tierra-aire y por proto-zerg.
    }

    public void ejecutarComandoDeDaniar(Unidad agresor, Objetivo victima){
        agresor.atacar(victima);
    }

    public void moverUnidad(Unidad unaUnidad, Posicion nuevaPosicion){
        unaUnidad.setPosicion(nuevaPosicion); //posicion x-y invalida entiendo no ocurriria. Problema debemos cheuqear
                                              //que no haya una consstruccion u otra unidad.
                                              //Y ver si la unidad vuela o no por si puede o no ir a un aerea espacial  o no.
                                              //de ser la unidad aerea hay que pensar que hacemos con
    }

}
