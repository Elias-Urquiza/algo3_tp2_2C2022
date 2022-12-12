package edu.fiuba.algo3.Vista;

public enum ButtonIds {
    NOMBRE1("#NamePlayer1"),
    NOMBRE2("#NamePlayer2"),
    RAZA1("#RazaPlayer1"),
    RAZA2("#RazaPlayer2"),
    STARTGAME("#StartGame"),
    COLOR1("#ColorPlayer1"),
    COLOR2("#ColorPlayer2"),
    TITLELABEL("#TitleLabel"),
    FLOORBUTTON("#FloorButton"),
    BUILDING("#BuildingButton"),
    CONSTRUIRCRIADERO("#ConstruirCriadero"),
    CONSTRUIRESPIRAL("#ConstruirEspiral"),
    CONSTRUIREXTRACTOR("#ConstruirExtractor"),
    CONSTRUIRGUARIDA("#ConstruirGuarida"),
    CONSTRUIRRESERVA("#ConstruirReserva"),
    // el zangano es una unidad ashi CONSTRUIRZANGANO("#ConstruirZangano"),

    CONSTRUIRNEXOMINERAL("#ConstruirNexoMineral"),
    CONSTRUIRPILON("#ConstruirPilon"),
    CONSTRUIRASIMILADOR("#ConstruirAsimilador"),
    CONSTRUIRACCESO("#ConstruirAcceso"),
    CONSTRUIRCPUERTOESTELAR("#ConstruirPuertoEstelar");

    private final String name;

    /**
     * @param name
     */
    ButtonIds(final String name) {
        this.name = name;
    }
    public String getName() {
        return name.substring(1);
    }
    public String getLookupName() {
        return name;
    };
}
