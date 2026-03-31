package com.pao.laboratory03.collections;

import java.util.*;

/**
 * Exercițiul 1 — Colecții: HashMap și TreeMap
 *
 * Creează în acest main:
 *
 * PARTEA A — HashMap (frecvența cuvintelor)
 * 1. Declară un array de String-uri:
 *    String[] words = {"java", "python", "java", "c++", "python", "java", "rust", "c++", "go"};
 * 2. Creează un HashMap<String, Integer> care contorizează de câte ori apare fiecare cuvânt.
 *    - Parcurge array-ul și folosește put() + getOrDefault() pentru a incrementa contorul.
 * 3. Afișează map-ul.
 * 4. Verifică dacă există cheia "rust" cu containsKey().
 * 5. Afișează DOAR cheile (keySet()), apoi DOAR valorile (values()).
 * 6. Parcurge map-ul cu entrySet() și afișează "cheia -> valoarea" pentru fiecare intrare.
 *
 * PARTEA B — TreeMap (sortare automată)
 * 7. Creează un TreeMap<String, Integer> din același HashMap (constructor cu argument).
 * 8. Afișează TreeMap-ul — observă ordinea alfabetică a cheilor.
 * 9. Folosește firstKey() și lastKey() pentru a afișa prima și ultima cheie.
 *
 * PARTEA C — Map cu obiecte
 * 10. Creează un HashMap<String, List<String>> care asociază materii cu liste de studenți.
 *     Exemplu: "PAOJ" -> ["Ana", "Mihai", "Ion"], "BD" -> ["Ana", "Elena"]
 * 11. Afișează toți studenții de la materia "PAOJ".
 * 12. Adaugă un student nou la "BD" și afișează lista actualizată.
 *
 * Output așteptat (orientativ — ordinea HashMap poate varia):
 *
 * === PARTEA A: HashMap — frecvența cuvintelor ===
 * Frecvență: {python=2, c++=2, java=3, rust=1, go=1}
 * Conține 'rust'? true
 * Chei: [python, c++, java, rust, go]
 * Valori: [2, 2, 3, 1, 1]
 * python -> 2
 * c++ -> 2
 * java -> 3
 * rust -> 1
 * go -> 1
 *
 * === PARTEA B: TreeMap — sortare automată ===
 * Sortat: {c++=2, go=1, java=3, python=2, rust=1}
 * Prima cheie: c++
 * Ultima cheie: rust
 *
 * === PARTEA C: Map cu obiecte ===
 * Studenți la PAOJ: [Ana, Mihai, Ion]
 * Studenți la BD (actualizat): [Ana, Elena, George]
 */
public class Main {
    public static void main(String[] args) {

        // ArrayList — ordonat, permite duplicate, acces prin index
        System.out.println("=== 1. ArrayList ===");
        List<String> list = new ArrayList<>();
        list.add("Ana");
        list.add("Maria");
        list.add("Ion");
        list.add("Ana");
        System.out.println("Lista: " + list);
        System.out.println("Dimensiune: " + list.size());
        System.out.println("Index 1: " + list.get(1));
        list.remove(0);
        System.out.println("După remove(0): " + list);

        System.out.println("\nParcurgere cu for clasic:");
        for (int i = 0; i < list.size(); i++)
            System.out.println("  [" + i + "] " + list.get(i));

        System.out.println("\nParcurgere cu enhanced for:");
        for (String name : list)
            System.out.println("  " + name);

        System.out.println("\nParcurgere cu forEach + lambda:");
        list.forEach(name -> System.out.println("  " + name));

        // HashSet — fără duplicate, ordine imprevizibilă
        System.out.println("\n=== 2. HashSet ===");
        Set<String> set = new HashSet<>();
        set.add("Ana");
        set.add("Maria");
        set.add("Ion");
        set.add("Ana"); // ignorat — duplicat
        System.out.println("Set: " + set);
        System.out.println("Dimensiune: " + set.size());
        System.out.println("Conține \"Ion\"? " + set.contains("Ion"));

        // TreeSet — fără duplicate, sortat natural
        System.out.println("\n=== 3. TreeSet ===");
        TreeSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Maria");
        sortedSet.add("Ana");
        sortedSet.add("Zoe");
        sortedSet.add("Ion");
        System.out.println("TreeSet: " + sortedSet);
        System.out.println("Primul: " + sortedSet.first());
        System.out.println("Ultimul: " + sortedSet.last());
    }
}

