package edu.fiuba.algo3.Vista.grilla;

import edu.fiuba.algo3.Vista.ButtonIds;
import edu.fiuba.algo3.Vista.Observable;
import edu.fiuba.algo3.Vista.Observer;
import edu.fiuba.algo3.Vista.Popup;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.Estructura;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;

import static java.util.Objects.isNull;

public class HandlerBotonesGrilla implements Observable {

    HashMap<Class, GrillaBoton> botones;
    Manager manager;
    GridPane floorGrid;
    LinkedList<Observer> observers;
    PartidaJugadores partida;


    public HandlerBotonesGrilla(Manager manager, LinkedList<Observer> observers, GridPane gridPane, PartidaJugadores partida) {
        botones = new HashMap<>() ;
        this.manager   = manager  ;
        this.observers = observers;
        handleBotonesGrid(botones);
        this.floorGrid = gridPane ;
        this.partida = partida;
    }

    public void handleBotonesGrid(HashMap mapa) {

        GrillaBoton criaderoAccion = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Estructura) o).getInformacion() ,"CRIADERO" ,crearBotonesMenuCriadero(economia, pos));
            });
        };
        mapa.put(Criadero.class, criaderoAccion);

        GrillaBoton extractorAccion = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Estructura) o).getInformacion(), "EXTRACTOR" ,crearBotonesMenuExtractor(economia, pos));
            });
        };
        mapa.put(Extractor.class, extractorAccion);

        GrillaBoton reservaAccion = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Estructura) o).getInformacion(), "RESERVA" ,crearBotonesMenuReserva(economia, pos));
            });
        };
        mapa.put(ReservaDeReproduccion.class, reservaAccion);

        GrillaBoton guaridaAccion = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Estructura) o).getInformacion(), "GUARIDA" ,crearBotonesMenuGuarida(economia, pos));
            });
        };
        mapa.put(Guarida.class, guaridaAccion);

        GrillaBoton espiralAccion = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Estructura) o).getInformacion(), "ESPIRAL" ,crearBotonesMenuEspiral(economia, pos));
            });
        };
        mapa.put(Espiral.class, espiralAccion);

        GrillaBoton accesoAccion = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Estructura) o).getInformacion(), "ACCESO" ,crearBotonesMenuAcceso(economia, pos));
            });
        };
        mapa.put(Acceso.class, accesoAccion);

        GrillaBoton puertoEstelarAccion = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Estructura) o).getInformacion(), "PUERTO ESTELAR" ,crearBotonesMenuPuertoEstelar(economia, pos));
            });
        };
        mapa.put(PuertoEstelar.class, puertoEstelarAccion);


        GrillaBoton accionesUnidad = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Unidad) o).getInformacion(), "MENU DE ACCIONES" ,crearBotonUnidad(economia, pos));
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

        GrillaBoton accionesMutalisco = (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.displayAMenu(((Unidad) o).getInformacion(), "MENU DE ACCIONES" ,crearBotonMutalisco(economia, pos));
            });
        };
        mapa.put(Mutalisco.class, accionesMutalisco);

    }

    private LinkedList<Button> crearBotonMutalisco(Economia economia, Posicion pos) {
        LinkedList<Button> b = crearBotonUnidad(economia, pos);

        Button button1 = new Button();
        Button button2 = new Button();

        button1.setText("evolucionar a Devorador");
        button2.setText("evolucionar a Guardian");

        setOnActionEvolucionarADevorador(button1, economia, pos);
        setOnActionEvolucionarAGuardian (button2, economia, pos);

        b.add(button1);
        b.add(button2);

        return b;
    }

    private void setOnActionEvolucionarADevorador(Button button1, Economia economia, Posicion pos) {
        button1.setOnAction(any -> {

            try {
                manager.evolucionar( (UnidadZerg) manager.getAt(pos), new Devorador(economia, pos));

            }catch (RuntimeException e){
                Popup.display(e.getMessage() + " SOY YO EL QUE JODE");

                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(150);
                    economia.ingresarGasVespeno(50);
                }
            }
            notificar();
            close(button1);
        });
    }

    private void setOnActionEvolucionarAGuardian(Button button1, Economia economia, Posicion pos) {
        button1.setOnAction(any -> {

            try {
                manager.evolucionar( (UnidadZerg) manager.getAt(pos), new Guardian(economia, pos));
            }catch (RuntimeException e){
                Popup.display(e.getMessage());

                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(50);
                    economia.ingresarGasVespeno(100);
                }
            }
            notificar();
            close(button1);
        });
    }

    private LinkedList<Button> crearBotonUnidad(Economia economia, Posicion pos){

        Button buttonMover = new Button();
        Button buttonAtacar = new Button();

        buttonMover.setText("Mover unidad a...");
        buttonAtacar.setText("Atacar a...");

        setOnActionMoverUnidad(buttonMover, pos);
        setOnActionAtacarUnidad(buttonAtacar, pos);

        LinkedList<Button> b = new LinkedList<>();
        b.add(buttonMover);
        b.add(buttonAtacar);
        return b;
    }

    // CREADORES DE BOTONES ZERG //
    private LinkedList<Button> crearBotonesMenuReserva(Economia economia, Posicion pos) {

        Button boton = new Button();
        boton.setText("Crear Zerling");

        boton.setOnAction(action -> {
            try{
                manager.crearZerg(pos, new Zerling(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(boton);
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
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(75);
                    economia.ingresarGasVespeno(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(boton);
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
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(100);
                    economia.ingresarGasVespeno(100);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(boton);
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
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(button);
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(button);
        return b;
    }

    private LinkedList<Button> crearBotonesMenuExtractor(Economia economia, Posicion pos) {
        Button button = new Button();
        button.setText("Poner Zangano");

        button.setOnAction(action -> {
            Object o = manager.getAt(pos);
            // Esto deberia ser responsabilidad del modelo
            if(isNull(o) || o.getClass() != Extractor.class) Popup.display("No hay un extractor en esa posicion");
            Extractor extractor = (Extractor) o;

            try{
                extractor.agregarZangano(manager);

            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(25);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(button);
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
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(125);
                    economia.ingresarGasVespeno(50);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(button1);
        });

        button2.setOnAction(action -> {
            try{
                manager.crearProtoss(pos, new Zealot(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(100);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(button2);
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
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(300);
                    economia.ingresarGasVespeno(150);
                }
                Popup.display(e.getMessage());
            }
            notificar();
            close(button);
        });

        LinkedList<Button> b = new LinkedList<>();
        b.add(button);
        return b;
    }
    // FIN CREADORES DE BOTONES PROTOSS //


    private void setOnActionAtacarUnidad(Button buttonAtacar, Posicion pos) {
        buttonAtacar.setOnAction(any -> {
            Set<Button> buttons = new HashSet<>();
            for (int i = 0; i < manager.getMaxX(); i++) {
                for (int j = 0; j < manager.getMaxY(); j++) {
                    Set<Node> nodeButton = floorGrid.lookupAll(ButtonIds.GRIDBUTTON.getLookupName());
                    for (Node n : nodeButton) {
                        buttons.add((Button) n);
                    }
                }
            }
            for (Button b : buttons) {
                b.setOnAction(action -> {
                    Posicion posicion = new Posicion(GridPane.getColumnIndex(b), GridPane.getRowIndex(b));
                    Object o = manager.getAt(posicion);
                    if (o instanceof Estructura ) {

                        try {
                            int dmg = manager.unidadAtacaConstruccion(partida.getJugadorActivo().getRaza(), (Unidad) manager.getAt(pos), (Estructura) o);
                            Popup.display(String.format("Da??o hecho: %s", dmg));
                        } catch (RuntimeException e){
                            //desperate times require desperate measures
                            if (e.getMessage() == "Los Protoss han ganado el juego" ||  e.getMessage() == "Los Zerg han ganado el juego") {
                                notificar();
                                return;
                            }
                            Popup.display(e.getMessage());
                        }

                    } else if (o instanceof Unidad) {

                        try {
                            int dmg = manager.unidadAtacaUnidad(partida.getJugadorActivo().getRaza(), (Unidad) manager.getAt(pos), (Unidad) o);
                            Popup.display(String.format("Da??o hecho: %s", dmg));
                        } catch (RuntimeException e){
                            // :/
                            if (e.getMessage() == "Los Protoss han ganado el juego" ||  e.getMessage() == "Los Zerg han ganado el juego") {
                                notificar();
                                return;
                            }
                            Popup.display(e.getMessage());
                        }

                    }
                    notificar();
                });
            }
            close(buttonAtacar);
        });
    }

    private boolean chequearEdificio(Object o) {
        return (o.getClass() == Pilon.class ||o.getClass() == Acceso.class ||o.getClass() == Asimilador.class ||o.getClass() == NexoMineral.class ||o.getClass() == PuertoEstelar.class ||
               o.getClass() == Criadero.class ||o.getClass() == Espiral.class ||o.getClass() == Guarida.class ||o.getClass() == ReservaDeReproduccion.class ||o.getClass() == Extractor.class);

    }

    private void setOnActionMoverUnidad(Button boton, Posicion pos) {
        boton.setOnAction(any -> {
            Set<Button> buttons = new HashSet<>();
            for (int i = 0; i < manager.getMaxX(); i++) {
                for (int j = 0; j < manager.getMaxY(); j++) {
                    Set<Node> nodeButton = floorGrid.lookupAll(ButtonIds.GRIDBUTTON.getLookupName());
                    for (Node n : nodeButton) {
                        buttons.add((Button) n);
                    }
                }
            }
            for (Button b : buttons) {
                b.setOnAction(action -> {
                    Posicion posicion = new Posicion(GridPane.getColumnIndex(b), GridPane.getRowIndex(b));
                    try{
                        manager.moverUnidad(posicion, (Unidad) manager.getAt(pos) );
                    }catch (RuntimeException e){
                        Popup.display(e.getMessage());
                    }
                    notificar();
                });
            }
            close(boton);
        });
    }
    
    private GrillaBoton defaultBoton() {
        return (Object o, Button botonaso, Economia economia, Posicion pos) -> {
            /* To debug
            botonaso.setOnAction(any -> {
                Popup.display("default (resultado de que el boton no tiene comportamiento, si deberia tenerlo, esto es un error)");
            });
             */
        };
    }


    //MAL NOMBRE NO SE ENTIENDE QUE HACE
    public void setComportamiento(Object objeto, Button boton, Posicion posicion, Economia economia) {
        GrillaBoton comportamiento = botones.getOrDefault(objeto.getClass(), defaultBoton());
        comportamiento.setOnActionDeGrilla(objeto, boton, economia, posicion);
    }


    private void close(Button boton) {
        ((Stage) boton.getScene().getWindow()).close();
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
