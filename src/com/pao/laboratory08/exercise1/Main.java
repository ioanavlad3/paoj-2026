package com.pao.laboratory08.exercise1;

import java.io.*;
import java.util.*;

public class Main {
    // Calea către fișierul cu date — relativă la rădăcina proiectului
    private static final String FILE_PATH = "src/com/pao/laboratory08/tests/studenti.txt";

    public static void main(String[] args) throws Exception {
        // TODO: Implementează conform Readme.md
        //
        // 1. Citește studenții din FILE_PATH cu BufferedReader

        ArrayList<Student> studenti = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
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

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        String comanda = br2.readLine().trim();
        String[] tokens = comanda.split(" ");

        if (Objects.equals(tokens[0], "PRINT")){
            for (Student student : studenti){
                System.out.println(student.toString());
            }
        }

        else if (Objects.equals(tokens[0], "SHALLOW")){
            String nume = tokens[1];        // ex Ana
            Student stud = null;
            for (Student s : studenti){
                if (s.getNume().equals(nume)) {
                    stud = s;
                    break;
                }
            }

            if (stud != null){
                Student clona = stud.shallowClone();
                clona.getAdresa().setOras("MODIFICAT");
                System.out.println("Original: " + stud.toString());
                System.out.println("Clona: " + clona.toString());
            }

        }

        else if (Objects.equals(tokens[0], "DEEP")){
            String nume = tokens[1];        // ex Ana
            Student stud = null;
            for (Student s : studenti){
                if (s.getNume().equals(nume)) {
                    stud = s;
                    break;
                }
            }

            if (stud != null){
                Student clona = stud.deepClone();
                clona.getAdresa().setOras("MODIFICAT");
                System.out.println("Original: " + stud.toString());
                System.out.println("Clona: " + clona.toString());
            }

        }



        // 2. Citește comanda din stdin: PRINT, SHALLOW <nume> sau DEEP <nume>



        // 3. Execută comanda:
        //    - PRINT → afișează toți studenții
        //    - SHALLOW <nume> → shallow clone + modifică orașul clonei la "MODIFICAT" + afișează
        //    - DEEP <nume> → deep clone + modifică orașul clonei la "MODIFICAT" + afișează

        //System.out.println("TODO: implementează exercițiul 1");
    }
}
