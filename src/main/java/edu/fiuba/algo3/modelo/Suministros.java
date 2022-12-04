package edu.fiuba.algo3.modelo;

public class Suministros {
    int maxSuministros;
    int suministros;

    public Suministros() {
        this.maxSuministros = 200;
        this.suministros = 0;
    }

    public int aumentarMaxSuminstros(int aumento) {
        //Returns after max suministros
        this.maxSuministros += aumento;
        return maxSuministros;
    }

    public int suministrar(int aumento) {
        // Returns after suministers
        int aAumentar = aumento + suministros;
        if (aAumentar > maxSuministros) {
            throw new RuntimeException("No puedes suministrar porque ya esta lleno");
        } else {
            this.suministros += aumento;
        }
        return suministros;
    }

    public int disminuirMaximo(int disminuye) {
        int aDisminuir = maxSuministros - disminuye;
        if (aDisminuir < 0) {
            maxSuministros = 0;
            return 0;
        }
        maxSuministros -= disminuye;
        return maxSuministros;
    }
}
