package edu.fiuba.algo3.modelo.buildings.zerg;


import edu.fiuba.algo3.modelo.Construccion;
import edu.fiuba.algo3.modelo.Turno;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

public class Criadero extends ConstruccionZerg implements Turno, Construccion {

    private int numeroDeLarvas;
    private int turnosActivo;

    // incluir atributo de ubicacion

    private static final int MAX_LARVAS = 3;
    private static final int TIEMPO_CONSTRUCCION = 4;


    public Criadero() {
        super(500);
        numeroDeLarvas = 3;
        turnosActivo = 0;
    }

    public void extraerLarvas(int quitarLarvas) throws RuntimeException {
        if(numeroDeLarvas <= 0 || ( (numeroDeLarvas - quitarLarvas) < 0))
            throw new RuntimeException("Numero de Larvas incorrecto");
        if (turnosActivo < TIEMPO_CONSTRUCCION)
            throw new RuntimeException("Edificio en construccion");

        numeroDeLarvas-= quitarLarvas;
    }

    @Override
    public void pasarTurno() {
        if(numeroDeLarvas < MAX_LARVAS)
            numeroDeLarvas++;
        curar();
        turnosActivo++;
    }

    @Override
    public void usar() {

    }
}
