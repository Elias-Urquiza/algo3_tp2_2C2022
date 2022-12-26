package edu.fiuba.algo3.Vista.menu;

import edu.fiuba.algo3.Vista.*;
import edu.fiuba.algo3.Vista.grilla.HandlerBotonesGrilla;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MenuDeConstrucciones implements Observable {

    VBox zergBuildings;
    VBox protossBuildings;
    Manager manager;
    GridPane floorGrid;
    HashMap economias;
    PartidaJugadores partidaJugadores;
    LinkedList<Observer> observers;
    HandlerBotonesGrilla handlerBotonesGrilla;

    public MenuDeConstrucciones(Manager manager, GridPane floorGrid, PartidaJugadores partida, HashMap economias, LinkedList<Observer> observers, HandlerBotonesGrilla handlerBotonesGrilla ){
        this.manager = manager;
        this.economias = economias;
        this.partidaJugadores = partida;
        this.floorGrid = floorGrid;
        this.observers = observers;
        protossBuildings = new VBox();
        zergBuildings = new VBox();
        this.handlerBotonesGrilla = handlerBotonesGrilla;
    }

    public VBox mostrarMenuProtoss() {
        protossBuildings.setAlignment(Pos.TOP_RIGHT);
        protossBuildings.setPadding(new Insets(40));
        protossBuildings.setSpacing(8);

        Text title = new Text("Edificios Protoss");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        protossBuildings.getChildren().add(title);

        Button options[] = getProtossButtons();

        for (int i=0; i<6; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            protossBuildings.getChildren().add(options[i]);
        }
        handleProtossButtons();
        return protossBuildings;
    }

    public Button[] getProtossButtons() {
        Button buildPilon = new Button("Construir Pilon");
        buildPilon.setId(ButtonIds.CONSTRUIRPILON.getName());

        Button buildNexoMineral = new Button("Construir Nexo Mineral");
        buildNexoMineral.setId(ButtonIds.CONSTRUIRNEXOMINERAL.getName());

        Button buildAsimilador = new Button("Construir Asimilador ");
        buildAsimilador.setId(ButtonIds.CONSTRUIRASIMILADOR.getName());

        Button buildAcceso = new Button("Construir Acceso");
        buildAcceso.setId(ButtonIds.CONSTRUIRACCESO.getName());

        Button buildPuertoEstelar = new Button("Construir Reserva de Puerto Estelar");
        buildPuertoEstelar.setId(ButtonIds.CONSTRUIRCPUERTOESTELAR.getName());

        return new Button[] {
                buildPilon,
                buildNexoMineral,
                buildAsimilador,
                buildAcceso,
                buildPuertoEstelar,
                getPassTurnButton()
        };
    }
    private void handleProtossButtons() {

        CrearEstructurasBoton pilon = (Economia economia, Posicion pos) -> {
            try {
                manager.construirPilonEn(pos, new Pilon(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" == e.getMessage())
                    economia.ingresarMineral(100);

                throw e;
            }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRPILON, pilon, protossBuildings);

        CrearEstructurasBoton nexoMineral = (Economia economia, Posicion pos) -> {

            try {
                manager.construirNexoMineral(pos, new NexoMineral(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" == e.getMessage())
                    economia.ingresarMineral(50);

                throw e;
            }

        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRNEXOMINERAL, nexoMineral, protossBuildings);

        CrearEstructurasBoton asimilador = (Economia economia, Posicion pos) -> {
            try {
                manager.construirAsimilador(pos, new Asimilador(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" == e.getMessage())
                    economia.ingresarMineral(100);
                throw e;
            }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRASIMILADOR, asimilador, protossBuildings);

        CrearEstructurasBoton acceso = (Economia economia, Posicion pos) -> {
            try {
                manager.construirProtoss(pos, new Acceso(economia, pos));
            }catch (RuntimeException e) {
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(150);
                }
                throw  e;
            }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRACCESO, acceso, protossBuildings);

        CrearEstructurasBoton puertoEstelar = (Economia economia, Posicion pos) -> {
            try {
                manager.construirProtoss(pos, new PuertoEstelar(economia, pos));
            }catch (RuntimeException e){
                if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                    economia.ingresarMineral(150);
                    economia.ingresarGasVespeno(150);
                }
                throw e;
            }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRCPUERTOESTELAR, puertoEstelar, protossBuildings);

    }

    public VBox mostrarMenuZerg() {
        zergBuildings.setAlignment(Pos.TOP_RIGHT);
        zergBuildings.setPadding(new Insets(40));
        zergBuildings.setSpacing(8);

        Text title = new Text("||\uD835\uDE79⚍  ᓭ⍑ᔑꖎꖎ ↸ᒷᓭℸ ̣∷\uD835\uDE79|| ℸ ̣⍑ᒷᒲ");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        zergBuildings.getChildren().add(title);


        Button options[] = getZergButtons();

        for (Button b : options) {
            b.setPrefSize(200, 20);
        }

        for (int i=0; i<6; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            zergBuildings.getChildren().add(options[i]);
        }
        handleZergButtons();
        return zergBuildings;
    }

    public VBox getMenu() {
        return Raza.PROTOSS.equals(partidaJugadores.getJugadorActivo().getRaza()) ? mostrarMenuProtoss() : mostrarMenuZerg();
    }

    public Button[] getZergButtons() {
        Button buildCriadero = new Button("Construir Criadero");
        buildCriadero.setId(ButtonIds.CONSTRUIRCRIADERO.getName());

        Button buildEspiral = new Button("Construir Espiral");
        buildEspiral.setId(ButtonIds.CONSTRUIRESPIRAL.getName());

        Button buildExtractor = new Button("Construir Extractor ");
        buildExtractor.setId(ButtonIds.CONSTRUIREXTRACTOR.getName());

        Button buildGuarida = new Button("Construir Guarida");
        buildGuarida.setId(ButtonIds.CONSTRUIRGUARIDA.getName());

        Button buildReserva = new Button("Construir Reserva de Reproduccion");
        buildReserva.setId(ButtonIds.CONSTRUIRRESERVA.getName());

        //  EL ZANGANO NO ES UN EDIFICIO
        // Button buildZangano = new Button("Construir Zangano");
        // buildZangano.setId(ButtonIds.CONSTRUIRZANGANO.getName());

        return new Button[] {
                buildCriadero,
                buildEspiral,
                buildExtractor,
                buildGuarida,
                buildReserva,
                getPassTurnButton(),
        };
    }

    public void handleZergButtons() {

        CrearEstructurasBoton criadero = (Economia economia, Posicion pos) -> {
        try {
            manager.construirCriaderoEn(pos, new Criadero(economia, pos));
        }catch (RuntimeException e){
            if("No se puede gastar la cantidad indicada" == e.getMessage())
                economia.ingresarMineral(200);

            throw e;
        }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRCRIADERO, criadero, zergBuildings);

        CrearEstructurasBoton extractor = (Economia economia, Posicion pos) -> {

        try {
            manager.construirExtractor(pos, new Extractor(economia, pos));
        }catch (RuntimeException e){
            if("No se puede gastar la cantidad indicada" == e.getMessage())
                economia.ingresarMineral(100);

            throw e;
        }

        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIREXTRACTOR, extractor, zergBuildings);

        CrearEstructurasBoton reserva = (Economia economia, Posicion pos) -> {
        try {
            manager.construirZerg(pos, new ReservaDeReproduccion(economia, pos));
        }catch (RuntimeException e){
            if("No se puede gastar la cantidad indicada" == e.getMessage())
                economia.ingresarMineral(150);
            throw e;
        }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRRESERVA, reserva, zergBuildings);

        CrearEstructurasBoton guarida = (Economia economia, Posicion pos) -> {
        try {
            manager.construirZerg(pos, new Guarida(economia, pos));
        }catch (RuntimeException e) {
            if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                economia.ingresarMineral(200);
                economia.ingresarGasVespeno(100);
            }
            throw  e;
        }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRGUARIDA, guarida, zergBuildings);

        CrearEstructurasBoton espiral = (Economia economia, Posicion pos) -> {
        try {
            manager.construirZerg(pos, new Espiral(economia, pos));
        }catch (RuntimeException e){
            if("No se puede gastar la cantidad indicada" == e.getMessage()) {
                economia.ingresarMineral(150);
                economia.ingresarGasVespeno(100);
            }
            throw e;
        }
        };
        handleDeBotonesConstruccion(ButtonIds.CONSTRUIRESPIRAL, espiral, zergBuildings);

    }

    public void handleDeBotonesConstruccion(ButtonIds idDelBoton, CrearEstructurasBoton funcion, VBox Buildings) {
        Button boton = (Button) Buildings.lookup(idDelBoton.getLookupName());
        boton.setOnAction(any -> {
            Set<Button> buttons = new HashSet<>();
            Set<Node> nodeButton = floorGrid.lookupAll(ButtonIds.GRIDBUTTON.getLookupName());
            for (Node n : nodeButton) {
                buttons.add((Button) n);
            }
            for (Button b : buttons) {
                b.setOnAction(action -> {
                    Posicion pos = new Posicion(GridPane.getColumnIndex(b), GridPane.getRowIndex(b));
                    Economia economia = (Economia) economias.get(partidaJugadores.getJugadorActivo().getRaza());
                    try {
                        funcion.accionBoton(economia, pos);
                    } catch (RuntimeException e) {
                        Popup.display(e.getMessage());
                    }
                    notificar();
                });
            }
        });
    }


    private Button getPassTurnButton() {
        Button passTurn = new Button("Pasar turno");
        passTurn.setId(ButtonIds.PASARTURNO.getName());
        passTurn.setOnAction(actionEvent -> {
            if(partidaJugadores.getJugadorActivo().getRaza() == Raza.PROTOSS ) {
                partidaJugadores.cambiarTurno();
                try {
                    manager.pasarTurnoZerg();
                } catch (RuntimeException e) {
                    Popup.display(e.getMessage() + "\n" + ", cerra el juego se termino");
                }
            }
            else{
                partidaJugadores.cambiarTurno();
                try {
                    manager.pasarTurnoProtoss();
                }catch (RuntimeException e){
                    Popup.display(e.getMessage() + "\n" + ", cerra el juego se termino");
                }
            }
            notificar();
        });
        return passTurn;
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
        for (Observer o :observers)
            o.update();
    }
}
