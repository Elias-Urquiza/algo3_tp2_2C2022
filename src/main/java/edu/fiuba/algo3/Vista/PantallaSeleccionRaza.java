package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.jugadores.Color;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class PantallaSeleccionRaza {
    public PantallaSeleccionRaza() {

    }

    public Pane crearPantalla() {
        Pane pane = new Pane();
        List<String> razaOptions = getRazaOptions();
        List<String> coloresOptions = getColorOptions();

        label(500, 100, pane, "AlgoStar", Ids.TITLELABEL.getName(), new Font("Arial", 30));

        input(100, 400, pane, "Ingrese nombre Jugador1", Ids.NOMBRE1.getName());
        input(500, 400, pane, "Ingrese nombre Jugador2", Ids.NOMBRE2.getName());

        dropdown(100, 450, pane, "Seleccione raza para Jugador1", Ids.RAZA1.getName(), razaOptions);
        dropdown(500, 450, pane, "Seleccione raza para Jugador2", Ids.RAZA2.getName(), razaOptions);

        dropdown(100, 500, pane, "Seleccione color para Jugador1", Ids.COLOR1.getName(), coloresOptions);
        dropdown(500, 500, pane, "Seleccione color para Jugador2", Ids.COLOR2.getName(), coloresOptions);

        button(300, 600, pane, "Iniciar partida", Ids.STARTGAME.getName());

        return pane;
    }

    public void input(int x, int y, Pane pane, String texto, String id) {
        TextField inputTexto = new TextField();
        inputTexto.relocate(x, y);
        inputTexto.setId(id);
        inputTexto.setPromptText(texto);
        pane.getChildren().add(inputTexto);
    }

    public void dropdown(int x, int y, Pane pane, String texto, String id, List<String> options) {
        ComboBox drop = new ComboBox<>();
        drop.relocate(x, y);
        drop.setId(id);
        drop.setPromptText(texto);
        options.forEach(option -> drop.getItems().add(option));
        pane.getChildren().add(drop);
    }

    public void button(int x, int y, Pane pane, String texto, String id) {
        Button button = new Button(texto);
        button.relocate(x, y);
        button.setId(id);
        pane.getChildren().add(button);
    }

    private void label(int x, int y, Pane pane, String texto, String id, Font font) {
        Label label = new Label(texto);
        label.relocate(x, y);
        label.setId(id);
        label.setFont(font);
        pane.getChildren().add(label);
    }
    private List<String> getRazaOptions() {
        List<String> razas = new ArrayList<>();
        razas.add(Raza.PROTOSS.name());
        razas.add(Raza.ZERG.name());
        return razas;
    }

    private List<String> getColorOptions() {
        List<String> colores = new ArrayList<>();
        for(Color c : Color.values()) {
            colores.add(c.name());
        }
        return colores;
    }


}
