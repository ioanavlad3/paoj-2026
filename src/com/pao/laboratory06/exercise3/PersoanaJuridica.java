package com.pao.laboratory06.exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersoanaJuridica extends Persoana implements PlataOnlineSMS{
    List<String> smsTrimise = new ArrayList<>();


    @Override
    public boolean trimiteSMS(String mesaj) {
        if (mesaj == null || mesaj.isEmpty())
            throw new UnsupportedOperationException("argument null");
        if (Objects.equals(this.telefon, "") )
            return false;
        else {
            smsTrimise.add(mesaj);
        }
        return true;
    }

    @Override
    public void autentificare(String user, String parola) {

    }

    @Override
    public double consultareSold() {
        return 0;
    }

    @Override
    public boolean efectuearePlata(double suma) {
        return false;
    }
}
