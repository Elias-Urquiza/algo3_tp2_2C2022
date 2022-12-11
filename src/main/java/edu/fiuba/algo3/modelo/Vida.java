package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.buildings.Estructura;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.LinkedList;

public abstract class Vida {
    public int puntosDeVida;
    public int puntosDeVidaMaxima;

    public Vida(int puntosDeVidaMaxima) {
        this.puntosDeVidaMaxima = puntosDeVidaMaxima;
        this.puntosDeVida = puntosDeVidaMaxima;
    }

    public void eliminarUnidad(LinkedList<Unidad> listaUnidades, Unidad aEliminar){
        listaUnidades.removeIf(unidad -> unidad.getPosicion().equals( aEliminar.getPosicion() ) && puntosDeVida <= 0 );
    }

    public void eliminarConstruccion(LinkedList<Estructura> listaDeEstructuras, Estructura aEliminar){
        listaDeEstructuras.removeIf(edificio -> edificio.getPosicion().equals( aEliminar.getPosicion() ) && puntosDeVida <= 0  );
    }

    public abstract int daniar(int danio);
    public abstract int curar(int curacion);
}
