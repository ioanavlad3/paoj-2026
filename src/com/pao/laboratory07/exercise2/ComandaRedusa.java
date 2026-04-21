package com.pao.laboratory07.exercise2;

public final class ComandaRedusa extends Comanda{
    private final int discountProcent;

    public ComandaRedusa(String nume, double pret, int dis){
        super(nume, pret);
        this.discountProcent = dis;
    }

    @Override
    public double pretFinal() {
        return pret * (1 - discountProcent / 100.0);
    }

    @Override
    public String descriere() {
        return String.format("DISCOUNTED: %s, pret: %.2f lei (-%d%%) [PLACED]",
                this.nume, this.pretFinal(), this.discountProcent);
    }
}
