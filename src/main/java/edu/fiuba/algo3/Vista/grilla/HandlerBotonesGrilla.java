package edu.fiuba.algo3.Vista.grilla;

import edu.fiuba.algo3.Vista.ButtonIds;
import edu.fiuba.algo3.Vista.Observable;
import edu.fiuba.algo3.Vista.Observer;
import edu.fiuba.algo3.Vista.Popup;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.*;

import static java.util.Objects.isNull;

public class HandlerBotonesGrilla implements Observable {

    HashMap<Class, GrillaBoton> botones;
    Manager manager;
    GridPane floorGrid;
    LinkedList<Observer> observers;


    public HandlerBotonesGrilla(Manager manager, LinkedList<Observer> observers, GridPane gridPane) {
        botones = new HashMap<>() ;
        this.manager   = manager  ;
        this.observers = observers;
        handleBotonesGrid(botones);
        this.floorGrid = gridPane;

    }

    public void handleBotonesGrid(HashMap mapa) {

        GrillaBoton criaderoAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("CRIADERO" ,crearBotonesMenuCriadero(economia, pos));
            });
        };
        mapa.put(Criadero.class, criaderoAccion);

        GrillaBoton extractorAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("EXTRACTOR" ,crearBotonesMenuExtractor(economia, pos));
            });
        };
        mapa.put(Extractor.class, extractorAccion);

        GrillaBoton reservaAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("RESERVA" ,crearBotonesMenuReserva(economia, pos));
            });
        };
        mapa.put(ReservaDeReproduccion.class, reservaAccion);

        GrillaBoton guaridaAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("GUARIDA" ,crearBotonesMenuGuarida(economia, pos));
            });
        };
        mapa.put(Guarida.class, guaridaAccion);

        GrillaBoton espiralAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("ESPIRAL" ,crearBotonesMenuEspiral(economia, pos));
            });
        };
        mapa.put(Espiral.class, espiralAccion);

        GrillaBoton accesoAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("ACCESO" ,crearBotonesMenuAcceso(economia, pos));
            });
        };
        mapa.put(Acceso.class, accesoAccion);

        GrillaBoton puertoEstelarAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("PUERTO ESTELAR" ,crearBotonesMenuPuertoEstelar(economia, pos));
            });
        };
        mapa.put(PuertoEstelar.class, puertoEstelarAccion);


        GrillaBoton accionesUnidad = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu("MENU DE ACCIONES" ,crearBotonUnidad(economia, pos));
            });
        };
        mapa.put(Zangano.class, accionesUnidad);
        mapa.put(Zerling.class, accionesUnidad);
        mapa.put(Zealot.class, accionesUnidad);
        mapa.put(Guardian.class, accionesUnidad);
        mapa.put(Dragon.class, accionesUnidad);
        mapa.put(Scout.class, accionesUnidad);
        mapa.put(Hidralisco.class, accionesUnidad);
        mapa.put(Devorador.class, accionesUnidad);
    }



    // CREADORES DE BOTONES ZERG //
    private LinkedList<Button> crearBotonesMenuReserva(Economia economia, Posicion pos) {

        Button boton = new Button();
        boton.setText("Crear Zerling");

        boton.setOnAction(action -> {
            try{
                manager.crearZerg(pos, new Zerling(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(boton);
        return b;
    }

    private LinkedList<Button> crearBotonesMenuGuarida(Economia economia, Posicion pos) {

        Button boton = new Button();
        boton.setText("Crear HIDRALISCO");

        boton.setOnAction(action -> {
            try{
                manager.crearZerg(pos, new Hidralisco(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(75);
                    economia.ingresarGasVespeno(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(boton);
        return b;
    }
    private LinkedList<Button> crearBotonesMenuEspiral(Economia economia, Posicion pos) {

        Button boton = new Button();
        boton.setText("Crear MUTALISCO");

        boton.setOnAction(action -> {
            try{
                manager.crearZerg(pos, new Mutalisco(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(100);
                    economia.ingresarGasVespeno(100);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(boton);
        return b;
    }

    private LinkedList<Button> crearBotonesMenuCriadero(Economia economia, Posicion pos) {
        Button button = new Button();
        button.setText("Crear ZANGANO");

        button.setOnAction(action -> {
            try{
                manager.crearZerg(pos, new Zangano(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(button);
        return b;
    }

    private LinkedList<Button> crearBotonesMenuExtractor(Economia economia, Posicion pos) {
        Button button = new Button();
        button.setText("Poner Zangano");

        button.setOnAction(action -> {
            try{
                Object extractor = manager.getAt(pos);
                if(isNull(extractor) || extractor.getClass() != Extractor.class) throw new RuntimeException("No hay un extractor en esa posicion");

                ( (Extractor) extractor).agregarZangano(manager);
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(button);
        return b;
    }
    // FIN CREADORES DE BOTONES ZERG //


    // CREADORES DE BOTONES PROTOSS //
    private LinkedList<Button> crearBotonesMenuAcceso(Economia economia, Posicion pos) {
        Button button1 = new Button();
        button1.setText("Crear DRAGON");

        Button button2 = new Button();
        button2.setText("Crear ZEALOT");

        button1.setOnAction(action -> {
            try{
                manager.crearProtoss(pos, new Dragon(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(125);
                    economia.ingresarGasVespeno(50);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        button2.setOnAction(action -> {
            try{
                manager.crearProtoss(pos, new Zealot(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(100);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(button1);
        b.add(button2);
        return b;
    }

    private LinkedList<Button> crearBotonesMenuPuertoEstelar(Economia economia, Posicion pos) {
        Button button = new Button();
        button.setText("Crear SCOUT");

        button.setOnAction(action -> {
            try{
                manager.crearProtoss(pos, new Scout(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" != e.getMessage()) {
                    economia.ingresarMineral(300);
                    economia.ingresarGasVespeno(150);
                }
                Popup.display(e.getMessage());
            }
            notificar();
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(button);
        return b;
    }
    // FIN CREADORES DE BOTONES PROTOSS //


    private LinkedList<Button> crearBotonUnidad(Economia economia, Posicion pos){

        Button buttonMover = new Button();
        Button buttonAtacar = new Button();

        buttonMover.setText("Mover unidad a...");
        buttonAtacar.setText("Atacar a...");

        buttonMover.setOnAction(any -> {

            for (int i = 0; i < manager.getMaxX(); i++) {
                for (int j = 0; j < manager.getMaxY(); j++) {

                    Set<Button> buttons = new HashSet<>();
                    Set<Node> nodeButton = floorGrid.lookupAll(ButtonIds.GRIDBUTTON.getLookupName());
                    for (Node n : nodeButton) {
                        buttons.add((Button) n);
                    }

                    for (Button b : buttons) {
                        int finalI = i;
                        int finalJ = j;
                        b.setOnAction(action -> {
                            Posicion posicion = new Posicion(finalI, finalJ);

                            try{
                                manager.moverUnidad(posicion, (Unidad) manager.getAt(pos) );
                                notificar();
                            }catch (RuntimeException e){
                                Popup.display(e.getMessage());
                            }
                        });
                    }
                }
            }
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(buttonMover);
        b.add(buttonAtacar);
        return b;
    }

    private GrillaBoton defaultBoton() {
        return (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(any -> {
                Popup.display("default (resultado de que el boton no tiene comportamiento, si deberia tenerlo, esto es un error)");
            });
        };
    }


    //MAL NOMBRE NO SE ENTIENDE QUE HACE
    public void set(Object objeto, Button boton, Posicion posicion, Economia economia) {
        GrillaBoton comportamiento = botones.getOrDefault(objeto.getClass(), defaultBoton());
        comportamiento.setOnActionDeGrilla(boton, economia, posicion);
    }


    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notificar() {
        for(Observer observer : observers)
            observer.update();
    }
}
