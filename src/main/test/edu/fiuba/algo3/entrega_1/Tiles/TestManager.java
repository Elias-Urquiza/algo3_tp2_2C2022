package edu.fiuba.algo3.entrega_1.Tiles;

import edu.fiuba.algo3.mocks.MockEconomia;
import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.buildings.zerg.Criadero;
import edu.fiuba.algo3.modelo.tiles.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestManager {

    private Manager manager;
    private static final Economia economia = new MockEconomia();
    private static int X = 0;
    private static int Y = 0;
    @BeforeEach
    public void initEach() {
        manager = new Manager();
    }


    @Test
    public void seConstruyeUn() {

    }
}
