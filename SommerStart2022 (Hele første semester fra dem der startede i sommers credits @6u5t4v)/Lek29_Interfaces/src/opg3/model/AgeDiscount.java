package opg3.model;

public class AgeDiscount implements Discount {
    private int yearOfBirth;

    public AgeDiscount(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public double getDiscount(double price) {
        return price * ((float) yearOfBirth / 100);
    }
}
