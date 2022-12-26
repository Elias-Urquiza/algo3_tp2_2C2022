package edu.fiuba.algo3.Vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Popup {

    public static void displayEndgame(LinkedList<String> info, String text) {
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Fin del juego");
        Label label1= new Label(text);
        Button button1= new Button("Fin");
        button1.setOnAction(e -> System.exit(200));
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        for(String s : info) {
            System.out.println(s);
        }
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public static void display(String text)
    {
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("This is a pop up window");
        Label label1= new Label(text);
        Button button1= new Button("Go back");
        button1.setOnAction(e -> popupwindow.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }

    public static void displayAMenu(LinkedList<String> info, String text, LinkedList<Button> botones)
    {
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("This is a pop up window");

        Button button1= new Button("Go back");
        button1.setOnAction(e -> popupwindow.close());

        VBox layout= new VBox(10 * botones.size() );
        layout.getChildren().addAll(button1);
        layout.setAlignment(Pos.CENTER);

        for(Button boton: botones) {
            layout.getChildren().addAll(boton);
            layout.setAlignment(Pos.CENTER);
        }

        BorderPane pane = new BorderPane(layout);
        pane.setCenter(layout);

        VBox infoBox = new VBox(10 * info.size());

        Text campoDeTexto = new Text(String.join("\n", info));
        infoBox.getChildren().addAll(campoDeTexto);
        pane.setLeft(infoBox);
        Scene scene1= new Scene(pane, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }


}

