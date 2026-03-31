package com.pao.laboratory05.audit;

import java.util.Arrays;

public class AngajatService {
    private static AngajatService INSTANCE;
    private Angajat[] angajati = new Angajat[0];

    private AngajatService(){}

    private AuditEntry[] auditLog = new AuditEntry[0];

    public static AngajatService getInstance() {
        if (INSTANCE == null){
            INSTANCE = new AngajatService();
        }
        return INSTANCE;
    }

    private void logAction(String action, String target) {
        AuditEntry entry = new AuditEntry(action, target, java.time.LocalDateTime.now().toString());
        AuditEntry[] newAudit = new AuditEntry[auditLog.length + 1];

        System.arraycopy(auditLog, 0, newAudit, 0, auditLog.length);
        newAudit[newAudit.length - 1] = entry;

        auditLog = newAudit;
    }

    public void addAngajat(Angajat a){
        Angajat[] newAngajati = new Angajat[this.angajati.length + 1];
        System.arraycopy(this.angajati, 0, newAngajati, 0, this.angajati.length);

        newAngajati[newAngajati.length - 1] = a;

        this.angajati = newAngajati;
        System.out.println(a);

        logAction("ADD", a.getNume());
    }

    public void printAll(){
        for(Angajat a : this.angajati) {
            System.out.println(a);
        }
    }

    public void listBySalary(){
        Angajat[] copy = this.angajati.clone();
        Arrays.sort(copy);
        for(Angajat a : copy) {
            System.out.println(a);
        }
    }

    public void findByDepartament(String numeDept){
        boolean found = false;
        logAction("FIND_BY_DEPT", numeDept);

        for(Angajat a : this.angajati) {
            if(a.getDepartament().nume().equalsIgnoreCase(numeDept)){
                System.out.println(a);
                found = true;
            }
        }

        if(!found){
            System.out.println("Niciun angajat în departamentul: " + numeDept);
        }
    }

    public void printAuditLog() {
        System.out.println(" Audit Log ");
        for (AuditEntry entry : auditLog) {
            System.out.println(entry);
        }
    }

}
