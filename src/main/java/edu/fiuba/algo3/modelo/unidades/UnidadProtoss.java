package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.VidaProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class UnidadProtoss extends Unidad {
    private VidaProtoss vida;

    protected LinkedList<Class> correlatividad;


    public UnidadProtoss(int puntosDeVidaMaximo, int escudoMaximo, int costoMineral, int costoGas, Economia econ, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie) {
        super(econ, costoMineral, costoGas, pos, tiempoDeConstruccion, rango, superficieAtaque, superficie);
        this.vida = new VidaProtoss(puntosDeVidaMaximo, escudoMaximo);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque) {
        if (superficieAtaque.equals(tipoDeAtaque)) {
            return vida.daniar(danio);
        }
        return 0;
    }


    public void chequearCorrelatividad(LinkedList<ConstruccionProtoss> lista) {
        boolean match = false;
        boolean afirmacion = false;

        for (ConstruccionProtoss p : lista) {
            match = correlatividad.stream().anyMatch(any -> any.equals(p.getClass()));
            if(match)
                afirmacion = true;
        }
/*
        if (afirmacion || correlatividad.isEmpty())
            lista.add(this);    Aca Se Deberia PasarAlSiguientePaso
        else
            throw new RuntimeException("No existe su correlativa");

 */
        if (!afirmacion){
            throw new RuntimeException("No existe su correlativa");
        }

    }



    @Override
    public abstract void agregate(HashMap<TipoDeUnidades, LinkedList> listas);
}
