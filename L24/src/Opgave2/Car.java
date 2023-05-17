package Opgave2;

public class Car {
    private String no;
    private String year;
    private int pricePerDay;

    public Car(String no, String year) {
        this.no = no;
        this.year = year;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

}
