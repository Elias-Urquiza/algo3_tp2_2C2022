package edu.fiuba.algo3.Vista.grilla;

import edu.fiuba.algo3.Vista.Popup;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.buildings.protoss.Acceso;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import java.util.HashMap;

public class HandlerBotonesGrilla {

    HashMap<Class, GrillaBoton> botones;
    public HandlerBotonesGrilla() {
        botones = new HashMap<>();
        handleBotonesGrid(botones);
    }

    public void handleBotonesGrid(HashMap mapa) {

        GrillaBoton criaderoAccion = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.display("Criadero");
            });
        };
        mapa.put(Criadero.class, criaderoAccion);

        GrillaBoton acceso = (Button botonaso, Economia economia, Posicion pos) -> {
            botonaso.setOnAction(action -> {
                Popup.display("Acceso");
            });
        };
        mapa.put(Acceso.class, acceso);
    }

    private GrillaBoton defaultBoton() {
        return (Button botonaso, Economia economia, Posicion pos) -> {};
    }

    public void set(Object objeto, Button boton, Posicion posicion, Economia economia) {
        GrillaBoton comportamiento = botones.getOrDefault(objeto.getClass(), defaultBoton());
        comportamiento.setOnActionDeGrilla(boton, economia, posicion);
    }
}
