package Opgave2;

public class KontoApp {
    public static void main(String[] args) {
        Konto konto = new Konto("Opsaring", 1);

        konto.indsætBeløb(20);
        konto.hævBeløb(10);
        konto.lukKonto();
        konto.indsætBeløb(10);

        System.out.println("Saldo " + konto.getSaldo());
        System.out.println("konto " + konto.getStatus());
    }
}
