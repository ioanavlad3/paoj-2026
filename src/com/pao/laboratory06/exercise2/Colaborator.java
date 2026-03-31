package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public abstract class Colaborator implements IOperatiiCitireScriere{
    String nume;
    String prenume;
    double venitBrutLunar;

    Colaborator() {
        this.nume = "";
        this.prenume = "";
        this.venitBrutLunar = 0;
    }

    Colaborator(String nume, String prenume, double venitBrutLunar){
        this.nume = nume;
        this.prenume = prenume;
        this.venitBrutLunar = venitBrutLunar;
    }

    public abstract double calculeazaVenitNetAnual() ;

    public abstract TipColaborator getTip();

    @Override
    public abstract void afiseaza();

    @Override
    public abstract void citeste(Scanner in);

}
