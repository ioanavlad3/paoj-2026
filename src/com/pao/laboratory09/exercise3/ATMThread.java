package com.pao.laboratory09.exercise3;

import com.pao.laboratory09.exercise1.Tranzactie;
import com.pao.laboratory09.exercise3.CoadaTranzactii;

import static com.pao.laboratory09.exercise1.TipTranzactie.CREDIT;

public class ATMThread extends Thread {
    private int idATM;
    private CoadaTranzactii banda;

    public ATMThread(int id, CoadaTranzactii banda) {
        this.idATM = id;
        this.banda = banda;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 4; i++) {
                Tranzactie t = new Tranzactie(i, 100, "2024-01-15",
                        "", "", CREDIT);

                banda.adauga(t);

                System.out.println("[ATM-" + idATM + "] trimite: Tranzactie " + i + " suma " + t.getSuma() + " RON");
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}