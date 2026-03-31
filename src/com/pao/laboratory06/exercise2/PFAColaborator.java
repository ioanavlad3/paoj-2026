package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public class PFAColaborator extends PersoanaFizica {
    double cheltuieliLunare;
    double venitNet ;
    double impozitVenit;
    double CASS;
    double CAS;

    private final int salMiniBruteAn = 48600;
    private final int salMiniBrut = 4050;

    PFAColaborator(){
        super();
    }

    PFAColaborator(String nume, String prenume, double venitB, double cheltuieliLunare){
        super(nume, prenume, venitB);
        this.cheltuieliLunare = cheltuieliLunare;
    }

    private void efectueazaCalculeTaxe() {
//        double venitBazaCalcul = (this.venitBrutLunar - this.cheltuieliLunare) * 12;
//        this.venitNet = venitBazaCalcul;
//        this.impozitVenit = 0.1 * venitBazaCalcul;
//
//        if (venitBazaCalcul < 6 * salMiniBrut)
//            this.CASS = 0.1 * 6 * salMiniBrut;
//        else if (venitBazaCalcul <= 12 * salMiniBrut)
//            this.CASS = 0.1 * venitBazaCalcul;
//        else
//            this.CASS = 0.1 * 12 * salMiniBrut;
//
//        if (venitBazaCalcul < 12 * salMiniBrut)
//            this.CAS = 0;
//        else if (venitBazaCalcul < 24 * salMiniBrut)
//            this.CAS = 0.25 * 12 * salMiniBrut;
//        else
//            this.CAS = 0.25 * 24 * salMiniBrut;


        double venitNetInitial = (this.venitBrutLunar - this.cheltuieliLunare) * 12;
        this.venitNet = venitNetInitial; // Aceasta este baza

        int salAnual = 48600;
        this.impozitVenit = 0.1 * venitNetInitial;
        this.CASS = 0.1 * salAnual;
        this.CAS = 0.25 * (2 * salAnual);
    }

    @Override
    public double calculeazaVenitNetAnual(){
        return this.venitNet - this.impozitVenit - this.CASS - this.CAS;
    }

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.venitBrutLunar = in.nextDouble();
        this.cheltuieliLunare = in.nextDouble();

        efectueazaCalculeTaxe();
    }

    @Override
    public void afiseaza() {
        String venitFormatat = String.format("%.2f", calculeazaVenitNetAnual());
        System.out.println("PFA: " + nume + " " + prenume + ", venit net anual: " + venitFormatat + " lei");
    }

    @Override
    public String tipContract() {
        return "PFA";
    }

    @Override
    public TipColaborator getTip() {
        return TipColaborator.PFA;
    }
}
