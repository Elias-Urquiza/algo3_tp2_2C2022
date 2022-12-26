package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;

import java.util.LinkedList;

public class Tierra implements Ataque, Movimiento {

    private static String nombre = "tierra";
    private int danio;
    private int rango;
    public Tierra(int danio, int rango){
        this.danio = danio;
        this.rango = rango;
    }

    @Override
    public int atacar(Objetivo objetivo, Posicion posicionDeAtacante) {
        return objetivo.recibirDanio(danio, this, posicionDeAtacante);
    }

    @Override
    public Posicion moverse(Boolean esVacio, Posicion posNueva, Posicion posVieja){
        if(!esVacio)
           return posNueva;

        return posVieja;
    }

    @Override
    public boolean es(Ataque ataque) {
        return nombre.equals(ataque.getNombre());
    }

    @Override
    public boolean es(Movimiento mov) {
        return nombre.equals(mov.getNombre());
    }

    @Override
    public boolean inRange(Posicion posicionAtacante, Posicion posicionObjetivo) {
        return posicionObjetivo.estaEnRangoDe(posicionAtacante, rango);
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
