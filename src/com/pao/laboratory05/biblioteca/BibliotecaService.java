package com.pao.laboratory05.biblioteca;

//import com.pao.laboratory04.exercise.StudentService;
import com.pao.laboratory05.playlist.Song;

import java.util.Arrays;
import java.util.Comparator;

public class BibliotecaService {
    private static BibliotecaService instance;
    private Carte[] carti = new Carte[0];

    private BibliotecaService() {}

    public static BibliotecaService getInstance() {
        if (instance == null) {
            instance = new BibliotecaService();
        }
        return instance;
    }

    public void addCarte(Carte carte){
        Carte[] newCarti = new Carte[this.carti.length + 1];
        System.arraycopy(carti, 0, newCarti, 0, this.carti.length);
        newCarti[newCarti.length - 1] = carte;

        System.out.println(carte);

        this.carti = newCarti;
    }

    public void listSortedByRating(){
        Carte[] copy = this.carti.clone();

        Arrays.sort(copy);

        for (Carte c : copy) {
            System.out.println(c);
        }
    }

    public void listSortedBy(Comparator<Carte> comparator){
        Carte[] copy = this.carti.clone();
        Arrays.sort(copy, comparator);

        for (Carte c : copy) {
            System.out.println(c);
        }
    }



}
