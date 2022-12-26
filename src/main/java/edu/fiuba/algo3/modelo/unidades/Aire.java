package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

import java.util.LinkedList;

public class Aire implements Ataque, Movimiento {

    private static String nombre = "Aire";
    private int danio;
    private int rango;
    public Aire(int danio, int rango){
        this.rango = rango;
        this.danio = danio;
    }

    @Override
    public int atacar(Objetivo objetivo, Posicion atacante) {
        return objetivo.recibirDanio(danio, this, atacante);
    }

    @Override
    public boolean es(Ataque ataque){
        return nombre.equals(ataque.getNombre());
    }

    @Override
    public boolean es(Movimiento movimiento){
        return nombre.equals(movimiento.getNombre());
    }

    @Override
    public boolean inRange(Posicion posicionAtacante, Posicion posicionObjetivo) {
        return posicionObjetivo.estaEnRangoDe(posicionAtacante, rango);
    }

    @Override
    public Posicion moverse(Boolean esVacio, Posicion posNueva, Posicion posVieja){
        return posNueva;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    @Override
    public LinkedList<String> getInformacion() {
        LinkedList<String> list = new LinkedList<>();
        list.add(String.format("El ataque por %s tiene\n%s de rango y %s de daño", getNombre(), rango, danio));
        return list;
    }
}
