package com.pao.laboratory05.audit;

import com.pao.laboratory04.exercise.StudentService;
import com.pao.laboratory04.exercise.Subject;

import java.util.Scanner;

/**
 * Exercise 3 — Angajați
 *
 * Cerințele complete se află în:
 *   src/com/pao/laboratory05/Readme.md  →  secțiunea "Exercise 3 — Angajați"
 *
 * Creează fișierele de la zero în acest pachet, apoi rulează Main.java
 * pentru a verifica output-ul așteptat din Readme.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AngajatService service = AngajatService.getInstance();
        boolean running = true;

        while (running) {
            System.out.println("\n===== Gestionare Angajați =====");
            System.out.println("1. Adaugă angajat");
            System.out.println("2. Listare după salariu");
            System.out.println("3. Caută după departament");
            System.out.println("4. Afiseaza audit log");
            System.out.println("0. Ieșire");
            System.out.print("Opțiune: ");
            // citește opțiunea și execută acțiunea
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    System.out.print("Nume: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Nume departament: ");
                    String numeDepart = scanner.nextLine().trim();
                    System.out.print("Locatie departament: ");
                    String locatieDepart = scanner.nextLine().trim();

                    System.out.println("Salariu: ");
                    double sal = Double.parseDouble(scanner.nextLine().trim());
                    Departament depart = new Departament(numeDepart, locatieDepart);
                    Angajat a = new Angajat(name, depart, sal);
                    service.addAngajat(a);
                    System.out.println("Angajat adăugat cu succes!");
                    break;

                case "2":
                    System.out.println("Listare dupa salariu");
                    service.listBySalary();
                    break;

                case "3":
                    System.out.println("Cautare dupa departament");
                    System.out.print("Nume departament: ");
                    String numeDepart2 = scanner.nextLine().trim();
                    service.findByDepartament(numeDepart2);
                    break;

                case "4":
                    System.out.println("Afiseaza dupa audit");
                    service.printAuditLog();
                    break;

                case "0":
                    running = false;
                    System.out.println("La revedere!");
                    break;

                default:
                    System.out.println("Opțiune invalidă.");
            }
        }
    }
}
