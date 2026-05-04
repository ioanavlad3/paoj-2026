package com.pao.laboratory09.exercise2;

import com.pao.laboratory09.exercise1.TipTranzactie;
import com.pao.laboratory09.exercise1.Tranzactie;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

import com.pao.laboratory09.exercise1.TipTranzactie;
import com.pao.laboratory09.exercise1.Tranzactie;

public class Main {
    private static final String OUTPUT_FILE = "output/lab09_ex2.bin";
    private static final int RECORD_SIZE = 32;

    public static void main(String[] args) throws Exception {
        // TODO: Implementează conform Readme.md
        //
        // 1. Citește N din stdin, apoi cele N tranzacții (id suma data tip)
        // 2. Scrie toate înregistrările în OUTPUT_FILE cu DataOutputStream (format binar, RECORD_SIZE=32 bytes/înreg.)
        //    - bytes 0-3:   id (int, little-endian via ByteBuffer)
        //    - bytes 4-11:  suma (double, little-endian via ByteBuffer)
        //    - bytes 12-21: data (String, 10 chars ASCII, paddat cu spații la dreapta)
        //    - byte 22:     tip (0=CREDIT, 1=DEBIT)
        //    - byte 23:     status (0=PENDING, 1=PROCESSED, 2=REJECTED)
        //    - bytes 24-31: padding (zerouri)
        // 3. Procesează comenzile din stdin până la EOF cu RandomAccessFile:
        //    - READ idx       → seek(idx * RECORD_SIZE), citește și afișează înregistrarea
        //    - UPDATE idx ST  → seek(idx * RECORD_SIZE + 23), scrie noul status (0/1/2)
        //                       afișează "Updated [idx]: STATUS"
        //    - PRINT_ALL      → citește și afișează toate înregistrările
        //
        // Format linie output:
        //   [idx] id=<id> data=<data> tip=<CREDIT|DEBIT> suma=<suma:.2f> RON status=<STATUS>

        Scanner scanner = new Scanner(System.in);
        List<Tranzactie> tranzactii = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0 ; i < n ; i ++){
            int id = scanner.nextInt();
            double suma = scanner.nextDouble();
            String data = scanner.next();
            TipTranzactie tip = TipTranzactie.valueOf(scanner.next());

            Tranzactie tranzactie = new Tranzactie(id, suma, data, "", "", tip);

            tranzactii.add(tranzactie);
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(OUTPUT_FILE))) {
            for (Tranzactie t : tranzactii) {
                ByteBuffer buffer = ByteBuffer.allocate(RECORD_SIZE);
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                buffer.putInt(t.getId());
                buffer.putDouble(t.getSuma());
                String dataPadded = String.format("%-10s", t.getData()).substring(0, 10);
                buffer.put(dataPadded.getBytes());
                buffer.put((byte) (t.getTip() == TipTranzactie.CREDIT ? 0 : 1));
                buffer.put((byte) 0); // status initial PENDING
                buffer.put(new byte[8]); // padding
                dos.write(buffer.array());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(RandomAccessFile raf = new RandomAccessFile(OUTPUT_FILE, "rw")) {
            while (scanner.hasNext()) {
                String command = scanner.next();

                switch (command) {
                    case "READ": {
                        int idx = scanner.nextInt();
                        raf.seek(idx * RECORD_SIZE);
                        byte[] recordBytes = new byte[RECORD_SIZE];
                        raf.read(recordBytes);
                        ByteBuffer buffer = ByteBuffer.wrap(recordBytes);
                        buffer.order(ByteOrder.LITTLE_ENDIAN);
                        int id = buffer.getInt();
                        double suma = buffer.getDouble();
                        byte[] dataBytes = new byte[10];
                        buffer.get(dataBytes);
                        String data = new String(dataBytes).trim();
                        byte tipByte = buffer.get();
                        TipTranzactie tip = (tipByte == 0) ? TipTranzactie.CREDIT : TipTranzactie.DEBIT;
                        byte statusByte = buffer.get();
                        String statusStr = switch (statusByte) {
                            case 0 -> "PENDING";
                            case 1 -> "PROCESSED";
                            case 2 -> "REJECTED";
                            default -> "UNKNOWN";
                        };
                        System.out.printf("[%d] id=%d data=%s tip=%s suma=%.2f RON status=%s%n",
                                idx, id, data, tip, suma, statusStr);
                        break;
                    }
                    case "UPDATE": {
                        int idx = scanner.nextInt();
                        String statusWord = scanner.next();

                        int statusCode = switch (statusWord) {
                            case "PENDING" -> 0;
                            case "PROCESSED" -> 1;
                            case "REJECTED" -> 2;
                            default -> -1;
                        };

                        if (statusCode != -1) {
                            raf.seek(idx * RECORD_SIZE + 23); // Offset-ul pentru status
                            raf.write(statusCode);

                            System.out.printf("Updated [%d]: %s%n", idx, statusWord);
                        } else {
                            System.out.println("Status invalid: " + statusWord);
                        }
                        break;
                    }
                    case "PRINT_ALL": {
                        long totalRecords = raf.length() / RECORD_SIZE;
                        for (int i = 0; i < totalRecords; i++) {
                            raf.seek(i * RECORD_SIZE);
                            byte[] recordBytes = new byte[RECORD_SIZE];
                            raf.read(recordBytes);
                            ByteBuffer buffer = ByteBuffer.wrap(recordBytes);
                            buffer.order(ByteOrder.LITTLE_ENDIAN);
                            int id = buffer.getInt();
                            double suma = buffer.getDouble();
                            byte[] dataBytes = new byte[10];
                            buffer.get(dataBytes);
                            String data = new String(dataBytes).trim();
                            byte tipByte = buffer.get();
                            TipTranzactie tip = (tipByte == 0) ? TipTranzactie.CREDIT : TipTranzactie.DEBIT;
                            byte statusByte = buffer.get();
                            String statusStr = switch (statusByte) {
                                case 0 -> "PENDING";
                                case 1 -> "PROCESSED";
                                case 2 -> "REJECTED";
                                default -> "UNKNOWN";
                            };
                            System.out.println(String.format("[%d] id=%d data=%s tip=%s suma=%.2f RON status=%s",
                                    i, id, data, tip, suma, statusStr));

                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();}

    }
}
