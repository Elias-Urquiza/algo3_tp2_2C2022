package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;

import java.util.List;

public interface FloorType {
    public void buildOn(Construccion construccion, Construccion guardar) throws RuntimeException;

}
