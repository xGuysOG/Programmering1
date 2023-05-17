package OPG_1;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 */
public class Employee {
    /*
     * Attributter der beskriver den ansattes tilstand
     */
    private String fornavn;
    private String efternavn;
    private boolean trainee;
    private int age;

    /*
     * Constructor, når den ansatte oprettes, skal den have et navn. Ved
     * oprettelse er den ansatte en trainee
     */
    public Employee(String fornavn, String efternavn, int age) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.age = age;
        trainee = true;
    }

    /*
     * Den ansattes navn kan ændres ved kald af setName metoden
     */
//    public void setName(String inputName) {
//        name = inputName;
//    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    /*
     * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
     */
    public void setTrainee(boolean isTrainee) {
        trainee = isTrainee;
    }

    /*
     * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
     * isTrainee
     */
    public boolean isTrainee() {
        return trainee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("Fornavn " + fornavn);
        System.out.println("Efternavn " + efternavn);
        System.out.println("Trainee " + trainee);
        System.out.println("Age " + age);
        System.out.println();
    }

    public void birthday() {
        this.age++;
    }
}
