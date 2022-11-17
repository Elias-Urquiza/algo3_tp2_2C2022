package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

import java.util.LinkedList;

public class FloorManager {
    LinkedList<Moho> moho;
    LinkedList<Cristales> cristales;
    LinkedList<Volcan> volcanes;
    LinkedList<Energia> energias;
    LinkedList<TileVacia> tilesVacias;
    LinkedList<ConstruccionZerg> construccionesZerg;
    LinkedList<ConstruccionProtoss> construccionProtoss;
    LinkedList<ExtraeRecurso> construccionQueExtrae;
    private int maxX;
    private int maxY;



    public FloorManager(LinkedList<Moho> moho, LinkedList<Cristales> cristales,
                        LinkedList<Volcan> volcanes, LinkedList<Energia> energias,
                        LinkedList<TileVacia> tilesVacias, LinkedList<ConstruccionZerg> construccionZerg,
                        LinkedList<ConstruccionProtoss> construccionProtoss, LinkedList<ExtraeRecurso> construccionQueExtrae, int maxX, int maxY) {

        this.moho = moho;
        this.cristales = cristales;
        this.volcanes = volcanes;
        this.energias = energias;
        this.tilesVacias = tilesVacias;
        this.construccionesZerg = construccionZerg;
        this.construccionProtoss =construccionProtoss;
        this.construccionQueExtrae = construccionQueExtrae;
        this.maxY= maxY;
        this.maxX= maxX;
    }


    public void quitarTilesVaciasParaMoho(){
        for(Moho m : moho){
            tilesVacias.removeIf(tileVacia -> (tileVacia.getPos().equals(m.getPos() ) ) );
        }
    }

    public void quitarEnergiasParaMoho(){
        for(Moho m : moho){
            energias.removeIf(energia -> (energia.getPos().equals(m.getPos() ) ) );
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

    public void mohificar(Posicion posCriadero, int auxiliar) {


        int posicion_x = posCriadero.getX() -(5-auxiliar);
        if (posicion_x<0)
            posicion_x = 0;

        int posicion_y = posCriadero.getY() -(5-auxiliar);
        if (posicion_y < 0)
            posicion_y = 0;

        int topeX = posCriadero.getX() + (6+auxiliar);
        if(topeX > maxX)
            topeX = maxX;

        int topeY = posCriadero.getY() + (6+auxiliar);
        if(topeY > maxY)
            topeY = maxY;

        for(int i = posicion_x; i<(topeX) ; i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                Posicion posAgregar = new Posicion(i, j);
                try {
                    buscarCoincidenciasMoho(posAgregar);
                    Moho mohoNew = new Moho(posAgregar);
                    moho.add(mohoNew);
                } catch (RuntimeException e) {
                    System.out.println(String.format("DEBUG: El moho no se expandio en la pos %s porque hay una construccion o un mineral", posAgregar));

                }
            }
        }
        quitarEnergiasParaMoho();
        quitarTilesVaciasParaMoho();
    }

    public void desenergizar(Posicion posPilon, int id) {
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

        agregarTilesVaciasParaEnergia(id);
        for (int i = posicion_x; i < (topeX); i++) {
            for (int j = posicion_y; j < (topeY); j++) {
                final int pos_i = i;
                final int pos_j = j;
                Posicion posicion = new Posicion(pos_i, pos_j);
                energias.removeIf(energia ->  ( (energia.getPos()).equals(posicion) && id == energia.getID()));
            }
        }
    }

    public void energizar(Posicion pos, int id) {
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
                Posicion posAgregar = new Posicion(i, j);
                try{
                    buscarCoincidenciasEnergia(posAgregar);
                    Energia energia = new Energia(posAgregar, id);
                    energias.add(energia);
                }catch (RuntimeException e) {
                    System.out.println(String.format("DEBUG: La energia no se expandio en la pos %s porque hay una un mineral o moho", posAgregar));
                }
           }
        }
        activarEstructurasProtoss();
        quitarTilesVaciasParaEnergia();
    }

    public void desactivarEstructurasProtoss(){
        int contador =0;

        for(ConstruccionProtoss c: construccionProtoss){
            for (Energia e: energias){
                if( (c.getPosicion()).equals(e.getPos()) )
                    contador ++;
            }
            if(contador == 0)//si no encontre ninguna coincidencia
                c.desactivar();

            contador = 0;
        }
    }

    public void activarEstructurasProtoss(){
        int contador =0;
        for(ConstruccionProtoss c: construccionProtoss){
            for (Energia e: energias){
                if( (c.getPosicion()) .equals(e.getPos()) )
                    contador ++;
            }
            if(contador != 0)//si no encontre ninguna coincidencia
                c.activar();

            contador = 0;
        }
    }

    public void buscarCoincidencias(Posicion posicion){
        for (ConstruccionProtoss c: construccionProtoss){
            Posicion posicionProtoss = c.getPosicion();
            if(posicionProtoss.equals(posicion)){
                throw new RuntimeException("Ya hay una construccion en esa posicion");
            }
        }

        for (ConstruccionZerg c: construccionesZerg){
            Posicion posicionZerg = c.getPosicion();
            if(posicionZerg.equals(posicion)){
                throw new RuntimeException("Ya hay una construccion en esa posicion");
            }
        }

        for (ExtraeRecurso ext : construccionQueExtrae){
            Posicion posicionExt = ext.getPosicion();
            if(posicionExt.equals(posicion)){
                throw new RuntimeException("Ya hay una construccion en esa posicion");
            }
        }
    }

    public  void buscarCoincidenciasMoho(Posicion posicion) {
        for (ConstruccionProtoss c : construccionProtoss) {
            Posicion posicionProtoss = c.getPosicion();
            if (posicionProtoss.equals(posicion)) {
                throw new RuntimeException("Ya hay una construccion en esa posicion");
            }
        }

        for (Moho m : moho) {
            Posicion posicionMoho = m.getPos();
            if (posicionMoho.equals(posicion)) {
                throw new RuntimeException("Ya hay un Moho en esa posicion");
            }
        }

        for (Cristales c : cristales) {
            Posicion posicionCristales = c.getPos();
            if (posicionCristales.equals(posicion)) {
                throw new RuntimeException("Ya hay un cristal en esa posicion");
            }
        }

        for (Volcan v : volcanes) {
            Posicion posicionVolcan = v.getPos();
            if (posicionVolcan.equals(posicion)) {
                throw new RuntimeException("Ya hay un volcan en esa posicion");
            }
        }
    }

    public void buscarCoincidenciasEnergia(Posicion posicion){

        for (Moho m: moho) {
            Posicion posicionMoho = m.getPos();
            if (posicionMoho.equals(posicion)) {
                throw new RuntimeException("Ya hay un Moho en esa posicion");
            }
        }

        for (Cristales c: cristales){
            Posicion posicionCristales = c.getPos();
            if(posicionCristales.equals(posicion)){
                throw new RuntimeException("Ya hay un cristal en esa posicion");
            }
        }

        for (Volcan v: volcanes){
            Posicion posicionVolcan = v.getPos();
            if(posicionVolcan.equals(posicion)){
                throw new RuntimeException("Ya hay un volcan en esa posicion");
            }
        }
    }
}
