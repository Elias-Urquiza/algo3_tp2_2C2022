package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TipoDeUnidades;
import edu.fiuba.algo3.modelo.VidaZerg;
import edu.fiuba.algo3.modelo.buildings.ConstruccionZerg;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class UnidadZerg extends Unidad {
    private VidaZerg vida;
    protected LinkedList<Class> correlatividad;

    public UnidadZerg(int puntosDeVidaMaximo, int costoMineral, int costoGas, Economia economia, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie) {
        super(economia, costoMineral, costoGas, pos, tiempoDeConstruccion, rango, superficieAtaque, superficie);
        this.vida = new VidaZerg(puntosDeVidaMaximo);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque) {
        if (superficieAtaque.equals(tipoDeAtaque)) {
            return vida.daniar(danio);
        }
        return 0;//podemos poner una constante
    }

    public void chequearCorrelatividad(LinkedList<ConstruccionZerg> lista) {
        boolean match = false;
        boolean afirmacion = false;

        for (ConstruccionZerg z : lista) {
            match = correlatividad.stream().anyMatch(any -> any.equals(z.getClass()));
            if(match)
                afirmacion = true;
        }
/*
        if (afirmacion || correlatividad.isEmpty())
            lista.add(this);
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
