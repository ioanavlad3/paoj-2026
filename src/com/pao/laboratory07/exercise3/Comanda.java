package com.pao.laboratory07.exercise3;

import com.pao.laboratory07.exercise1.OrderState;

public abstract sealed class Comanda permits ComandaStandard, ComandaRedusa, ComandaGratuita {
    protected String nume;
    protected double pret;
    protected String client;
    protected OrderState stare;


    public Comanda(){
        this.stare = OrderState.PLACED;
    }

    public Comanda(String nume, double pret, String client){
        this.stare = OrderState.PLACED;
        this.nume = nume;
        this.pret = pret;
        this.client = client;
    }

    public abstract double pretFinal();
    public abstract String descriere();

    public String getClient(){
        return this.client;
    }
}