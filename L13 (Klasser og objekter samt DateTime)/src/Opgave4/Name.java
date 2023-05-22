package Opgave4;

public class Name {

    String firstName;
    String middelName;
    String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middelName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middelName = "";
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddelName() {
        return middelName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        if (middelName.length() > 1) {
            return firstName + " " + middelName +  " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    public String getInits() {
        String intials = "";
        intials += firstName.substring(0, 1);
        intials += middelName.substring(0, 1);
        intials += lastName.substring(0, 1);
        return intials;
    }

    public String getCryptoInits(int count) {
        String encrypted = "";
        for (int i = 0; i < getInits().length(); i++) {
            char c = getInits().charAt(i);
            if (Character.isLetter(c)) {
                // Shift the letter by the count, wrapping around if necessary
                char shifted = (char) (((c - 'A' + count) % 26) + 'A');
                encrypted += shifted;
            } else {
                // Non-letter characters are left unchanged
                encrypted += c;
            }
        }
        return encrypted;
    }

    public String getUsername() {
        String userName = "";
        userName += firstName.toUpperCase().substring(0, 2);
        userName += middelName.length();
        userName += lastName.toLowerCase().substring(lastName.length() - 2, lastName.length());
        return userName;
    }


}
