package fuck;

public enum Types {
    RECT(150, 150),
    CIRCLE(150);


    final double[] maxSize;
    Types(double... maxSize) {
        this.maxSize = maxSize;
    }

    public double[] getMaxSize() {
        return maxSize;
    }
}
