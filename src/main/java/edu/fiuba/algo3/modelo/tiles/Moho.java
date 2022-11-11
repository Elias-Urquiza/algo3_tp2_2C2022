package edu.fiuba.algo3.modelo.tiles;




import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;


import java.util.ArrayList;
import java.util.List;
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
    private Construccion estructuraEnPosesion;
    private int posX;
    private int posY;

    public Moho(ArrayList<ArrayList<Integer>> vecinos, FloorType[][] tabla, int posX, int posY){
        estructuraEnPosesion = null;
        this.vecinos = vecinos;
        this.tabla = tabla;
        this.posX = posX;
        this.posY = posY;
        turnosExpandirMoho = 0;
    }

    public void infectate(FloorType nuevoPiso){
        throw new RuntimeException("No se puede infectar este piso");
    }

    public void accionarPiso(){
        
        if(turnosExpandirMoho !=0 && turnosExpandirMoho%2 == 0){

            for(int i = 0; i < vecinos.size(); i++){
                int vecinoPosX = (vecinos.get(i)).get(0);
                int vecinoPosY = (vecinos.get(i)).get(1);

                Moho moho = new Moho((tabla[vecinoPosX][vecinoPosY]).getVecinos(), tabla, vecinoPosX, vecinoPosY);// se crea al moho correctamente

                (tabla[vecinoPosX][vecinoPosY]).infectate(moho);//se le envia a la tile el comando infectate

            }
        }
        turnosExpandirMoho++;
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
