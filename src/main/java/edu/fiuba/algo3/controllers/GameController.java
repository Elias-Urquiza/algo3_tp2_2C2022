package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.Vista.Ids;
import edu.fiuba.algo3.Vista.PantallaSeleccionRaza;
import edu.fiuba.algo3.Vista.Popup;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.jugadores.Color;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {

    final Stage pantalla;
    final Manager manager;
    PartidaJugadores players;

    public GameController(Stage pantalla) {

        this.pantalla = pantalla;
        this.manager = new Manager(50, 50);
        this.players = new PartidaJugadores();
    }


    public void iniciarPantallaSeleccion() {
        Pane pane = new PantallaSeleccionRaza().crearPantalla();
        Scene scene = new Scene(pane, 1000, 700);

        pantalla.setScene(scene);
        pantalla.show();

        Button botonInicio = (Button) pane.lookup(Ids.STARTGAME.getLookupName());
        botonInicio.setOnAction(any -> {
            String nombre1 = ((TextField)pane.lookup(Ids.NOMBRE1.getLookupName())).getText();
            String nombre2 = ((TextField)pane.lookup(Ids.NOMBRE2.getLookupName())).getText();

            Raza raza1 = Raza.valueOf((String)((ComboBox) pane.lookup(Ids.RAZA1.getLookupName())).getSelectionModel().getSelectedItem());
            Raza raza2 = Raza.valueOf((String)((ComboBox) pane.lookup(Ids.RAZA2.getLookupName())).getSelectionModel().getSelectedItem());

            Color color1 = Color.valueOf((String)((ComboBox) pane.lookup(Ids.COLOR1.getLookupName())).getSelectionModel().getSelectedItem());
            Color color2 = Color.valueOf((String)((ComboBox) pane.lookup(Ids.COLOR2.getLookupName())).getSelectionModel().getSelectedItem());
            try {
                players.setJugador(raza1, nombre1, color1);
                players.setJugador(raza2, nombre2, color2);
            } catch (RuntimeException e) {
                Popup.display(e.getMessage());
                players = new PartidaJugadores();
            }
        });

        pantalla.setScene(scene);
    }
}
