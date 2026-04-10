package com.pao.laboratory07.exercise3;

public final class ComandaRedusa extends Comanda{
    private final int discountProcent;
    private double pretRedus;

    public ComandaRedusa(String nume, double pret, String client, int dis){
        super(nume, pret, client);
        this.discountProcent = dis;
    }

    @Override
    public double pretFinal() {
        this.pretRedus =  pret * (1 - discountProcent / 100.0);
        return pretRedus;
    }

    @Override
    public String descriere() {
        return String.format("DISCOUNTED: %s, pret: %.2f lei (-%d%%) [PLACED] - client: %s",
                this.nume, this.pretFinal(), this.discountProcent, this.client);
    }

    public int getDiscount() {
        return this.discountProcent;
    }
}
