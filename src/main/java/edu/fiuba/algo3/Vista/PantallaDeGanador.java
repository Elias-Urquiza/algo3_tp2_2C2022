package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controllers.GameController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.LinkedList;

public class PantallaDeGanador extends Application {

    public StackPane crearPantalla(Stage stage, int pantallax, int pantallay, String title, LinkedList<String> stats) {
        StackPane stackPane = new StackPane();
        double gridSizeX = pantallax/1.5;
        double gridSizeY = pantallay/1.5;
        stackPane.setPrefSize(gridSizeX, gridSizeY);
        VBox buttons = new VBox();
        buttons.getChildren().addAll(mainMenuButton(stage), closeGameButton());


        Text titleText = new Text(title);
        titleText.setFont(new Font(50));

        HBox titleBox = new HBox();
        titleBox.getChildren().addAll(titleText);
        VBox statsBox = new VBox();
        Text info = new Text(String.join("\n", stats));
        info.setFont(new Font(25));
        statsBox.getChildren().addAll(info);
        statsBox.setAlignment(Pos.BASELINE_LEFT);
        titleBox.setAlignment(Pos.TOP_CENTER);
        buttons.setAlignment(Pos.CENTER);

        stackPane.getChildren().addAll(titleBox, statsBox, buttons);
        return stackPane;
    }

    private Button mainMenuButton(Stage stage) {
        Button b = new Button("Ir al menu principal");
        b.setOnAction(a -> {
            start(stage);
        });
        return b;
    }

    private Button closeGameButton() {
        Button b = new Button("Cerrar el juego");
        b.setOnAction(a -> {
            System.exit(200);
        });
        return b;
    }

    @Override
    public void start(Stage stage) {
        GameController controller = new GameController(stage);
        controller.iniciarPantallaSeleccion();
    }
}
