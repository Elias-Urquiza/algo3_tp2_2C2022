package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controllers.GameController;
import edu.fiuba.algo3.modelo.jugadores.PartidaJugadores;
import edu.fiuba.algo3.modelo.tiles.Manager;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class ObservadorConstrucciones implements Observer{

    private GameController gameController;
    private LinkedList<Observer> listaDeObservers;


    public ObservadorConstrucciones(GameController gameController, LinkedList<Observer> listaDeObservers) {
        this.gameController = gameController;
        this.listaDeObservers = listaDeObservers;
    }

    public void update() {
        gameController.ponerJuego(listaDeObservers);
    }
}
