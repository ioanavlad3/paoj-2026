package com.pao.laboratory06.exercise2;

public class PFAColaborator extends Colaborator {
    double cheltuieliLunare;
    double venitNet ;
    double impozitVenit;
    double CASS;
    double CAS;

    private final int salMiniBruteAn = 48600;
    private final int salMiniBrut = 4050;

    PFAColaborator(String nume, String prenume, double venitB, double cheltuieliLunare){
        super(nume, prenume, venitB);
        this.cheltuieliLunare = cheltuieliLunare;
        this.venitNet = (venitB - cheltuieliLunare) * 12;
        this.impozitVenit = 0.1 * venitNet;

        if (this.venitNet < 6 * salMiniBrut)
            this.CASS = 0.1 * 6 * salMiniBrut;   // salariul minim brut
        else if (this.venitNet <= 72 *  salMiniBrut){
            this.CASS = 0.1 * this.venitNet;
        }
        else {
            this.CASS = 0.1 * 72 * salMiniBrut;
        }
        if (venitNet < 12 * salMiniBrut) {
            this.CAS = 0;
        }
        else if (venitNet < 24 * salMiniBrut) {
            this.CAS = 0.25 * 12 * salMiniBrut;
        }
        else {
            this.CAS = 0.25 * 24 * salMiniBrut;
        }

    }

    @Override
    public double calculeazaVenitNetAnual(){
        return this.venitNet - this.impozitVenit - this.CASS - this.CAS;
    }
}
