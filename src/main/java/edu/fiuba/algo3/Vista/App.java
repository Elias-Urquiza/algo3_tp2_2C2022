package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        // usamos una Vbox y una Hbox
        CajaDeAbajo cajaAbajo = new CajaDeAbajo();
        CajaDeLaDerecha cajaDeLaDerecha = new CajaDeLaDerecha();
        StackPane stackPane = new StackPane(cajaAbajo, cajaDeLaDerecha);



        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(stackPane, 1000, 700);
        stage.setScene(scene);


        stage.show();
    }

    public static void main(String[] args) {

        /*Economia econ = new Economia();
        econ.ingresarMineral(1000000000);
        econ.ingresarGasVespeno(100000000);
        Manager m = new Manager(30, 30);
        */launch();
    }



}
