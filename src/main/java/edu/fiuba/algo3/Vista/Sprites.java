package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.tiles.Cristales;
import edu.fiuba.algo3.modelo.tiles.Energia;
import edu.fiuba.algo3.modelo.tiles.Moho;
import edu.fiuba.algo3.modelo.tiles.Volcan;

import java.util.HashMap;

public class Sprites {
    static String path = "file:"+System.getProperty("user.dir")+"/src/main/assets/";
    static HashMap<Class, String> floorSprites = new HashMap<Class, String>() {{
        put(Moho.class, path+"moho.png");
        put(Cristales.class, path+"cristales.png");
        put(Volcan.class, path+"volcan.png");
        put(Energia.class, path+"energy.png");
    }};

    public static String getFloorSprite(Class clase) {
        return floorSprites.get(clase);
    }

    public static String getDefaultSprite() {
        return "file:"+System.getProperty("user.dir")+"/src/main/assets/default.png";
    }
}
