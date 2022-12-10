package edu.fiuba.algo3.Vista;

public enum Ids {
    NOMBRE1("#NamePlayer1"),
    NOMBRE2("#NamePlayer2"),
    RAZA1("#RazaPlayer1"),
    RAZA2("#RazaPlayer2"),
    STARTGAME("#StartGame"),
    COLOR1("#ColorPlayer1"),
    COLOR2("#ColorPlayer2"),
    TITLELABEL("#TitleLabel");

    private final String name;

    /**
     * @param name
     */
    private Ids(final String name) {

        this.name = name;
    }
    public String getName() {
        return name.substring(1);
    }
    public String getLookupName() {
        return name;
    };
}
