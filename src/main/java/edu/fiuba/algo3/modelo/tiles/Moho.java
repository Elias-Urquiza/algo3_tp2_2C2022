package edu.fiuba.algo3.modelo.tiles;




import edu.fiuba.algo3.modelo.Construccion;


import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.buildings.zerg.Espiral;
import edu.fiuba.algo3.modelo.buildings.zerg.Guarida;
import edu.fiuba.algo3.modelo.buildings.zerg.ReservaDeReproduccion;


public class Moho implements FloorType{


    private static final List<Class> AVAILABLE_BUILDINGS = List.of(
            Criadero.class,
            Espiral.class,
            Guarida.class,
            ReservaDeReproduccion.class
    );

    private int turnosExpandirMoho;
    private FloorType[][] tabla;
    private static final int CRIADERO = 0;
    ArrayList<ArrayList<Integer>> vecinos;
    private ConstruccionZerg estructuraEnPosesion;
    private int posX;
    private int posY;

    boolean ocurrioExpansionMoho;

    public Moho(ArrayList<ArrayList<Integer>> vecinos, FloorType[][] tabla, int posX, int posY){
        estructuraEnPosesion = null;
        this.vecinos = vecinos;
        this.tabla = tabla;
        this.posX = posX;
        this.posY = posY;
        ocurrioExpansionMoho = true;
        turnosExpandirMoho = 0;
    }

    public void infectate(FloorType nuevoPiso){
        throw new RuntimeException("No se puede infectar este piso");
    }

    // SI DESTRUYO UN CRIADERO ANTES DE QUE SE CONSTRUYA, ENTONCES SE REEMPLAZA EL PISO DE MOHO EN EL QUE
    // ESTABA EL CRIADERO POR UNA TILE VACIA.


    public void accionarPiso() {

        if (AVAILABLE_BUILDINGS.indexOf(estructuraEnPosesion) == CRIADERO && !ocurrioExpansionMoho) {
            this.expansionMohoPorCriadero();
        }
        if ((turnosExpandirMoho != 0) && (turnosExpandirMoho % 2 == 0)){
            this.expandirMohoEnRadioUno();
        }
        turnosExpandirMoho++;
    }
    public void expansionMohoPorCriadero(ArrayList<ArrayList<Integer>> misVecinos){

        expandirMohoEnRadioUno(misVecinos);
        tabla[misVecin][]

    }
    public void expandirMohoEnRadioUno(ArrayList<ArrayList<Integer>> misVecinos){
        for (int i = 0; i < misVecinos.size(); i++) {
               int vecinoPosX = (misVecinos.get(i)).get(0);
               int vecinoPosY = (misVecinos.get(i)).get(1);

               Moho moho = new Moho((tabla[vecinoPosX][vecinoPosY]).getVecinos(), tabla, vecinoPosX, vecinoPosY);// se crea al moho correctamente
               (tabla[vecinoPosX][vecinoPosY]).infectate(moho);//se le envia a la tile el comando infectate
        }
    }

    public void setConstruccion(Construccion nuevaEstructura){
        estructuraEnPosesion = nuevaEstructura;
    }

    public ArrayList<ArrayList<Integer>> getVecinos(){
        return vecinos;
    }
    public Construccion getConstruccion(){
        return estructuraEnPosesion;
    }
    public void buildOn(Construccion aConstruir) throws RuntimeException {

        if(AVAILABLE_BUILDINGS.contains( aConstruir.getClass() ) ) {
            estructuraEnPosesion = aConstruir;
            return;
        }
        throw new RuntimeException("You cannot build on top of this");
    }
}
