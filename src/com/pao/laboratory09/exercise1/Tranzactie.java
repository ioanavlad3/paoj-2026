package com.pao.laboratory09.exercise1;

import java.io.Serializable;
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

    @Override
    public String toString() {
        return "Tranzactie{" + "id=" + id + ", suma=" + suma + ", data='" + data + '\'' +
                ", contSursa='" + contSursa + '\'' + ", contDestinatie='" + contDestinatie + '\'' +
                ", tip=" + tip + ", note='" + note + '\'' + '}';
    }

}
