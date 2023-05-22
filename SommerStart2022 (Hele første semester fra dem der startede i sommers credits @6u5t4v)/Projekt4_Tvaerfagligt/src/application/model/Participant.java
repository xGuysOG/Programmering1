package application.model;

public class Participant {
    private String name;
    private String phoneNr;
    private Address address;

    // Optional attributes
    private String companyName;
    private String companyNr;

    public Participant(String name, String phoneNr, Address address) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.address = address;
    }

    public Participant(String name, String phoneNr, Address address, String companyName, String companyNr) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.address = address;
        this.companyName = companyName;
        this.companyNr = companyNr;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public Address getAddress() {
        return address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyNr() {
        return companyNr;
    }

    public void setCompany(String companyName, String companyNr) {
        this.companyName = companyName;
        this.companyNr = companyNr;
    }
}
