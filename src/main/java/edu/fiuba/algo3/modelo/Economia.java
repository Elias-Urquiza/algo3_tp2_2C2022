package edu.fiuba.algo3.modelo;

public class Economia {

    private int gasVespeno;
    private int mineral;

    public Economia(){
        gasVespeno = 0;
        mineral = 0;
    }

    public void gastarGasVespeno(int gastar)throws RuntimeException{
        if(gasVespeno <= 0 || gasVespeno - gastar < 0)
            throw new RuntimeException("No se puede gastar la cantidad indicada");

        gasVespeno-= gastar;
    }

    public void ingresarGasVespeno(int ingreso)throws RuntimeException{
        if(ingreso < 0)
            throw new RuntimeException("ingreso no valido");

        gasVespeno+= ingreso;
    }

    public void gastarMineral(int gastar)throws RuntimeException{
        if(mineral <= 0 || mineral - gastar < 0)
            throw new RuntimeException("No se puede gastar la cantidad indicada");

        mineral-= gastar;
    }

    public void ingresarMineral(int ingreso)throws RuntimeException{
        if(ingreso < 0)
            throw new RuntimeException("ingreso no valido");

        mineral+= ingreso;
    }

    public int getGasVespeno() {
        return gasVespeno;
    }

    public int getMineral() {
        return mineral;
    }

}
