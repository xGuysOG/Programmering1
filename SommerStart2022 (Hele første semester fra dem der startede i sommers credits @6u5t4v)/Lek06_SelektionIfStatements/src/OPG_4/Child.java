package OPG_4;

/**
 * Write a description of class Barn here.
 */
public class Child {
    private double age;
    private boolean boy; // true if the child is a boy

    public Child(double age, boolean boy) {
        this.age = age;
        this.boy = boy;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isBoy() {
        return boy;
    }

    public void setBoy(boolean boy) {
        this.boy = boy;
    }

    public String getGender() {
        return boy ? "Boy" : "Girl";
    }

    public String getInstitution() {
        String result;
        if (age >= 17) {
            result = "Out of School";
        } else if (age >= 6) {
            result = "School";
        } else if (age >= 3) {
            result = "Kindergarten";
        } else if (age >= 1.2) {
            result = "Nursery";
        } else {
            result = "Home";
        }
        return result;
    }

    public String team() {
        if (boy) {
            if (age >= 8) {
                return "Cool boys";
            } else {
                return "Young cubs";
            }
        } else {
            if (age >= 8) {
                return "Springy girls";
            } else {
                return "Tumbling girls";
            }
        }
    }

}
