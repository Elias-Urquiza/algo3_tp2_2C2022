package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.buildings.protoss.*;
import edu.fiuba.algo3.modelo.buildings.zerg.*;
import edu.fiuba.algo3.modelo.tiles.*;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
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
        put(Vacio.class, path+"vacio.png");
        put(Zangano.class, path+"zangano.png" );
        put(Zerling.class, path+"zerling.png" );
        put(Devorador.class, path+"devorador.png" );
        put(Guardian.class, path+"guardian.png" );
        put(Hidralisco.class, path+"hidralisco.png" );
        put(Mutalisco.class, path+"mutalisco.png" );
        put(Zealot.class, path+"zealot.png" );
        put(Scout.class, path+"scout.png" );
        put(Dragon.class, path+"dragon.png" );


    }};

    public static String getFloorSprite(Class clase) {
        return floorSprites.get(clase);
    }

    public static String getDefaultSprite() {
        return "file:"+System.getProperty("user.dir")+"/src/main/assets/default.png";
    }
}
