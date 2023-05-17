package application.model;

public class Bil {
    private String regNr;
    private BilMærke brand;

    public Bil(String regNr, BilMærke brand) {
        this.regNr = regNr;
        this.brand = brand;
    }

    public String getRegNr() {
        return regNr;
    }

    public BilMærke getBrand() {
        return brand;
    }

    public void setBrand(BilMærke brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return regNr + " " + brand;
    }
}
