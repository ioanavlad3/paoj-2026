package com.pao.laboratory09.exercise3;

import com.pao.laboratory09.exercise1.Tranzactie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CoadaTranzactii {
    private Queue<Tranzactie> coada = new LinkedList<>();
    private final int CAPACITATE = 5;

    public synchronized void adauga(Tranzactie t) throws InterruptedException {
        while (coada.size() == CAPACITATE){
            wait();
        }
        coada.add(t);
        notifyAll();
    }

    public synchronized Tranzactie extrage() throws InterruptedException {
        while (coada.isEmpty()){
            wait();
        }
        Tranzactie t = coada.poll();
        notifyAll();
        return t;
    }

     public int getSize(){
         return coada.size();
     }

}
