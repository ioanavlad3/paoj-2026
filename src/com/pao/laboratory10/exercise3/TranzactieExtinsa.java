package com.pao.laboratory10.exercise3;

import com.pao.laboratory10.exercise1.TipTranzactie;
import com.pao.laboratory10.exercise1.Tranzactie;

public class TranzactieExtinsa extends Tranzactie {
    private String contSursa;
    public TranzactieExtinsa(int id, double suma, String data, TipTranzactie tip, String contSursa) {
        super(id, suma, data, tip);
        this.contSursa = contSursa;
    }

    public String getCont() {return this.contSursa;}


    @Override
    public String toString(){
        return String.format("[%d] %s %s: %.2f RON Cont = %s", this.getId(), this.getData(), this.getTip(), this.getSuma(), contSursa);
    }


}
