package com.pao.laboratory10.exercise1;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Implementează conform Readme.md
        //
        // Folosește LinkedList<Tranzactie> ca structură internă.
        // Citește comenzi din stdin până la EOF:
        //
        //   ENQUEUE id suma data tip   → addLast  (niciun output)
        //   DEQUEUE                    → removeFirst sau "Coada goala."
        //                                format: "Procesat: [id] data tip: suma RON"
        //   PUSH id suma data tip      → addFirst  (niciun output)
        //   POP                        → removeFirst sau "Coada goala."
        //                                format: "Extras: [id] data tip: suma RON"
        //   REMOVE_DEBIT               → Iterator.remove() pe toate DEBIT
        //                                afișează "Eliminat N tranzactii DEBIT."
        //   REMOVE_BELOW threshold     → Iterator.remove() pe suma < threshold
        //                                afișează "Eliminat N tranzactii sub threshold RON."
        //   PRINT                      → afișează toate, câte una pe linie
        //   SIZE                       → "Dimensiune coada: N"
        //
        // Format linie tranzacție: [id] data tip: suma RON
        //   Ex: [1] 2024-01-10 CREDIT: 500.00 RON

        LinkedList<Tranzactie> tranzactii = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String cerinta = scanner.next();
            switch (cerinta) {
                case "ENQUEUE" -> {
                    int id = scanner.nextInt();
                    double suma = scanner.nextDouble();
                    String data = scanner.next();
                    TipTranzactie tip = TipTranzactie.valueOf(scanner.next());

                    Tranzactie tranzactie = new Tranzactie(id, suma, data, tip);
                    tranzactii.addLast(tranzactie);

                    break;
                }
                case "DEQUEUE" -> {
                    if (tranzactii.size() == 0){
                        System.out.println("Coada goala.");
                    } else {
                        Tranzactie tranzactie = tranzactii.removeFirst();
                        System.out.println("Procesat: " + tranzactie);
                    }
                    break;
                }
                case "PUSH" -> {
                    int id = scanner.nextInt();
                    double suma = scanner.nextDouble();
                    String data = scanner.next();
                    TipTranzactie tip = TipTranzactie.valueOf(scanner.next());

                    Tranzactie tranzactie = new Tranzactie(id, suma, data, tip);
                    tranzactii.addFirst(tranzactie);

                    break;
                }

                case "POP" -> {
                    if (tranzactii.size() == 0){
                        System.out.println("Coada goala.");
                    } else {
                        Tranzactie tranzactie = tranzactii.removeFirst();
                        System.out.println("Extras: " + tranzactie);
                    }
                    break;
                }

                case "PRINT" -> {
                    for (Tranzactie t : tranzactii) {
                        System.out.println(t.toString());
                    }
                    break;
                }

                case "SIZE" -> {
                    System.out.println("Dimensiune coada: " + tranzactii.size());
                    break;
                }

                case "REMOVE_DEBIT" -> {
                    int count = 0;
                    Iterator<Tranzactie> iterator = tranzactii.iterator();
                    while (iterator.hasNext()){
                        Tranzactie t = iterator.next();
                        if (t.getTip() == TipTranzactie.DEBIT) {
                            count ++;
                            iterator.remove();
                        }
                    }
                    System.out.println("Eliminat " + count + " tranzactii DEBIT.");
                    break;
                }

                case "REMOVE_BELOW" -> {
                    double threshold = scanner.nextDouble();
                    int count = 0;
                    Iterator<Tranzactie> iterator = tranzactii.iterator();
                    while (iterator.hasNext()){
                        Tranzactie t = iterator.next();
                        if (t.getSuma() < threshold) {
                            count ++;
                            iterator.remove();
                        }
                    }
                    System.out.println(String.format("Eliminat %d tranzactii sub %.2f RON.", count, threshold));
                    break;
                }
            }
        }

    }
}
