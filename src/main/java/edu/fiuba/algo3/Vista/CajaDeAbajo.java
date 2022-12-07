package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CajaDeAbajo extends HBox {

    public CajaDeAbajo() {

        setAlignment(Pos.BOTTOM_LEFT);
        this.setPadding(new Insets(30, 50, 30, 50));
        this.setSpacing(10);
        this.setStyle("-fx-background-color: #336699;");
        //----- B o t o n e s del la caja de abajo
        Button buttonCurrent = new Button("Comentario");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("siVesEstoEsPorqueFunca");
        buttonProjected.setPrefSize(100, 20);
        //-----

        //---- le enchufas a la Hbox los botones
        this.getChildren().addAll(buttonCurrent, buttonProjected);
        //----

    }
}
