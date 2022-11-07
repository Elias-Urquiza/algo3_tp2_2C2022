package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;

public interface FloorType {
    void buildOn(Construccion construccion) throws RuntimeException;
}
