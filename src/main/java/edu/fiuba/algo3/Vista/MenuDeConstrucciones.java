package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MenuDeConstrucciones {

    VBox zergBuildings;
    VBox protossBuildings;
    Manager manager;
    GridPane floorGrid;
    HashMap economias;
    PartidaJugadores partidaJugadores;

    public MenuDeConstrucciones(Manager manager, GridPane floorGrid, PartidaJugadores partida, HashMap economias){
        this.manager = manager;
        this.economias = economias;
        this.partidaJugadores = partida;
        this.floorGrid = floorGrid;
        protossBuildings = new VBox();
        zergBuildings = new VBox();
    }

    public VBox mostrarMenuProtoss() {
        protossBuildings.setAlignment(Pos.TOP_RIGHT);
        protossBuildings.setPadding(new Insets(40));
        protossBuildings.setSpacing(8);

        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        protossBuildings.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[] {
                new Hyperlink("P"),
                new Hyperlink("R"),
                new Hyperlink("O"),
                new Hyperlink("T")};

        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            protossBuildings.getChildren().add(options[i]);
        }
        return protossBuildings;
    }

    public VBox mostrarMenuZerg() {
        zergBuildings.setAlignment(Pos.TOP_RIGHT);
        zergBuildings.setPadding(new Insets(40));
        zergBuildings.setSpacing(8);

        Text title = new Text("||\uD835\uDE79⚍  ᓭ⍑ᔑꖎꖎ ↸ᒷᓭℸ ̣∷\uD835\uDE79|| ℸ ̣⍑ᒷᒲ");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        zergBuildings.getChildren().add(title);


        Button options[] = getZergButtons();

        for (Button b : options) {
            b.setPrefSize(200, 20);
        }

        for (int i=0; i<6; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            zergBuildings.getChildren().add(options[i]);
        }
        handleZergButtons();
        return zergBuildings;
    }

    public VBox getMenu() {
        return Raza.PROTOSS.equals(partidaJugadores.getJugadorActivo().getRaza()) ? mostrarMenuProtoss() : mostrarMenuZerg();
    }

    public Button[] getZergButtons() {
        Button buildCriadero = new Button("Construir Criadero");
        buildCriadero.setId(ButtonIds.CONSTRUIRCRIADERO.getName());

        Button buildEspiral = new Button("Construir Espiral");
        buildEspiral.setId(ButtonIds.CONSTRUIRESPIRAL.getName());

        Button buildExtractor = new Button("Construir Extractor ");
        buildExtractor.setId(ButtonIds.CONSTRUIREXTRACTOR.getName());

        Button buildGuarida = new Button("Construir Guarida");
        buildGuarida.setId(ButtonIds.CONSTRUIRGUARIDA.getName());

        Button buildReserva = new Button("Construir Reserva de Reproduccion");
        buildReserva.setId(ButtonIds.CONSTRUIRRESERVA.getName());

        Button buildZangano = new Button("Construir Zangano");
        buildZangano.setId(ButtonIds.CONSTRUIRZANGANO.getName());

        return new Button[] {
                buildCriadero,
                buildEspiral,
                buildExtractor,
                buildGuarida,
                buildReserva,
                buildZangano};
    }

    public void handleZergButtons() {
        handleCriadero();
    }

    public void handleCriadero() {
        Button boton = (Button) zergBuildings.lookup(ButtonIds.CONSTRUIRCRIADERO.getLookupName());
        boton.setOnAction(any -> {
            Set<Button> buttons = new HashSet<>();
            Set<Node> nodeButton = floorGrid.lookupAll(ButtonIds.FLOORBUTTON.getLookupName());
            for (Node n : nodeButton) {
                buttons.add((Button) n);
            }
            for (Button b : buttons) {
                b.setOnAction(action -> {
                    Posicion pos = new Posicion(GridPane.getRowIndex(b), GridPane.getColumnIndex(b));
                    Economia economia = (Economia) economias.get(partidaJugadores.getJugadorActivo().getRaza());
                    try {
                        manager.construirCriaderoEn(pos, new Criadero(economia, pos));
                    } catch (RuntimeException e) {
                        Popup.display(e.getMessage());
                    }
                });
            }
        });
    }
}
