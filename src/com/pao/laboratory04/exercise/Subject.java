package com.pao.laboratory04.exercise;

public enum Subject {
    PAOJ("Programare Avansată pe Obiecte", 6),
    BD("Baze de date", 5),
    SO("Sisteme de operare", 6),
    RC("Retele de calculatoare", 4);

    private final String fullname;
    private final int credits;

    Subject(String fullname, int credits) {
        this.fullname = fullname;
        this.credits = credits;
    }

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