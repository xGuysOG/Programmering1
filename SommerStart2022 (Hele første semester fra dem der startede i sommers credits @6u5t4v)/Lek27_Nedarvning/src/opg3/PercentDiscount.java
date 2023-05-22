package opg3;

public class PercentDiscount extends Discount {
    private final int discountPercent;

    public PercentDiscount(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double getDiscount(double price) {
        return price * discountPercent / 100;
    }
}
