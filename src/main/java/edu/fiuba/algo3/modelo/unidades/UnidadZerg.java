package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Economia;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Suministros;
import edu.fiuba.algo3.modelo.buildings.zerg.Zangano;
import edu.fiuba.algo3.modelo.jugadores.Raza;
import edu.fiuba.algo3.modelo.VidaZerg;
import edu.fiuba.algo3.modelo.buildings.ConstruccionProtoss;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class UnidadZerg extends Unidad {
    private VidaZerg vida;
    protected LinkedList<Class> correlativity;

    public UnidadZerg(int puntosDeVidaMaximo, int costoMineral, int costoGas, Economia economia, Posicion pos, int tiempoDeConstruccion, int rango, Ataque superficieAtaque, Movimiento superficie,
                      int suministro) {
        super(economia, costoMineral, costoGas, pos, tiempoDeConstruccion, rango, superficieAtaque, superficie, suministro);
        this.vida = new VidaZerg(puntosDeVidaMaximo);
    }

    @Override
    public int recibirDanio(int danio, Ataque tipoDeAtaque, Posicion posicionAtacante) {
        if (superficieAtaque.equals(tipoDeAtaque) && tipoDeAtaque.inRange(pos, posicionAtacante)) {
            return vida.daniar(danio);
        }
        return 0;//podemos poner una constante
    }

    @Override
    public void morirUnidad(HashMap<Raza, LinkedList> unidades){
        LinkedList<Unidad> zergs = unidades.get(Raza.ZERG);
        vida.eliminarUnidad(zergs, this);
    }

    @Override
    public void agregate(HashMap<Raza, LinkedList> listas, HashMap<Raza, Suministros> suministros)  {
        try {
            suministros.get(Raza.ZERG).suministrar(suministro);
        } catch (RuntimeException e) {
            throw new RuntimeException("No puedes construir esta unidad, ya tienes la mayor cantidad de unidades posibles");
        }
        listas.get(Raza.ZERG).add(this);
    }

    public void agregaZangano(LinkedList<Zangano> zanganos) {
        return;
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
