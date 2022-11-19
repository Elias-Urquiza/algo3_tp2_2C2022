package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

import java.util.LinkedList;

public class UnidadManager {
    private LinkedList<Objetivo> objetivos;
    private LinkedList<UnidadProtoss> unidadesProtoss;
    private LinkedList<UnidadZerg> unidadesZerg;

    public void crearUnidadProtoss(Posicion pos, UnidadProtoss unidad) {
        unidadesProtoss.add(unidad);
    }

    public void crearUnidadZerg(Posicion pos, UnidadZerg unidad) {
        unidadesZerg.add(unidad);
    }
}
