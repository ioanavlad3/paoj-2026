package com.pao.laboratory10.exercise3;

import com.pao.laboratory10.exercise1.Tranzactie;
import com.pao.laboratory10.exercise1.TipTranzactie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingDouble;

public class Main {
    public static void main(String[] args) {
        List<Tranzactie> tranzactii = new ArrayList<>();
        tranzactii.add(new Tranzactie(1,1500.00,"2024-01-15", TipTranzactie.CREDIT));
        tranzactii.add(new Tranzactie(2,750.50,"2024-01-22", TipTranzactie.DEBIT));
        tranzactii.add(new Tranzactie(3,200.00,"2024-02-05", TipTranzactie.CREDIT));
        tranzactii.add(new Tranzactie(4,1200.00,"2024-02-18", TipTranzactie.DEBIT));
        tranzactii.add(new Tranzactie(5,600.00,"2024-02-21", TipTranzactie.CREDIT));
        tranzactii.add(new Tranzactie(6,1900.00,"2024-03-01", TipTranzactie.DEBIT));
        tranzactii.add(new Tranzactie(7,250.00,"2024-03-05", TipTranzactie.DEBIT));
        tranzactii.add(new Tranzactie(8,550.00,"2024-03-05", TipTranzactie.CREDIT));
        tranzactii.add(new Tranzactie(9,1250.00,"2024-03-15", TipTranzactie.DEBIT));
        tranzactii.add(new Tranzactie(10,1300.50,"2024-03-20", TipTranzactie.CREDIT));
        tranzactii.add(new Tranzactie(11,560.00,"2024-03-25", TipTranzactie.DEBIT));


        System.out.println("----FILTER----");
        tranzactii.stream().filter(t -> t.getTip() == TipTranzactie.CREDIT)
                .forEach(System.out::println);


        System.out.println("----MAP----");
        Double suma = tranzactii.stream().mapToDouble(Tranzactie::getSuma).sum();
        System.out.println(String.format("Total procesat: %.2f RON", suma));

        System.out.println("---GROUP BY----");
        Map<String, Double> groupBy = tranzactii.stream().collect(Collectors.groupingBy(
                t -> t.getData().substring(0, 7),
                Collectors.summingDouble(t -> t.getSuma())
        ));
        groupBy.forEach((data, total) -> System.out.println(String.format("%s: %.2f RON", data, total)));
    }
}
