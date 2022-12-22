package edu.fiuba.algo3.Vista.grilla;

import edu.fiuba.algo3.Vista.*;
import edu.fiuba.algo3.Vista.grilla.GrillaBoton;
import edu.fiuba.algo3.Vista.menu.MenuDeConstrucciones;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.tiles.Manager;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class PantallaTablero {

    GridPane floorGrid;

    HashMap<Raza, Economia> economias;
    HandlerBotonesGrilla handlerBotones;
    PartidaJugadores partida;

    public PantallaTablero() {
        this.floorGrid = new GridPane();
        this.handlerBotones = new HandlerBotonesGrilla();
    }

    public BorderPane crearPantalla(Manager manager, PartidaJugadores partida, HashMap<Raza, Economia> economias, int tablerox, int tableroy, int pantallax, int pantallay,  LinkedList<Observer> listaDeObservers) {

        BorderPane borderPane = new BorderPane();
        double gridSizeX = pantallax/1.5;
        double gridSizeY = pantallay/1.5;

        floorGrid.setPrefSize(gridSizeX, gridSizeY);
        this.partida = partida;
        this.economias = economias;

        populateFloorGrid(manager, tablerox, tableroy, gridSizeX, gridSizeY);

        Informacion cajaAbajo = new Informacion(partida, economias);

        VBox cajaDeLaDerecha = new MenuDeConstrucciones(manager, floorGrid, partida, economias, listaDeObservers).getMenu();
        borderPane.setRight(cajaDeLaDerecha);
        borderPane.setCenter(floorGrid);
        borderPane.setBottom(cajaAbajo);
        return borderPane;
    }

    public void populateFloorGrid(Manager manager, int tablerox, int tableroy, double gridX, double gridY) {
        for (int i = 0; i < tablerox; i++) {
            for (int j = 0; j < tableroy; j++) {
                Posicion pos = new Posicion(i, j);
                Object o = manager.getFloorAt(pos);
                String imagePath = Sprites.getFloorSprite(o.getClass());
                if (Objects.isNull(imagePath)) {
                    imagePath = Sprites.getDefaultSprite();
                    Image image = new Image(imagePath);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(gridY / tableroy);
                    imageView.setFitWidth(gridX / tablerox);
                    imageView.setPreserveRatio(true);
                    floorGrid.add(imageView, i, j);
                } else {
                    Button botonPiso = new Button();
                    Image image = new Image(imagePath);
                    botonPiso.setId(ButtonIds.GRIDBUTTON.getName());
                    botonPiso.setPrefSize(gridY/tableroy, gridX/tablerox);
                    BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER, new BackgroundSize(botonPiso.getWidth(), botonPiso.getHeight(), true, true, true, false));
                    Background bg = new Background(backgroundImage);
                    botonPiso.setBackground(bg);
                    handlerBotones.set(o, botonPiso, pos, economias.get(partida.getJugadorActivo().getRaza()));
                    floorGrid.add(botonPiso, i, j);
                }
            }
        }
    }


}
