package com.pao.laboratory06.exercise2;

public class SRLColaborator extends Colaborator{

    double cheltuieliLunare;

    SRLColaborator(String nume, String prenume, double venitB, double cheltuieliLunare){
        super(nume, prenume, venitB);
        this.cheltuieliLunare = cheltuieliLunare;
    }


    @Override
    public double calculeazaVenitNetAnual() {
        return (this.venitBrutLunar - cheltuieliLunare) * 12 * 0.84;
    }
}
