package com.pao.laboratory10.exercise1;

public class Tranzactie {
    private int id;
    private double suma;
    private String data;
    private TipTranzactie tip;

    public Tranzactie(int id, double suma, String data, TipTranzactie tip){
        this.id = id;
        this.suma = suma;
        this.data = data;
        this.tip = tip;
    }

    public TipTranzactie getTip() {return this.tip; }

    public double getSuma() {
        return this.suma ;
    }

    public int getId() { return this.id; }

    public String getData() {return this.data;}


    @Override
    public String toString(){
        //return "[" + this.id + "] " + this.data + " " + this.tip + ": " + this.suma + " RON";
        return String.format("[%d] %s %s: %.2f RON", this.id, this.data, this.tip, this.suma);
    }

}
