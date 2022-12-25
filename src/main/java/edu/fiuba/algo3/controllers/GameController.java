package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.Vista.*;
import edu.fiuba.algo3.Vista.grilla.PantallaTablero;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.jugadores.Color;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class GameController {

    final Stage pantalla;
    final Manager manager;
    final int dimensionX = 30;
    final int dimensionY = 30;
    final int pantallaX = 1000;
    final int pantallaY = 1000;
    PartidaJugadores players;
    HashMap<Raza, Economia> economias;

    public GameController(Stage pantalla) {

        this.pantalla = pantalla;
        this.manager = new Manager(dimensionX, dimensionY);
        this.players = new PartidaJugadores();
        economias = new HashMap<>();

        Economia economiaZerg = new Economia();
        economiaZerg.ingresarMineral(1000);
        economiaZerg.ingresarGasVespeno(1000);

        Economia economiaProtoss = new Economia();
        economiaProtoss.ingresarMineral(1000);
        economiaProtoss.ingresarGasVespeno(1000);
        economias.put(Raza.ZERG, economiaZerg);
        economias.put(Raza.PROTOSS, economiaProtoss);
    }


    public void iniciarPantallaSeleccion() {
        Pane pane = new PantallaSeleccionRaza().crearPantalla();
        Scene scene = new Scene(pane, pantallaX, pantallaY);

        pantalla.setScene(scene);
        pantalla.show();

        Button botonInicio = (Button) pane.lookup(ButtonIds.STARTGAME.getLookupName());
        botonInicio.setOnAction(any -> {
            if(checkForSelectionPantallaSeleccion(pane)) {
                String nombre1 = ((TextField) pane.lookup(ButtonIds.NOMBRE1.getLookupName())).getText();
                String nombre2 = ((TextField) pane.lookup(ButtonIds.NOMBRE2.getLookupName())).getText();

                Raza raza1 = Raza.valueOf((String) ((ComboBox) pane.lookup(ButtonIds.RAZA1.getLookupName())).getSelectionModel().getSelectedItem());
                Raza raza2 = Raza.valueOf((String) ((ComboBox) pane.lookup(ButtonIds.RAZA2.getLookupName())).getSelectionModel().getSelectedItem());

                Color color1 = Color.valueOf((String) ((ComboBox) pane.lookup(ButtonIds.COLOR1.getLookupName())).getSelectionModel().getSelectedItem());
                Color color2 = Color.valueOf((String) ((ComboBox) pane.lookup(ButtonIds.COLOR2.getLookupName())).getSelectionModel().getSelectedItem());
                try {
                    players.setJugador(raza1, nombre1, color1);
                    players.setJugador(raza2, nombre2, color2);
                    iniciarJuego();
                } catch (RuntimeException e) {
                    Popup.display(e.getMessage() );
                    players = new PartidaJugadores();
                }
            } else {
                Popup.display("Completa los campos para continuar");
            }
        });

        pantalla.setScene(scene);
    }

    public void iniciarJuego() {
        LinkedList<Observer> listaDeObservers = new LinkedList<>();
        ObservadorConstrucciones o = new ObservadorConstrucciones(this, listaDeObservers);
        listaDeObservers.add(o);

        ponerJuego(listaDeObservers);
    }

    public void ponerJuego(LinkedList<Observer> listaDeObservers){
        BorderPane pantallaJuego = new PantallaTablero(manager).crearPantalla(manager, players, economias, dimensionX, dimensionY, pantallaX, pantallaX, listaDeObservers);
        Scene scene = new Scene(pantallaJuego, pantallaX, pantallaY);

        pantalla.setScene(scene);
        pantalla.show();
        try {
            manager.checkForWinning();
        } catch (RuntimeException e) {
            StackPane pantallaGanador = new PantallaDeGanador().crearPantalla(pantalla, pantallaX, pantallaX, e.getMessage(),
                    manager.getStatsFor(players.getJugadorActivo().getRaza()));
            Scene sceneWinner = new Scene(pantallaGanador, pantallaX, pantallaY);
            pantalla.setScene(sceneWinner);
            pantalla.show();
        }
    }

    private boolean checkForSelectionPantallaSeleccion(Pane pane) {
        return !((TextField) pane.lookup(ButtonIds.NOMBRE1.getLookupName())).getText().isEmpty()
                && !((TextField) pane.lookup(ButtonIds.NOMBRE2.getLookupName())).getText().isEmpty()
                && Objects.nonNull(((ComboBox) pane.lookup(ButtonIds.RAZA1.getLookupName())).getSelectionModel().getSelectedItem())
                && Objects.nonNull(((ComboBox) pane.lookup(ButtonIds.RAZA2.getLookupName())).getSelectionModel().getSelectedItem())
                && Objects.nonNull(((ComboBox) pane.lookup(ButtonIds.COLOR1.getLookupName())).getSelectionModel().getSelectedItem())
                && Objects.nonNull(((ComboBox) pane.lookup(ButtonIds.COLOR1.getLookupName())).getSelectionModel().getSelectedItem());
    }
}
