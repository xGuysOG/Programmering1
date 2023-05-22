package OPG_4;

public class Person {
    private String name;
    private String address;
    private double monthlySalary;
    private int companies;

    public Person(String name) {
        this.name = name;
        this.address = "";
        this.monthlySalary = 1000;
        this.companies = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void hire(){
        companies++;
        System.out.println("Hyret hos et nyt firma");
    }

    public int getCompanies() {
        return companies;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void yearlySalary(){
        double yearly = monthlySalary *12;
        double feriePenge = yearly * 0.025;

        double yearlySalary = yearly + feriePenge;

        System.out.println("Årlige Løn + feriepenge: " + yearlySalary);
    }

    public void printPerson(){
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Monthly Salary: " + monthlySalary);
    }
}
