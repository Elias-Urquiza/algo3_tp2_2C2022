package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Posicion;

public class Vacio {

    //suponemos que no se puede construir sobre vacio. se generan en el medio del mapa.
    // sirve solo para ser transitado por unidades aereas.
    private Posicion posicion;

    public Vacio(Posicion posicion){
        this.posicion = posicion;
    }

    public Posicion getPos() {
        return posicion;
    }



}
