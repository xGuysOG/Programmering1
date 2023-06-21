package model;

public class Kategori {

    private String navn;
    private int prisKrSingle;
    private int prisKrDouble;

    public Kategori(String navn, int prisKrSingle, int prisKrDouble) {
        this.navn = navn;
        this.prisKrSingle = prisKrSingle;
        this.prisKrDouble = prisKrDouble;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "navn='" + navn + '\'' +
                ", prisKrSingle=" + prisKrSingle +
                ", prisKrDouble=" + prisKrDouble +
                '}';
    }

    public String getNavn() {
        return navn;
    }

    public int getPrisKrSingle() {
        return prisKrSingle;
    }

    public int getPrisKrDouble() {
        return prisKrDouble;
    }


}
