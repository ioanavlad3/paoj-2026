package com.pao.laboratory05.biblioteca;

import java.util.Comparator;

public class CarteAnComparator implements Comparator<Carte> {
    @Override
    public int compare(Carte t, Carte o) {
        if (t.getAn() == o.getAn())
            return 0;
        return t.getAn() < o.getAn() ? -1 : 1;
    }
}
