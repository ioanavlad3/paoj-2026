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

        File director = new File("output");
        if (!director.exists()) {
            director.mkdirs(); // Creează folderul dacă nu există
        }

        Scanner scanner = new Scanner(System.in);
        //File folder = new File("output.txt");

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
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE))){
            oos.writeObject(tranzactii);
        } catch (IOException e){
            e.printStackTrace();
        }

        List<Tranzactie> transactiiDeserialized = null;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OUTPUT_FILE))){
            transactiiDeserialized = (List<Tranzactie>) ois.readObject();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        while(scanner.hasNext()){
            String cerinta = scanner.next();

            switch (cerinta){
                case "LIST": {
                    for(int i = 0; i < n; i ++){
                        System.out.println(transactiiDeserialized.get(i).toString());
                    }
                    break;
                }

                case "FILTER": {
                    String prefix = scanner.next();
                    boolean gasit = false;
                    assert transactiiDeserialized != null;
                    for(Tranzactie t : transactiiDeserialized){
                        if (t.getData().startsWith(prefix) ){
                            gasit = true;
                            System.out.println(t.toString());
                        }
                    }
                    if(!gasit){
                        System.out.println("Niciun rezultat.");
                    }
                    break;
                }

                case "NOTE" : {
                    int id = scanner.nextInt();
                    boolean gasit = false;
                    assert transactiiDeserialized != null;
                    for (Tranzactie t : transactiiDeserialized){
                        if (t.getId() == id) {
                            System.out.println("NOTE[" + id + "]: " + t.getNote());
                            gasit = true;
                            break;
                        }
                    }
                    if (!gasit){
                        System.out.println("NOTE[" + id + "]: " + "not found");
                    }
                    break;
                }

                default:
                    System.out.println("cerinta gresita");

            }
        }


    }
}
