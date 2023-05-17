package opg1;

public class Foreman extends Mechanic {
    private int declarationInYears;
    private int appendix;

    public Foreman(String name, String adress, int apprenticeYears, int hourlyPay, int declarationInYears, int appendix) {
        super(name, adress, apprenticeYears, hourlyPay);
        this.declarationInYears = declarationInYears;
        this.appendix = appendix;
    }

    public int getDeclarationInYears() {
        return declarationInYears;
    }

    public void setDeclarationInYears(int declarationInYears) {
        this.declarationInYears = declarationInYears;
    }

    public int getAppendix() {
        return appendix;
    }

    public void setAppendix(int appendix) {
        this.appendix = appendix;
    }
}
