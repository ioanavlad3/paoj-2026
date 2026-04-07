package com.pao.laboratory06.exercise3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Creare si sortare array de Inginer
        Inginer i1 = new Inginer(); i1.setNume("Popescu"); i1.setSalariu(5000);
        Inginer i2 = new Inginer(); i2.setNume("Ionescu"); i2.setSalariu(7000);
        Inginer i3 = new Inginer(); i3.setNume("Vasilescu"); i3.setSalariu(4500);

        Inginer[] ingineri = {i1, i2, i3};

        System.out.println("Sortare naturala (Nume):");
        Arrays.sort(ingineri);
        for(Inginer i : ingineri) System.out.println(i.nume + " - " + i.salariu);

        System.out.println("\nSortare dupa salariu (Comparator extern):");
        Arrays.sort(ingineri, new ComparatorInginerSalariu());
        for(Inginer i : ingineri) System.out.println(i.nume + " - " + i.salariu);

        // Referinta de tip PlataOnline
        System.out.println("\nDemonstratie PlataOnline ");
        PlataOnline plataInginer = i2;
        plataInginer.autentificare("Ionescu", "parola123");
        System.out.println("Sold prin interfata: " + plataInginer.consultareSold());

        // PersoanaJuridica prin PlataOnlineSMS
        System.out.println("\n Demonstrație PersoanaJuridica & SMS ");
        PersoanaJuridica firma = new PersoanaJuridica();
        firma.setNume("Tech SRL");
        firma.setTelefon("0722111222");

        PlataOnlineSMS plataSMS = firma;
        plataSMS.trimiteSMS("Factura curenta: 500 RON");

        System.out.println("Mesaje stocate in obiect: " + firma.smsTrimise);

        //  Afisare constanta Enum
        System.out.println("\n Constante Financiare ");
        System.out.println("Salariul minim este: " + ConstanteFinanciare.SALARIU_MINIM.getValoare());

        // Tratare cazuri de eroare
        System.out.println("\nTestare Erori ");

        // Trimitere SMS fara telefon
        PersoanaJuridica firmaFaraTel = new PersoanaJuridica();
        firmaFaraTel.telefon = "";
        boolean smsTrimis = firmaFaraTel.trimiteSMS("Salut");
        System.out.println("SMS trimis fara telefon? " + smsTrimis);

        // Mesaj invalid
        try {
            firma.trimiteSMS("");
        } catch (UnsupportedOperationException e) {
            System.out.println("Exceptie prinss la SMS: " + e.getMessage());
        }

        // Autentificare cu user invalid
        try {
            plataInginer.autentificare("", "1234");
        } catch (IllegalArgumentException e) {
            System.out.println("Exceptie prinsa la Autentificare: " + e.getMessage());
        }
    }
}