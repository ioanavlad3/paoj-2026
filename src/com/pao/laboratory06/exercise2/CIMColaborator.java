package com.pao.laboratory06.exercise2;

import java.util.Objects;

public class CIMColaborator extends Colaborator {
    String bonus;

    CIMColaborator(String nume, String prenume, double venitB){
        super(nume, prenume, venitB);
        this.bonus = "NU";
    }

    CIMColaborator(String nume, String prenume, double venitB, String bonus){
        super(nume, prenume, venitB);
        this.bonus = bonus;
    }

    @Override
    public double calculeazaVenitNetAnual() {
        double rez = this.venitBrutLunar * 12 * 0.55;
        if (Objects.equals(bonus, "DA")) {
            rez += 0.1 * rez;
        }
        return rez;
    }

}
