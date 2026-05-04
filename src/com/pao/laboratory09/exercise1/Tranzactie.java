package com.pao.laboratory09.exercise1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Tranzactie implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private double suma;
    private String data;
    private String contSursa;
    private String contDestinatie;
    private TipTranzactie tip;
    transient String note;   // nu participa la serializare si primeste null la deserializare

    public Tranzactie(int id, double suma, String data, String contSursa,
                      String contDestinatie, TipTranzactie tip) {
        this.id = id;
        this.suma = suma;
        this.data = data;
        this.contSursa = contSursa;
        this.contDestinatie = contDestinatie;
        this.tip = tip;
    }

    public void setNote(String note) { this.note = note; }

    public String getData(){
        return this.data;
    }

    public String getNote(){
        return this.note;
    }

    public int getId(){
        return this.id;
    }

    public double getSuma() { return this.suma; }

    public TipTranzactie getTip() {return this.tip; }


    @Override
    public String toString() {
        return String.format("[%d] %s %s: %.2f RON | %s -> %s",
                id, data, tip, suma, contSursa, contDestinatie);
    }

}
