package edu.fiuba.algo3.modelo;

public class Suministros {
    int maxSuministros;
    int suministros;
    static int MAXIMO_200 = 200;

    public Suministros() {
        this.maxSuministros = 0;
        this.suministros = 0;
    }

    public int aumentarMaxSuminstros(int aumento) {
        //Returns after max suministros
        int aAumentar = aumento + maxSuministros;
        if (aAumentar < MAXIMO_200) {
            this.maxSuministros += aumento;
        }
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

    public int getSuministros() {
        return suministros;
    }

    public int getMaxSuministros() {
        return maxSuministros;
    }
}
