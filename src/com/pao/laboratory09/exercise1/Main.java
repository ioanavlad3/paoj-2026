package com.pao.laboratory09.exercise1;

import java.io.*;
import java.util.*;

public class Main {
    private static final String OUTPUT_FILE = "output/lab09_ex1.ser";

    public static void main(String[] args) throws Exception {
        // TODO: Implementează conform Readme.md
        //
        // 1. Citește N din stdin, apoi cele N tranzacții (id suma data contSursa contDestinatie tip)
        // 2. Setează câmpul note = "procesat" pe fiecare tranzacție înainte de serializare

        Scanner scanner = new Scanner(System.in);
        String OUTPUT_FILE = "output.txt";

        int n = scanner.nextInt();
        List<Tranzactie> tranzactii = new ArrayList<>();
        for(int i = 0 ; i < n; i ++){
            int id = scanner.nextInt();
            double suma = scanner.nextDouble();
            String data = scanner.next();
            String contSursa = scanner.next();
            String contDestinatie = scanner.next();
            TipTranzactie tip = TipTranzactie.valueOf(scanner.next());

            Tranzactie t = new Tranzactie(id, suma, data, contSursa, contDestinatie, tip);
            t.setNote("procesat");
            tranzactii.add(t);
        }

        // 3. Serializează lista de tranzacții în OUTPUT_FILE cu ObjectOutputStream (try-with-resources)

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE))){
            oos.writeObject(tranzactii);
        }

        // 4. Deserializează lista din OUTPUT_FILE cu ObjectInputStream (try-with-resources)

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OUTPUT_FILE))){
            List<Tranzactie> tranzactiiDeserialized = (List<Tranzactie>) ois.readObject();

            // Verificare: afișează tranzacțiile deserializate
            for(Tranzactie t : tranzactiiDeserialized){
                System.out.println(t);
            }
        }


        // 5. Procesează comenzile din stdin până la EOF:
        //    - LIST          → afișează toate tranzacțiile, câte una pe linie
        //    - FILTER yyyy-MM → afișează tranzacțiile cu data care începe cu yyyy-MM
        //                       sau "Niciun rezultat." dacă nu există
        //    - NOTE id        → afișează "NOTE[id]: <valoarea câmpului note>"
        //                       sau "NOTE[id]: not found" dacă id-ul nu există
        //
        // Format linie tranzacție:
        //   [id] data tip: suma RON | contSursa -> contDestinatie
        //   Ex: [1] 2024-01-15 CREDIT: 1500.00 RON | RO01SRC1 -> RO01DST1

        boolean citire = true;

        while(citire){
            String cerinta = scanner.next();
            switch (cerinta){
                case "LIST": {
                    for(int i = 0; i < n; i ++){
                        System.out.println(tranzactii.get(i).toString());
                    }
                    break;
                }
                default:
                    System.out.println("cerinta gresita");

            }
        }


    }
}
