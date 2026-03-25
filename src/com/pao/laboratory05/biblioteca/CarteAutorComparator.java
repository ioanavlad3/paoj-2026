package com.pao.laboratory05.biblioteca;

import java.util.Comparator;
import java.util.Objects;

public class CarteAutorComparator implements Comparator<Carte> {
    @Override
    public int compare(Carte t, Carte o) {
        return t.getAutor().compareTo(o.getAutor());
    }
}
