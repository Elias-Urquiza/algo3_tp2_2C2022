package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.tiles.Tile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        final Tablero tablero = new Tablero(20, 20);
        final List<Tile> neighborsOf = tablero.getNeighbours(1, 0);
        //launch();
    }

}