package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.tiles.FloorType;
import edu.fiuba.algo3.modelo.tiles.Tile;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestTile {

    final FloorType floorType = mock(FloorType.class);
    final Construccion construccion = mock(Criadero.class);

    @Test
    public void creoUnaTileYNoTieneNingunaConstruccion() {
        final Tile tile = new Tile(floorType);
        Assertions.assertNull(tile.getConstruccion());
    }
}
