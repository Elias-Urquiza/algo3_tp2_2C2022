package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Suministros;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
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
    Manager manager;

    public Informacion(Manager manager, PartidaJugadores partida, HashMap<Raza, Economia> economias) {
        this.economias = economias;
        this.partida = partida;
        this.manager = manager;
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
        Label suministros = getSuministrosLabel();
        this.getChildren().addAll(turno, color, resources, suministros);
    }

    private Label getMoneyLabel() {
        Economia econToShow = economias.get(partida.getJugadorActivo().getRaza());
        Label label = new Label();

        label.setText(String.format("Mineral disponible: %s\nGas vespeno disponible: %s", econToShow.getMineral(), econToShow.getGasVespeno()));
        label.setFont(new Font(30));
        return label;
    }

    private Label getSuministrosLabel() {
        Suministros sum = manager.getSuministrosFor(partida.getJugadorActivo().getRaza());
        Label label = new Label();
        label.setText(String.format("Suministros: %s / %s", sum.getSuministros(), sum.getMaxSuministros()));
        label.setFont(new Font(30));
        return label;
    }
}
