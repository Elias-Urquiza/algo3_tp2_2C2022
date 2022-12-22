package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Suministros;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.Estructura;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.unidades.*;
import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

import static java.util.Objects.isNull;


public class Manager {
    FloorManager floorManager;
    UnidadManager unidadManager;
    LinkedList<ConstruccionZerg> construccionesZerg;
    LinkedList<ConstruccionProtoss> construccionProtoss;
    LinkedList<ExtraeRecurso> construccionQueExtrae;
    LinkedList<Criadero> criaderos;
    LinkedList<Moho> moho;
    LinkedList<Cristales> cristales;
    LinkedList<Volcan> volcanes;
    LinkedList<Energia> energias;
    LinkedList<TileVacia> tilesVacias;
    LinkedList<Vacio> tilesDeVacios;
    LinkedList<Pilon> pilones;
    HashMap<Raza, Suministros> suminstrosHashMap;

    int maxX;
    int maxY;
    int idPilones;

    public Manager(int dimensionX, int dimensionY) {
        this.construccionesZerg =new LinkedList<>();
        this.construccionProtoss = new LinkedList<>();
        this.construccionQueExtrae = new LinkedList<>();
        this.criaderos = new LinkedList<>();
        this.moho = new LinkedList<>();
        this.cristales = new LinkedList<>();
        this.volcanes  = new LinkedList<>();
        this.energias = new LinkedList<>();
        this.tilesVacias = new LinkedList<>();
        this.pilones = new LinkedList<>();
        this.maxX = dimensionX;
        this.maxY = dimensionY;
        this.idPilones = 0;
        floorManager = new FloorManager(moho, cristales, volcanes, energias, tilesVacias, construccionesZerg, construccionProtoss, construccionQueExtrae, tilesDeVacios, dimensionX, dimensionY);
        unidadManager = new UnidadManager();
        this.tilesDeVacios = new LinkedList<>();
        HashMap<Raza, Suministros> suministros = new HashMap<>();
        suministros.put(Raza.ZERG, new Suministros());
        suministros.put(Raza.PROTOSS, new Suministros());
        this.suminstrosHashMap = suministros;
        floorManager.ponerVacio(tilesDeVacios, dimensionX, dimensionY);

        for (int i = 0; i < maxX; i ++) {
            for (int j = 0; j < maxY; j++) {
                Posicion pos = new Posicion(i,j);
                if(floorManager.sinVacio(pos,dimensionX, dimensionY))
                    tilesVacias.add(new TileVacia(pos) );
            }
        }

        crearBases();
    }


    public boolean consumirLarva(){
        boolean seExtrajo = false;

        for (Criadero c:  criaderos) {
           if(!seExtrajo) {
               try {
                   c.extraerLarvas(1);
                   // Encontramos larva asi que no buscamos mas
                   seExtrajo = true;
               } catch (RuntimeException e) {
                   // No encontramos una larva asi que pasamos al siguiente criadero
                   continue;
               }
           }
        }
        return seExtrajo;
    }

    public boolean reponerLarva(){
        boolean seRepuso = false;

        for (Criadero c:  criaderos) {
            if(!seRepuso) {
                try {
                    c.reponerLarva();
                    // Encontramos larva asi que no buscamos mas
                    seRepuso = true;
                } catch (RuntimeException e) {
                    // No encontramos una larva asi que pasamos al siguiente criadero
                    continue;
                }
            }
        }
        return seRepuso;
    }


    public void construirCriaderoEn(Posicion pos, Criadero criadero) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        if(unidadManager.posicionOcupada(pos))
            throw new RuntimeException("Posicion ocupada por unidad");

        criadero.setFloorManager(floorManager);
        criadero.setSuministrosZerg(suminstrosHashMap.get(Raza.ZERG));
        int size = construccionesZerg.size();

        floorManager.buscarCoincidencias(pos);

        if(!consumirLarva())
            throw new RuntimeException("no hay larvas para construir");

        for (TileVacia t : tilesVacias) {
            t.construir(construccionesZerg, criadero, pos);
        }
        if(size == construccionesZerg.size()) {
            for (Moho m : moho)//porque puedo tranquilamente construir un criadero sobre moho
                m.construir(construccionesZerg, criadero, pos);

            if (size == construccionesZerg.size()) {
                reponerLarva();
                throw new RuntimeException("No se puede construir en esta posicion");
            }
        }
        criaderos.add(criadero);
        suminstrosHashMap.get(Raza.ZERG).aumentarMaxSuminstros(5);
    }

    public void construirPilonEn(Posicion pos, Pilon pilon) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");


        if(unidadManager.posicionOcupada(pos))
            throw new RuntimeException("Posicion ocupada por unidad");

        pilon.setFloorManager(floorManager);
        pilon.setSuministrosProtoss(suminstrosHashMap.get(Raza.PROTOSS));
        int size = construccionProtoss.size();
        pilon.setID(idPilones);

        floorManager.buscarCoincidencias(pos);

        for (TileVacia t : tilesVacias)
            t.construir(construccionProtoss, pilon, pos);

        if(size == construccionProtoss.size()) {
            for(Energia e : energias)//porque puedo tranquilamente construir un pilon sobre energia
                e.construir(construccionProtoss, pilon, pos);

            if(size == construccionProtoss.size())
                throw new RuntimeException("No se puede construir en esta posicion");
        }
        pilones.add(pilon);
        suminstrosHashMap.get(Raza.PROTOSS).aumentarMaxSuminstros(5);
        idPilones  ++;
    }

    public void construirEstructuraDeCristales(Posicion pos, ExtraeRecurso extrae){

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");


        if(unidadManager.posicionOcupada(pos))
            throw new RuntimeException("Posicion ocupada por unidad");

        floorManager.buscarCoincidencias(pos);
        floorManager.noHayVolcan(pos);
        int size = construccionQueExtrae.size();

        for(Cristales c : cristales) {
            Recurso recurso = c.construir(construccionQueExtrae, extrae, pos);
            if(Objects.nonNull(recurso)) {
                extrae.setRecurso(c);
                break;
            }
        }

        if(size == construccionQueExtrae.size())
            throw new RuntimeException("No hay un mineral en la posicion");
    }

    public void construirExtractor(Posicion pos, ExtraeRecurso extrae){

        if(!consumirLarva()) // quitamos una larva
            throw new RuntimeException("no hay larvas para tu construccion");

        try{
            construirAsimilador(pos, extrae);
        }catch (RuntimeException e){
            reponerLarva(); // volvemos a poner a larva en su lugar en caso de que no se haya podido construir el edificio.
            throw new RuntimeException(e.getMessage());
        }

    }

    public void construirAsimilador(Posicion pos, ExtraeRecurso extrae){

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        if(unidadManager.posicionOcupada(pos))
            throw new RuntimeException("Posicion ocupada por unidad");


        floorManager.buscarCoincidencias(pos);
        int size = construccionQueExtrae.size();
        for(Volcan v : volcanes) {
            Recurso recurso = v.construir(construccionQueExtrae, extrae, pos);
            if(Objects.nonNull(recurso)) {
                extrae.setRecurso(v);
                break;
            }
        }
        if(size == construccionQueExtrae.size())
            throw new RuntimeException("No hay un volcan en la posicion");
    }

    public LinkedList<TileVacia> getTilesVacias(){
        return tilesVacias;
    }

    public LinkedList<Moho> getMohos(){
        return moho;
    }

    public LinkedList<Energia> getEnergias(){
        return energias;
    }

    public void construirProtoss(Posicion pos, ConstruccionProtoss protoss) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        if(unidadManager.posicionOcupada(pos))
            throw new RuntimeException("Posicion ocupada por unidad");

        floorManager.buscarCoincidencias(pos);

        int size = construccionProtoss.size();

        for(Energia e : energias) {
            try {
                e.construir(construccionProtoss, protoss, pos);
            } catch (RuntimeException err1) {
                throw err1;
            }
        }
        if(size == construccionProtoss.size())
            throw new RuntimeException("Este piso no esta energizado");
    }

    public void destruirProtoss(Posicion pos) {
        int size = construccionProtoss.size();

        construccionProtoss.removeIf(construccion -> (construccion.sePuedeDestruir(pos) ) );
        pilones.removeIf(pilon -> pilon.seQuitaPilon(pos) );

        floorManager.desactivarEstructurasProtoss();
        if(size == construccionProtoss.size()) {
            throw new RuntimeException("No hay nada para destruir");
        }

       for (Pilon p: pilones){
            p.energizarDespuesDeEliminarUnPilon();
       }

    }

    public void destruirZerg(Posicion pos) {
        int size = construccionesZerg.size();

        construccionesZerg.removeIf(construccion -> (construccion.sePuedeDestruir(pos) ) );

        if(size == construccionesZerg.size()) {
            throw new RuntimeException("No hay nada para destruir");
        }

    }

    public void construirZerg(Posicion pos, ConstruccionZerg zerg) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        if(unidadManager.posicionOcupada(pos))
            throw new RuntimeException("Posicion ocupada por unidad");

        floorManager.buscarCoincidencias(pos);

        if(!consumirLarva()) // quitamos una larva
            throw new RuntimeException("no hay larvas para tu construccion");

        int size = construccionesZerg.size();
        for(Moho m : moho) {
            try {
                m.construir(construccionesZerg, zerg, pos);
            }catch (RuntimeException err2){
                reponerLarva();
                throw err2;
            }
        }
        if(size == construccionesZerg.size()){
            reponerLarva();
            throw new RuntimeException("Este piso no tiene moho");
        }
    }

    public void crearZerg(Posicion posConstruccion, Unidad unidad){
        if(!consumirLarva()) // quitamos una larva
            throw new RuntimeException("no hay larvas para tu unidad");

        try{
            crearUnidad(posConstruccion, unidad);
        }catch (RuntimeException e){
            reponerLarva(); // volvemos a poner a larva en su lugar en caso de que no se haya podido construir el edificio.
            throw new RuntimeException(e.getMessage());
        }
    }

    public void crearProtoss(Posicion posConstruccion, Unidad unidad){
        crearUnidad( posConstruccion, unidad);
    }

    public void crearUnidad(Posicion posConstruccion, Unidad unidad){
        Posicion pos;
        boolean accionRealizada = false;

        floorManager.construccionTerminada(posConstruccion);

        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                try {
                    pos = posConstruccion.incrementar(i, j, maxX, maxY);
                }catch (RuntimeException e) {
                    continue;
                }
                try {
                    floorManager.buscarCoincidenciasUnidades(pos);
                }catch (RuntimeException e){
                    continue;
                }

                if(floorManager.conVacio(pos, maxX, maxY) )
                    continue;

                if(unidadManager.posicionOcupada(pos))
                    continue;

                if(!accionRealizada) {
                    try {
                        unidadManager.crearUnidad(unidad, pos, suminstrosHashMap);
                        accionRealizada = true;
                    } catch(RuntimeException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
            }
        }
    }

    public void evolucionar(UnidadZerg unidadAEvolucionar, UnidadZerg unidadEvolucionada){
        unidadManager.chequeoEvolucion(unidadAEvolucionar, unidadEvolucionada);
    }

    public void moverUnidad(Posicion pos, Unidad unidad) {
        try {
            floorManager.buscarCoincidenciasUnidades(pos);
        }catch (RuntimeException e){
            return;
        }
        unidadManager.moverUnidad(unidad, pos, (floorManager.conVacio(pos, maxX, maxY) ));
    }

    public void unidadAtacaUnidad(Unidad unaUnidad, Unidad unObjetivo){
        unidadManager.ejecutarComandoDeDaniar(unaUnidad, unObjetivo);
    }

    public void unidadAtacaConstruccion(Unidad unaUnidad, Estructura unaEstructura){
        unidadManager.ejecutarComandoDeDaniar(unaUnidad, (Objetivo) unaEstructura);
        unaEstructura.destruir(construccionesZerg, construccionProtoss, construccionQueExtrae ,floorManager);
    }

    public void agregarCristales(Posicion pos) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        try{
            floorManager.noHayVolcanOVacio(pos);
            cristales.add(new Cristales(pos));
            floorManager.quitarTilesVaciasParaCristales();
        }catch (RuntimeException e){

        }
    }

    public void agregarVolcanes(Posicion pos) {

        if(floorManager.conVacio(pos, maxX, maxY) )
            throw new RuntimeException("La posicion es un espacio aereo");

        try {
            floorManager.noHayVolcanOVacio(pos);
            volcanes.add(new Volcan(pos));
            floorManager.quitarTilesVaciasParaVolcanes();
        }catch (RuntimeException e){

        }
    }

    public LinkedList<Posicion> devolverPerimetro (Posicion posCentro){
        Posicion pos = null;
        LinkedList<Posicion> perimetro = new LinkedList<>();

        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++){

                try {
                    pos = posCentro.incrementar(i, j, maxX, maxY);
                }catch (RuntimeException e) {
                    continue;
                }
                perimetro.add(pos);
            }
        }

        return perimetro;
    }

    public void pasarTurno(){
        for(ConstruccionProtoss protoss :construccionProtoss)
            protoss.pasarTurno();

        for (ConstruccionZerg zerg : construccionesZerg)
            zerg.pasarTurno();

        for (ExtraeRecurso extrae : construccionQueExtrae)
            extrae.pasarTurno();

        for (Cristales c : cristales) {
            LinkedList <Posicion> perimetro;
            LinkedList <Zangano>listaZanganos;
            int numZanganos = 0;
            // Paso 1) funcion privada que recibe la pos del centro y luego revisa (DONE)
            perimetro = devolverPerimetro( c.getPos() );
            // Paso 1.5) Unidad manager revisa cuales tiene num zanganos alrededor
            listaZanganos = unidadManager.devolverZanganos(perimetro);
            // Paso 2) le enviamos cant de zanganos a cristal y extrae
            if(listaZanganos.size() > 0) {
                for (Zangano z : listaZanganos)
                    z.extraerMineral(c);
                System.out.format("la pos del cristal es: %s", c.getPos());
            }
        }

        unidadManager.hacerPasarDeTurno();

        floorManager.terminarJuegoZerg();
        floorManager.terminarJuegoProtoss();
    }

    public void crearBases(){
        Posicion posBase1 = new Posicion(maxX-3,maxY-3);
        Posicion posBase2 = new Posicion(3,3);
        Posicion centro   = new Posicion(maxX/2,maxY/2);
        Economia economiaInicializadora = new Economia();
        economiaInicializadora.ingresarMineral(300);

        // Crear bases Zerg
        crearBaseZerg(posBase1, economiaInicializadora);
        // Crear base Protoss
        crearBaseProtoss(posBase2, economiaInicializadora);

        // Crear varias bases desplegadas de forma equidistante al centro
        // recordar que hay un vacio en el centro del mapa que es proporcional al tamanio
        // TODO

            Integer offsetDelCentro = floorManager.calcularOffset(maxX) + 3;
            for (int i = offsetDelCentro; i < maxX - 10; i = i + 10) {
                int sumarOffsetX = i;
                int restarOffsetX = i;
                try {
                    crearBaseNormal(centro.incrementar(sumarOffsetX, 0, maxX, maxY));
                } catch (RuntimeException e){}

                try{
                    crearBaseNormal(centro.incrementar(0, sumarOffsetX, maxX, maxY));
                }catch (RuntimeException e){}

                try{
                    crearBaseNormal(centro.incrementar(restarOffsetX, 0, maxX, maxY));
                }catch(RuntimeException e){}

                try{
                    crearBaseNormal(centro.incrementar(0, restarOffsetX, maxX, maxY));
                }catch (RuntimeException e){}
            }

        floorManager.quitarEnergiasParaCristalesYVolcanes();

    }

    private void crearBaseNormal(Posicion pos) {
        int sumarOffset = 2;
        int restarOffset = -2;
        Posicion posAux = pos;

        // Agrego muchos cristales alrededor del centro
        try {
            posAux = pos.incrementar(sumarOffset, 0, maxX, maxY);
            agregarCristales(posAux);
        }catch (RuntimeException e){
            System.out.println(String.format("DEBUG: Quilombo en la pos %s" , posAux));
        }

        try {
            posAux = pos.incrementar(restarOffset, 0, maxX, maxY);
            agregarCristales(posAux);
        }catch (RuntimeException e){
            System.out.println(String.format("DEBUG: Quilombo en la pos %s" , posAux));
        }

        try {
            posAux = pos.incrementar(sumarOffset, sumarOffset, maxX, maxY);
            agregarCristales(posAux);
        }catch (RuntimeException e){
            System.out.println(String.format("DEBUG: Quilombo en la pos %s" , posAux));
        }

        try {
            posAux = pos.incrementar(restarOffset, restarOffset, maxX, maxY);
            agregarCristales(posAux);
        }catch (RuntimeException e){
            System.out.println(String.format("DEBUG: Quilombo en la pos %s" , posAux));
        }

        try {
            posAux = pos.incrementar(0, sumarOffset, maxX, maxY);
            agregarCristales(posAux);
        }catch (RuntimeException e){
            System.out.println(String.format("DEBUG: Quilombo en la pos %s" , posAux));
        }

        try {
            posAux = pos.incrementar(0, restarOffset, maxX, maxY);
            agregarVolcanes(posAux);
        }catch (RuntimeException e){
            System.out.println(String.format("DEBUG: Quilombo en la pos %s" , posAux));
        }
    }

    private void crearBaseZerg(Posicion pos, Economia economia) {
        crearBaseNormal(pos);

        Criadero criadero =  new Criadero(economia, pos);

        criadero.setFloorManager(floorManager);
        criadero.setSuministrosZerg(suminstrosHashMap.get(Raza.ZERG));
        suminstrosHashMap.get(Raza.ZERG).aumentarMaxSuminstros(5);
        construccionesZerg.add(criadero);
        criaderos.add(criadero);
        for(int i = 0; i<4; i++)
            criadero.pasarTurno();
    }

    private void crearBaseProtoss(Posicion pos, Economia economia) {
        crearBaseNormal(pos);

        Pilon pilon = new Pilon(economia,pos);

        construirPilonEn(pos, pilon);

        for(int i = 0; i<5; i++)
            pilon.pasarTurno();
    }


    public void crearZanganoParaExtractor(Posicion pos, Zangano zangano) {
        try {
            unidadManager.crearUnidad(zangano, pos, suminstrosHashMap);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    /*public void crearZanganoParaExtractor(Posicion pos, Zangano zangano) {
        for(ExtraeRecurso ext : construccionQueExtrae){
            if(ext.getPosicion().equals(pos) && ext.getClass() == Extractor.class){
                try{
                    ((Extractor) ext).agregarZangano(this);
                    unidadManager.crearUnidad(zangano, pos, suminstrosHashMap);
                }catch (RuntimeException e){
                    throw new RuntimeException(e.getMessage());
                }
                break;
            }
        }
    }*/

    public void destruirZanganosDeExtractor(LinkedList<Zangano> zanganos) {
        unidadManager.deletearZanganosDelExtractor(zanganos);
    }

    public Object getAt(Posicion pos) {
        //Smell -> 2L82 refactor

        Object o = unidadManager.getAt(pos);

        if( o != null )
            return o;

        for (ConstruccionProtoss p : construccionProtoss) {
            if (pos.equals(p.getPosicion())) {
                return p;
            }
        }

        for (ConstruccionZerg z : construccionesZerg) {
            if (pos.equals(z.getPosicion())) {
                return z;
            }
        }

        for (ExtraeRecurso ext : construccionQueExtrae) {
            if (pos.equals(ext.getPosicion())) {
                return ext;
            }
        }

        for (Moho m : moho) {
            if (pos.equals(m.getPos())) {
                return m;
            }
        }

        for (Energia e : energias) {
            if (pos.equals(e.getPos())) {
                return e;
            }
        }

        for (Cristales c : cristales) {
            if (pos.equals(c.getPos())) {
                return c;
            }
        }

        for (Volcan v : volcanes) {
            if (pos.equals(v.getPos())) {
                return v;
            }
        }

        for (TileVacia t : tilesVacias) {
            if (pos.equals(t.getPos())) {
                return t;
            }
        }

        for (Vacio vac : tilesDeVacios) {
            if (pos.equals(vac.getPos())) {
                return vac;
            }
        }
        return null;
    }

    public Object getBuildingAt(Posicion pos) {
        return null;
    }

    public int getMaxX(){ return maxX;}

    public int getMaxY(){ return maxY;}


}
