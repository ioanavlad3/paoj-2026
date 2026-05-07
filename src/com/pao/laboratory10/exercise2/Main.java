package com.pao.laboratory10.exercise2;

import com.pao.laboratory10.exercise1.Tranzactie;
import com.pao.laboratory10.exercise1.TipTranzactie;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Implementează conform Readme.md
        //
        // 1. Citește N din stdin, apoi cele N tranzacții (id suma data tip) — pot exista duplicate de id
        //    Stochează-le toate într-un ArrayList<Tranzactie> (cu duplicate, ordine inserare)
        //
        // 2. Procesează comenzile din stdin până la EOF:
        //
        //   UNIQUE_IDS      → LinkedHashSet<Integer> cu id-urile în ordinea primei apariții
        //                     afișează: "IDs unice (N): [1, 2, 3, ...]"
        //
        //   MONTHLY_REPORT  → TreeMap<String, ...> grupat pe yyyy-MM (substring 0-7 din data)
        //                     pentru fiecare lună, sumele CREDIT și DEBIT
        //                     format: "yyyy-MM: CREDIT X.XX RON, DEBIT Y.YY RON"
        //
        //   TOP n           → primele n tranzacții după suma descrescătoare (nu modifică lista)
        //                     afișează "Top n:" urmat de n linii
        //
        //   SORT_ASC        → Collections.sort cu suma crescătoare; afișează lista sortată
        //   SORT_DESC       → Collections.sort cu suma descrescătoare; afișează lista sortată
        //   REVERSE         → Collections.reverse; afișează lista
        //   MIN_MAX         → Collections.min/max după suma
        //                     "MIN: [id] data tip: suma RON"
        //                     "MAX: [id] data tip: suma RON"
        //
        //   CME_DEMO        → încearcă for(t : lista) lista.remove(t) în try-catch
        //                     afișează "ConcurrentModificationException prins: modificare in iteratie detectata."
        //
        // Format linie tranzacție: [id] data tip: suma RON
        //   Ex: [1] 2024-01-15 CREDIT: 1500.00 RON

        ArrayList<Tranzactie> tranzactii = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0 ; i < n; i++) {
            int id = scanner.nextInt();
            double suma = scanner.nextDouble();
            String data = scanner.next();
            TipTranzactie tip = TipTranzactie.valueOf(scanner.next());

            Tranzactie tranzactie = new Tranzactie(id, suma, data, tip);
            tranzactii.addLast(tranzactie);
        }

        while (scanner.hasNext()) {
            String cerinta = scanner.next();

            switch(cerinta) {
                case "UNIQUE_IDS" -> {
                    LinkedHashSet<Integer> unique_ids = new LinkedHashSet<>();

                    for (Tranzactie t : tranzactii) {
                        unique_ids.add(t.getId());
                    }

                    System.out.println("IDs unice (" + unique_ids.size() + "): " + unique_ids);
                    break;
                }

                case "MONTHLY_REPORT" -> {
                    TreeMap<String, double[]> report = new TreeMap<>();
                    for (Tranzactie t : tranzactii) {
                        String data = t.getData().substring(0, 7);
                        report.putIfAbsent(data, new double[2]);
                        double[] valori = report.get(data);

                        if (t.getTip() == TipTranzactie.CREDIT) {
                            valori[0] += t.getSuma();
                        } else {
                            valori[1] += t.getSuma();
                        }
                    }

                    report.forEach((data, valori) -> {
                        System.out.printf("%s: CREDIT %.2f RON, DEBIT %.2f RON%n", data, valori[0], valori[1]);
                    });
                    break;

                }

                case "TOP" -> {
                    int m = scanner.nextInt();
                    List<Tranzactie> sorted = new ArrayList<>();
                    sorted = tranzactii.stream()
                            .sorted(Comparator.comparingDouble(Tranzactie::getSuma).reversed()).toList();
                    for (int i = 0; i < m ; i ++) {
                        System.out.println(sorted.get(i).toString());
                    }

                    break;
                }

                case "MIN_MAX" -> {
                    System.out.println("MIN: " + Collections.min(tranzactii, Comparator.comparingDouble(Tranzactie::getSuma)).toString());
                    System.out.println("MAX: " + Collections.max(tranzactii, Comparator.comparingDouble(Tranzactie::getSuma)).toString());
                    break;
                }

                case "SORT_ASC" -> {
                    Collections.sort(tranzactii, Comparator.comparingDouble(Tranzactie::getSuma));
                    tranzactii.forEach(t -> System.out.println(t.toString()));
                    break;
                }

                case "CME_DEMO" -> {
                    try {
                        for (Tranzactie t : tranzactii) {
                            tranzactii.remove(t);
                        }
                    } catch(ConcurrentModificationException e) {
                        System.out.println("ConcurrentModificationException prins: modificare in iteratie detectata.");
                    }
                    break;
                }
            }


        }


    }
}
