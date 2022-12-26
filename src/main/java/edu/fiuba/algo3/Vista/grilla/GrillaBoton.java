package edu.fiuba.algo3.Vista.grilla;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.control.Button;

public interface GrillaBoton {
    void setOnActionDeGrilla(Object obj, Button boton, Economia economia, Posicion pos);
}
