package com.pao.laboratory06.exercise3;

import java.util.Objects;

public class Inginer extends Angajat implements PlataOnline, Comparable<Inginer> {
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setSalariu(double salary){
        this.salariu = salary;
    }

    @Override
    public void autentificare(String user, String parola) {
        if (user == null || user.isEmpty())
            throw new IllegalArgumentException("User incorect");
        if (parola == null || parola.isEmpty())
            throw new IllegalArgumentException("parola incorecta");
        if (Objects.equals(this.nume, user) && "parola123".equals(parola)){
            System.out.println("Autentificare reusita pentru inginerul " + this.nume);
        } else {
            System.out.println("Date de autentificare incorecte.");
        }
    }

    @Override
    public double consultareSold() {
        return this.salariu;
    }

    @Override
    public boolean efectuearePlata(double suma) {
        if (this.salariu >= suma){
            this.salariu -= suma;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Inginer o) {
        return this.nume.compareTo(o.nume);
    }
}
