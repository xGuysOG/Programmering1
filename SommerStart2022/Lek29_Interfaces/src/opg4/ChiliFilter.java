package opg4;

public class ChiliFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        return ((Measurable) x).getMeasure() > 5000;
    }
}
