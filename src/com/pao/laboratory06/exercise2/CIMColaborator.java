package com.pao.laboratory06.exercise2;

import java.util.Objects;
import java.util.Scanner;

public class CIMColaborator extends PersoanaFizica {
    String bonus;

    CIMColaborator(String nume, String prenume, double venitB){
        super(nume, prenume, venitB);
        this.bonus = "NU";
    }

    CIMColaborator(String nume, String prenume, double venitB, String bonus){
        super(nume, prenume, venitB);
        this.bonus = bonus;
    }

    CIMColaborator(){
        super();
    }

    @Override
    public double calculeazaVenitNetAnual() {
        double rez = this.venitBrutLunar * 12 * 0.55;
        if (this.bonus.equalsIgnoreCase("DA")) {
            rez += 0.1 * rez;
        }
        return rez;
    }

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.venitBrutLunar = in.nextDouble();
        this.bonus = in.next();
    }

    @Override
    public void afiseaza() {
        String venitFormatat = String.format("%.2f", calculeazaVenitNetAnual());
        System.out.println("CIM: " + nume + " " + prenume + ", venit net anual: " + venitFormatat + " lei");
    }

    @Override
    public String tipContract() {
        return "CIM";
    }

    @Override
    public boolean areBonus() {
        return this.bonus.equalsIgnoreCase("DA") ? true : false;
    }

    @Override
    public TipColaborator getTip() {
        return TipColaborator.CIM;
    }
}
