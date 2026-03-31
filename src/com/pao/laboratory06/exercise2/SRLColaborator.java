package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public class SRLColaborator extends PersoanaJuridica {

    double cheltuieliLunare;

    SRLColaborator(String nume, String prenume, double venitB, double cheltuieliLunare){
        super(nume, prenume, venitB);
        this.cheltuieliLunare = cheltuieliLunare;
    }

    SRLColaborator(){
        super();
    }

    @Override
    public double calculeazaVenitNetAnual() {
        double rez = (this.venitBrutLunar - cheltuieliLunare) * 12 * 0.84;
        return Math.round(rez * 100.0) / 100.0;
    }

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.venitBrutLunar = in.nextDouble();
        this.cheltuieliLunare = in.nextDouble();
    }

    @Override
    public void afiseaza() {
        String venitFormatat = String.format("%.2f", calculeazaVenitNetAnual());
        System.out.println("SRL: " + nume + " " + prenume + ", venit net anual: " + venitFormatat + " lei");
    }

    @Override
    public String tipContract() {
        return "SRL";
    }

    @Override
    public TipColaborator getTip() {
        return TipColaborator.SRL;
    }
}
