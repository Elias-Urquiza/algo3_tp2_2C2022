package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Posicion;

import java.util.LinkedList;

public class FloorManager {
    LinkedList<Moho> mohos;
    LinkedList<Cristales> cristales;
    LinkedList<Volcan> volcanes;
    LinkedList<Energia> energias;
    LinkedList<TileVacia> tilesVacias;
    public FloorManager(LinkedList<Moho> moho, LinkedList<Cristales> cristales,
                        LinkedList<Volcan> volcanes, LinkedList<Energia> energias,
                        LinkedList<TileVacia> tilesVacias) {

        this.mohos = moho;
        this.cristales = cristales;
        this.volcanes = volcanes;
        this.energias = energias;
        this.tilesVacias = tilesVacias;
    }


    public void quitarTilesVaciasParaMoho(){
        for(Moho m : mohos){
            tilesVacias.removeIf(tileVacia -> (tileVacia.getPos().equals(m.getPos() ) ) );
        }
    }

    private void quitarTilesVaciasParaEnergia(){
        for(Energia e : energias){
            tilesVacias.removeIf(tileVacia -> (tileVacia.getPos().equals(e.getPos() ) ) );
        }
    }

    private void agregarTilesVaciasParaEnergia(int id){
        for(TileVacia v : tilesVacias) {
            for (Energia e : energias) {
                Posicion posEnergia = e.getPos();
                if((posEnergia).equals(v.getPos()) && id == e.getID())
                    tilesVacias.add(new TileVacia( new Posicion(posEnergia.getX(), posEnergia.getY()) ) );
            }
        }
    }

    public void quitarTilesVaciasParaCristales() {
        for(Cristales c : cristales) {
            tilesVacias.removeIf(tileVacia -> (tileVacia.getPos().equals(c.getPos())));
        }
    }

    public void quitarTilesVaciasParaVolcanes() {
        for(Volcan v : volcanes) {
            tilesVacias.removeIf(tileVacia -> (tileVacia.getPos().equals(v.getPos())));
        }
    }

    public void mohificar(Posicion posCriadero, int maxX, int maxY, Manager manager) {

        int posicion_x = posCriadero.getX() -5;
        if (posicion_x<0)
            posicion_x = 0;

        int posicion_y = posCriadero.getY() -5;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = posCriadero.getX() + 6;
        if(topeX > maxX)
            topeX = maxX;

        int topeY = posCriadero.getY() + 6;
        if(topeY > maxY)
            topeY = maxY;

        for(int i = posicion_x; i<(topeX) ; i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                Posicion posAgregar = new Posicion(i, j);
                try {
                    manager.buscarCoincidencias(posAgregar);
                    Moho moho = new Moho(posAgregar);
                    quitarTilesVaciasParaMoho();
                    mohos.add(moho);
                } catch (RuntimeException e) {
                    System.out.println(String.format("DEBUG: El moho no se expandio en la pos %s porque hay una construccion", posAgregar));
                }
            }
        }
        quitarTilesVaciasParaMoho();
    }

    public void desenergizar(int maxX, int maxY, Posicion posPilon, int id) {
        int posicion_x = posPilon.getX() - 3;
        if (posicion_x < 0)
            posicion_x = 0;
        int posicion_y = posPilon.getY() - 3;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = posPilon.getX() + 4;
        if (topeX > maxX)
            topeX = maxX;

        int topeY = posPilon.getY() + 4;
        if (topeY > maxY)
            topeY = maxY;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                final int pos_i = i;
                final int pos_j = j;
                Posicion posicion = new Posicion(pos_i, pos_j);
                agregarTilesVaciasParaEnergia(id);
                energias.removeIf(energia ->  ( (energia.getPos()).equals(posicion) && id == energia.getID()));
            }
        }
    }

    public void energizar(Posicion pos, int maxX, int maxY, int id) {
        //hacer que energice segun acordado
        int posicion_x = pos.getX() - 3;
        if (posicion_x < 0)
            posicion_x = 0;   // aca hay que ver como hacer pra el cso del borde de coordenadas


        int posicion_y = pos.getY() - 3;
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = pos.getX() + 4;
        if (topeX > maxX)
            topeX = maxX;

        int topeY = pos.getY() + 4;
        if (topeY > maxY)
            topeY = maxY;

        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                Energia energia = new Energia(new Posicion(i, j), id);
                energias.add(energia);
            }
        }
        quitarTilesVaciasParaEnergia();
    }
}
