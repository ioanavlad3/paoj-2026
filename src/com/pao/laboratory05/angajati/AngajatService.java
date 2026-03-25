package com.pao.laboratory05.angajati;

import java.util.Arrays;

public class AngajatService {
    private static AngajatService INSTANCE;
    private Angajat[] angajati = new Angajat[0];

    private AngajatService(){}

    public static AngajatService getInstance() {
        if (INSTANCE == null){
            INSTANCE = new AngajatService();
        }
        return INSTANCE;
    }

    public void addAngajat(Angajat a){
        Angajat[] newAngajati = new Angajat[this.angajati.length + 1];
        System.arraycopy(this.angajati, 0, newAngajati, 0, this.angajati.length);

        newAngajati[newAngajati.length - 1] = a;

        this.angajati = newAngajati;
        System.out.println(a);
    }

    public void printAll(){
        for(Angajat a : this.angajati) {
            System.out.println(a);
        }
    }

    public void listBySalary(){
        Angajat[] copy = this.angajati.clone();
        Arrays.sort(copy);
        for(Angajat a : copy) {
            System.out.println(a);
        }
    }

    public void findByDepartament(String numeDept){
        boolean found = false;

        for(Angajat a : this.angajati) {
            if(a.getDepartament().nume().equalsIgnoreCase(numeDept)){
                System.out.println(a);
                found = true;
            }
        }

        if(!found){
            System.out.println("Niciun angajat în departamentul: " + numeDept);
        }
    }

}
