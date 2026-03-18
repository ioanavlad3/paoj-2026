package com.pao.laboratory03.exercise;

public enum Subject {
    PAOJ("Programare Avansată pe Obiecte", 6),
    BD("Baze de date", 5),
    SO("Sisteme de operare", 6),
    RC("Retele de calculatoare", 4);

    private final String fullname;
    private final int credits;

    // 2. Constructorul (este apelat automat pentru PAOJ, BD, SO)
    Subject(String fullname, int credits) {
        this.fullname = fullname;
        this.credits = credits;
    }

    // 3. Putem adăuga metode exact ca într-o clasă normală
    public String getFullname() {
        return fullname;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return name() + " (" + fullname + ", " + credits + " credite)";
    }
}