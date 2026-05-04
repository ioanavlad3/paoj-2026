package com.pao.laboratory09.exercise3;

import com.pao.laboratory09.exercise1.Tranzactie;

public class ProcessorThread implements Runnable {
    private CoadaTranzactii coada;
    public volatile boolean activ = true;

    public ProcessorThread(CoadaTranzactii coada) {
        this.coada = coada;
    }

    @Override
    public void run() {
        while (activ || coada.getSize() > 0){
            try {
                Tranzactie t = coada.extrage();
                System.out.println("Tranzactie procesata: " + t);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
