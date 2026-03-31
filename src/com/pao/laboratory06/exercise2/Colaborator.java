package com.pao.laboratory06.exercise2;

public abstract class Colaborator {
    String nume;
    String prenume;
    double venitBrutLunar;

    Colaborator(String nume, String prenume, double venitBrutLunar){
        this.nume = nume;
        this.prenume = prenume;
        this.venitBrutLunar = venitBrutLunar;
    }

    public abstract double calculeazaVenitNetAnual() ;
}
