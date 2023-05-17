package application.model;

public class Address {
    private String road;
    private String city;
    private String country;
    private int zipCode;

    public Address(String road, String city, String country, int zipCode) {
        this.road = road;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getRoad() {
        return road;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getZipCode() {
        return zipCode;
    }
}
