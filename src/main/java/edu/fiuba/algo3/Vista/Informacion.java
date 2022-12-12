package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.util.HashMap;

public class Informacion extends HBox {


    PartidaJugadores partida;
    HashMap<Raza, Economia> economias;

    public Informacion(PartidaJugadores partida, HashMap<Raza, Economia> economias) {
        this.economias = economias;
        this.partida = partida;
        setDefaultInformation();
        setAlignment(Pos.CENTER);
        this.setSpacing(10);
        /*
        this.setStyle("-fx-background-color: #336699;");
        //----- B o t o n e s del la caja de abajo
        Label mineral = new Label("Comentario");
        mineral.setPrefSize(100, 20);
        mineral.setText("mineral: %s", economia.getMinerales() );

        Button buttonProjected = new Button("siVesEstoEsPorqueFunca");
        buttonProjected.setPrefSize(100, 20);
        //-----

        //---- le enchufas a la Hbox los botones
        this.getChildren().addAll(buttonCurrent, buttonProjected);
        //----
        */
    }

    public void setDefaultInformation() {
        Label turno = new Label(String.format("Es el turno de %s\n", partida.getJugadorActivo().getNombre()));
        Circle color = new Circle();
        color.setFill(Paint.valueOf(partida.getJugadorActivo().getColor().getHex()));
        color.setRadius(30);
        turno.setFont(new Font(30));
        Label resources = getMoneyLabel();
        resources.setFont(new Font(30));
        this.getChildren().addAll(turno, color, resources);
    }

    private Label getMoneyLabel() {
        Economia econToShow = economias.get(partida.getJugadorActivo().getRaza());
        Label label = new Label();

        label.setText(String.format("Mineral disponible: %s\nGas vespeno disponible: %s", econToShow.getMineral(), econToShow.getGasVespeno()));
        return label;
    }
}
