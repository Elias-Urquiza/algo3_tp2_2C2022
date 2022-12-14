package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Suministros;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.HashMap;
import java.util.LinkedList;



public class UnidadManager  {

    final HashMap<Raza, LinkedList> unidades;

    public UnidadManager(){
        unidades = new HashMap<>();
        unidades.put(Raza.PROTOSS, new LinkedList<UnidadProtoss>());
        unidades.put(Raza.ZERG, new LinkedList<UnidadZerg>());
    }

    public void crearUnidad(Unidad unidad, Posicion pos, HashMap<Raza, Suministros> suministros) throws RuntimeException {
        unidad.setPosicion(pos);
        unidad.agregate(unidades, suministros);// se filtra por proto-zerg.
    }

    public int ejecutarComandoDeDaniar(Unidad agresor, Objetivo victima){
        int dmg = agresor.atacar(victima);
        victima.morirUnidad(unidades);
        return dmg;
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

    public void hacerPasarDeTurnoZerg(){
        LinkedList<Unidad> zergs= unidades.get(Raza.ZERG);
        for (Unidad u :zergs)
            u.pasarTurno();
    }

    public void hacerPasarDeTurnoProtoss(){
        LinkedList<Unidad> protoss= unidades.get(Raza.PROTOSS);
        for (Unidad u :protoss)
            u.pasarTurno();
    }

    public void chequeoEvolucion(UnidadZerg unidadAEvolucionar, UnidadZerg unidadEvolucionada){

        LinkedList<Unidad> lista = unidades.get(Raza.ZERG);
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
            lista.add(unidadEvolucionada);
        }
        else
            throw new RuntimeException("La unidad que se desea evolucionar no existe");
    }

    public void deletearZanganosDelExtractor(LinkedList<Zangano> zanganos) {
        for (Zangano z : zanganos) {
            unidades.get(Raza.ZERG).remove(z);
        }
    }

    public LinkedList<Zangano> devolverZanganos(LinkedList<Posicion> perimetro) {

        LinkedList<UnidadZerg> unidadesZerg = unidades.get(Raza.ZERG);
        LinkedList<UnidadZerg> unidades = new LinkedList<>();
        LinkedList<Zangano> zanganos = new LinkedList<>();

        for (Posicion pos: perimetro) {
            for(UnidadZerg z: unidadesZerg){

                if(pos.equals(z.getPosicion()))
                    unidades.add(z);

            }
        }

        for (UnidadZerg z: unidades) {
            z.agregaZangano(zanganos);
        }

        return zanganos;
    }


    public Object getAt(Posicion pos) {

        LinkedList<UnidadZerg> lista = unidades.get(Raza.ZERG);
        for(UnidadZerg u : lista){
            if(pos.equals(u.getPosicion() ) )
                return  u;
        }

        LinkedList<UnidadProtoss> lista2 =unidades.get(Raza.PROTOSS);
        for(UnidadProtoss u : lista2){
            if(pos.equals(u.getPosicion() ) )
                return  u;
        }

       return null;
    }

}
