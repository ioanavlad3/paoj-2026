package com.pao.laboratory09.exercise3;

public class Main {
    public static void main(String[] args) {
        CoadaTranzactii banda = new CoadaTranzactii();

        ProcessorThread processorRunnable = new ProcessorThread(banda);
        Thread firProcesor = new Thread(processorRunnable);

        ATMThread atm1 = new ATMThread(1, banda);
        ATMThread atm2 = new ATMThread(2, banda);
        ATMThread atm3 = new ATMThread(3, banda);

        firProcesor.start();
        atm1.start();
        atm2.start();
        atm3.start();

        try {
            atm1.join();
            atm2.join();
            atm3.join();

            System.out.println("Toate ATM-urile au terminat trimiterea.");

            processorRunnable.activ = false;

            synchronized (banda) {
                banda.notifyAll();
            }

            firProcesor.join();

            System.out.println("Toate tranzactiile procesate. Total: 12");

        } catch (InterruptedException e) {
            System.err.println("Firul principal a fost intrerupt.");
        }
    }

}

