package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.tiles.*;

import java.util.HashMap;

public class Sprites {
    static String path = "file:"+System.getProperty("user.dir")+"/src/main/assets/";
    static HashMap<Class, String> floorSprites = new HashMap<Class, String>() {{
        put(Moho.class, path+"moho.png");
        put(TileVacia.class, path+"vacia.png");
        put(Cristales.class, path+"cristales.png");
        put(Volcan.class, path+"volcan.png");
        put(Energia.class, path+"energy.png");
        put(Espiral.class, path+"espiral.png");
        put(Criadero.class, path+"criadero.png");
        put(Guarida.class, path+"guarida.png");
        put(ReservaDeReproduccion.class, path+"reserva.png");
        put(Extractor.class, path+"extractor.png");
        put(PuertoEstelar.class, path+"PuertoEstelar.png");
        put(Pilon.class, path+"pilon.png");
        put(Acceso.class, path+"acceso.png");
        put(NexoMineral.class, path+"nexo.png");
        put(Asimilador.class, path+"asimilador.png");
    }};

    public static String getFloorSprite(Class clase) {
        return floorSprites.get(clase);
    }

    public static String getDefaultSprite() {
        return "file:"+System.getProperty("user.dir")+"/src/main/assets/default.png";
    }
}
