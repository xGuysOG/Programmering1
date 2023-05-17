package OPG_3;

public class Name {
    String firstName, middleName, lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getInit() {
        char f = firstName.charAt(0), m = middleName.charAt(0), l = lastName.charAt(0);

        return "" + f + m + l;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        String first = firstName.substring(0, 2).toUpperCase();
        int charsInMiddle = middleName.length();
        String last = lastName.substring(lastName.length() - 2).toLowerCase();

        return first + charsInMiddle + last;
    }
}
