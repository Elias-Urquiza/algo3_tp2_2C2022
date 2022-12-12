package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.HashMap;
import java.util.Objects;

public class PantallaTablero {

    GridPane floorGrid;
    GridPane buildingGrid;
    HashMap<Raza, Economia> economias;
    public PantallaTablero() {
        this.floorGrid = new GridPane();
        this.buildingGrid = new GridPane();

    }
    public BorderPane crearPantalla(Manager manager, PartidaJugadores partida, HashMap<Raza, Economia> economias, int tablerox, int tableroy, int pantallax, int pantallay) {

        BorderPane borderPane = new BorderPane();
        double gridSizeX = pantallax/1.5;
        double gridSizeY = pantallay/1.5;

        floorGrid.setPrefSize(gridSizeX, gridSizeY);
        buildingGrid.setPrefSize(gridSizeX, gridSizeY);

        populateFloorGrid(manager, floorGrid, tablerox, tableroy, gridSizeX, gridSizeY);

        Informacion cajaAbajo = new Informacion(partida, economias);
        VBox cajaDeLaDerecha = new MenuDeConstrucciones(manager, floorGrid, partida, economias).getMenu();
        borderPane.setRight(cajaDeLaDerecha);
        borderPane.setCenter(floorGrid);
        borderPane.setBottom(cajaAbajo);
        return borderPane;
    }

    private void populateFloorGrid(Manager manager, GridPane tilePane, int tablerox, int tableroy, double gridX, double gridY) {
        for (int i = 0; i < tablerox; i++) {
            for (int j = 0; j < tableroy; j++) {
                Object o = manager.getFloorAt(new Posicion(i, j));
                String imagePath = Sprites.getFloorSprite(o.getClass());
                if (Objects.isNull(imagePath)) {
                    imagePath = Sprites.getDefaultSprite();
                    Image image = new Image(imagePath);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(gridY / tableroy);
                    imageView.setFitWidth(gridX / tablerox);
                    imageView.setPreserveRatio(true);
                    tilePane.add(imageView, i, j);
                } else {
                    Button botonPiso = new Button();
                    Image image = new Image(imagePath);
                    botonPiso.setId(ButtonIds.FLOORBUTTON.getName());
                    botonPiso.setPrefSize(gridY/tableroy, gridX/tablerox);
                    BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER, new BackgroundSize(botonPiso.getWidth(), botonPiso.getHeight(), true, true, true, false));
                    Background bg = new Background(backgroundImage);
                    botonPiso.setBackground(bg);
                    tilePane.add(botonPiso, i, j);
                }
            }
        }
    }

    private void populateBuildingGrid(Manager manager, GridPane tilePane, int tablerox, int tableroy, double gridX, double gridY) {
        for (int i = 0; i < tablerox; i++) {
            for (int j = 0; j < tableroy; j++) {
                Object o = manager.getFloorAt(new Posicion(i, j));
                String imagePath = Sprites.getFloorSprite(o.getClass());
                if (Objects.isNull(imagePath)) {
                    imagePath = Sprites.getDefaultSprite();
                    Image image = new Image(imagePath);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(gridY / tableroy);
                    imageView.setFitWidth(gridX / tablerox);
                    imageView.setPreserveRatio(true);
                    tilePane.add(imageView, i, j);
                } else {
                    Button botonPiso = new Button();
                    Image image = new Image(imagePath);
                    botonPiso.setId(ButtonIds.BUILDING.getName());
                    botonPiso.setPrefSize(gridY/tableroy, gridX/tablerox);
                    BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER, new BackgroundSize(botonPiso.getWidth(), botonPiso.getHeight(), true, true, true, false));
                    Background bg = new Background(backgroundImage);
                    botonPiso.setBackground(bg);
                    tilePane.add(botonPiso, i, j);
                }
            }
        }
    }

}
