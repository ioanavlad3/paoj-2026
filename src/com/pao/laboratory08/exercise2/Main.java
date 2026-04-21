package com.pao.laboratory08.exercise2;

import com.pao.laboratory08.exercise1.Adresa;
import com.pao.laboratory08.exercise1.Student;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    private static final String FILE_PATH = "src/com/pao/laboratory08/tests/studenti.txt";

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        ArrayList<Student> studenti = new ArrayList<>();
        String linie;
        while ((linie = br.readLine()) != null) {
            if (linie.trim().isEmpty()) {
                continue;
            }

            String[] tokens = linie.split(",");
            if (tokens.length >= 4) {
                String nume = tokens[0].trim();
                int varsta = Integer.parseInt(tokens[1].trim());
                String oras = tokens[2].trim();
                String strada = tokens[3].trim();

                Adresa adresa = new Adresa(oras, strada);
                Student student = new Student(nume, varsta, adresa);
                studenti.add(student);
            } else {
                System.err.println("Linie incompletă: " + linie);
            }
        }
        br.close();

        Scanner scanner = new Scanner(System.in);
        int varsta_minima = scanner.nextInt();

        List<Student> studenti_filtrati = studenti.stream()
                                            .filter(s -> s.getVarsta() >= varsta_minima)
                                            .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Filtru: varsta minima >= " + varsta_minima);
        System.out.println("Rezultate: " + studenti_filtrati.size() + " studenti");

        BufferedWriter bw = new BufferedWriter(new FileWriter("rezultate.txt"));

        for(Student s : studenti_filtrati) {
            System.out.println(s.toString());
            bw.write(s.toString());
            bw.newLine();
        }

        bw.close();

        System.out.println("Scris in rezultate.txt");
    }
}

