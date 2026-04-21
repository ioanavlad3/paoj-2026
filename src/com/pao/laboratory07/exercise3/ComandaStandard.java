package com.pao.laboratory07.exercise3;

public final class ComandaStandard extends Comanda{

    public ComandaStandard(String nume, double pret, String client){
        super(nume, pret, client);
    }

    @Override
    public double pretFinal() {
        return this.pret;
    }

    @Override
    public String descriere() {
        return String.format("STANDARD: %s, pret: %.2f lei [PLACED] - client: %s", this.nume, this.pret, this.client);
    }
}
