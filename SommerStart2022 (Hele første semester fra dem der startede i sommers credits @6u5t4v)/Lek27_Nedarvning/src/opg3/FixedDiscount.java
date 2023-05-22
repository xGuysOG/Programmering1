package opg3;

public class FixedDiscount extends Discount {
    private final int fixedDiscount;
    private final int discountLimit;

    public FixedDiscount(int fixedDiscount, int discountLimit) {
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    @Override
    public double getDiscount(double price) {
        if (price > discountLimit) {
            return fixedDiscount;
        }

        return 0;
    }
}
