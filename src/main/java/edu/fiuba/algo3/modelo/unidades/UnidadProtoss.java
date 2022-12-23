package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Suministros;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.VidaProtoss;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class UnidadProtoss extends Unidad {
    private VidaProtoss vida;

    public UnidadProtoss(int puntosDeVidaMaximo, int escudoMaximo, int costoMineral, int costoGas, Economia econ, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie,
                         int suministro) {
        super(econ, costoMineral, costoGas, pos, tiempoDeConstruccion, rango, superficieAtaque, superficie, suministro);
        this.vida = new VidaProtoss(puntosDeVidaMaximo, escudoMaximo);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion posicionAtacante) {
        if (superficieAtaque.equals(tipoDeAtaque) && tipoDeAtaque.inRange(pos, posicionAtacante)) {
            return vida.daniar(danio);
        }
        return 0;
    }

    public void morirUnidad(HashMap<Raza, LinkedList> unidades){
        LinkedList<Unidad> protoss = unidades.get(Raza.PROTOSS);
        vida.eliminarUnidad(protoss, this);
    }

    @Override
    public void agregate(HashMap<Raza, LinkedList> listas, HashMap<Raza, Suministros> suministros) throws RuntimeException {
        try {
            suministros.get(Raza.PROTOSS).suministrar(suministro);
        } catch (RuntimeException e) {
            throw new RuntimeException("No puedes construir esta unidad, ya tienes la mayor cantidad de unidades posibles");
        }
        listas.get(Raza.PROTOSS).add(this);
    }

    @Override
    public LinkedList<String> getInformacion() {
        return new LinkedList<>();
    }

    @Override
    public int getVida(){
        return vida.getVida();
    }
}
