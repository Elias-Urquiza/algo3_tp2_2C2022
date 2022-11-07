package edu.fiuba.algo3.modelo.tiles;

import edu.fiuba.algo3.modelo.Construccion;

public class Tile {
    private FloorType floor;
    private Construccion construccion;

    public Tile(final FloorType floor) {
        this.construccion = null;
        this.floor = floor;
    }

    public Construccion getConstruccion() {
        return construccion;
    }
}
