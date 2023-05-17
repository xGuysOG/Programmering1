package Opgave2;

import jdk.jshell.StatementSnippet;

import java.util.List;

public class Konto {

    int nr;
    int saldo;
    String kontoType;
    String status;

    public Konto(String kontoType, int nr) {
        this.saldo = 0;
        this.status = "åben";
        this.kontoType = kontoType;
        this.nr = nr;
    }

    public void indsætBeløb(int beløb) {
        if (status.equals("åben"))  {
            saldo += beløb;
        }
    }

    public void hævBeløb(int beløb) {
        if (status.equals("åben"))  {
            saldo -= beløb;
        }
    }

    public void lukKonto(){
        status = "lukket";
    }
    public int getNr() {
        return nr;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getKontoType() {
        return kontoType;
    }

    public void setKontoType(String kontoType) {
        this.kontoType = kontoType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
