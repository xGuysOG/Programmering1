package OPG_5;

public class Copier {
    private int paper;

    private boolean paperStuck;

    public Copier() {
        this.paper = 500;
        this.paperStuck = false;
    }

    public Copier(int paper) {
        this.paper = paper;
        this.paperStuck = false;
    }

    public int getPaper() {
        return paper;
    }

    public void insertPaper(int paper) {
        if (this.paper + paper > 500) {
            System.out.println("Ikke plads til mere papir");
            return;
        }

        this.paper = this.paper + paper;
    }

    // b
    public void makeCopy() {
        // d
        if (paper < 1) {
            System.out.println("Feed me paper");
            return;
        }

        if (paperStuck) {
            System.out.println("PAPER JAM HELFEN MIR!!!");
            return;
        }

        paper--;
    }

    public void makeCopy(int copies) {
        if (paper - copies < 1) {
            System.out.println("Ikke nok papir til at lave " + copies + " kopier");
            return;
        }

        if (paperStuck) {
            System.out.println("PAPER JAM HELFEN MIR!!!");
            return;
        }

        paper -= copies;
    }

    public void makePaperJam() {
        paperStuck = true;
    }

    public void fixJam() {
        paperStuck = false;
    }
}
