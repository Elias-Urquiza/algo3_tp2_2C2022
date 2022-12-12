package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.Vista.ButtonIds;
import edu.fiuba.algo3.Vista.PantallaSeleccionRaza;
import edu.fiuba.algo3.Vista.PantallaTablero;
import edu.fiuba.algo3.Vista.Popup;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.jugadores.Color;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Objects;

public class GameController {

    final Stage pantalla;
    final Manager manager;
    final int dimensionX = 20;
    final int dimensionY = 20;
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
        economiaZerg.ingresarMineral(200);

        Economia economiaProtoss = new Economia();
        economiaProtoss.ingresarMineral(200);

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
                    Popup.display(e.getMessage() + "me rompi aca capox");
                    players = new PartidaJugadores();
                }
            } else {
                Popup.display("Completa los campos para continuar");
            }
        });

        pantalla.setScene(scene);
    }

    public void iniciarJuego() {
        BorderPane pantallaJuego = new PantallaTablero().crearPantalla(manager, players, economias, dimensionX, dimensionY, pantallaX, pantallaY);
        Scene scene = new Scene(pantallaJuego, pantallaX, pantallaY);

        pantalla.setScene(scene);
        pantalla.show();
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
