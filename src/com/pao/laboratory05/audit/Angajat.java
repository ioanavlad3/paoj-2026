package com.pao.laboratory05.audit;

public class Angajat implements Comparable<Angajat>{

    private String nume;
    private Departament departament;
    private double salariu;

    public Angajat(String n, Departament d, double sal) {
        this.nume = n;
        this.departament = d;
        this.salariu = sal;
    }

    public String getNume(){
        return this.nume;
    }

    public Departament getDepartament() {
        return this.departament;
    }

    public double getSalariu() {
        return this.salariu;
    }

    @Override
    public String toString() {
        return "Angajat{nume=" + this.nume + ", departament=" + this.departament + ", salariu=" + this.salariu + "}";
    }

    @Override
    public int compareTo(Angajat o) {
        return Double.compare(o.salariu, this.salariu);
    }


}
