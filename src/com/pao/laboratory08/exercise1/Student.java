package com.pao.laboratory08.exercise1;

import java.util.Objects;

public class Student implements Cloneable {
    private String nume;
    private int varsta;
    private Adresa adresa;


    public Student shallowClone() {
        try {
            Student clone = (Student) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Student deepClone() {
        try {
            Student clone = (Student) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original

            if(adresa != null) {
                clone.adresa = (Adresa) adresa.clone();
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    public Student(String nume, int varsta, Adresa adresa){
        this.adresa = adresa;
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume(){
        return this.nume;
    }

    public int getVarsta(){
        return this.varsta;
    }

    public Adresa getAdresa(){
        return this.adresa;
    }

    public String toString() {
        return "Student{nume='" + nume + "', varsta=" + varsta + ", adresa=" + adresa + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return varsta == student.varsta && Objects.equals(nume, student.nume)
                && Objects.equals(adresa, student.adresa);
    }
}
