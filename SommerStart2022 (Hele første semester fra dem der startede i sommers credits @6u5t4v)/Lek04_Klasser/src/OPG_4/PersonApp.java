package OPG_4;

public class PersonApp {
    public static void main(String[] args) {
        Person per = new Person("Per");
        per.yearlySalary();

        System.out.println("Har været ansat hos " + per.getCompanies() + " Virksomheder");
        per.hire();
        per.setMonthlySalary(5000);
        System.out.println("Har været ansat hos " + per.getCompanies() + " Virksomheder");

        per.yearlySalary();
    }
}
