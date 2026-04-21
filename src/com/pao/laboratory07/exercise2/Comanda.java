package com.pao.laboratory07.exercise2;

import com.pao.laboratory07.exercise1.OrderState;
import com.pao.laboratory07.exercise2.ComandaStandard;

public abstract sealed class Comanda permits ComandaStandard, ComandaRedusa, ComandaGratuita {
    protected String nume;
    protected double pret;
    protected OrderState stare;


    public Comanda(){
        this.stare = OrderState.PLACED;
    }

    public Comanda(String nume, double pret){
        this.stare = OrderState.PLACED;
        this.nume = nume;
        this.pret = pret;
    }

    public abstract double pretFinal();
    public abstract String descriere();
}