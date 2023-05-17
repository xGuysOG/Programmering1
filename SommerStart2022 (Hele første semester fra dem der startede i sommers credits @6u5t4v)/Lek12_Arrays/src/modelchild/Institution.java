package modelchild;

import java.util.Arrays;

public class Institution {
    private String name;
    private String address;

    private final Child[] children;
    private int numberOfChildren;
    private static final int MAX_CHILDREN = 100;

    public Institution(String name, String address) {
        this.name = name;
        this.address = address;
        this.children = new Child[MAX_CHILDREN];
    }

    public void addChild(Child child) {
        if (numberOfChildren < MAX_CHILDREN) {
            children[numberOfChildren] = child;
            numberOfChildren++;
        }
    }

    public int averageAge() {
        if (numberOfChildren > 0) {
            int ageSum = 0;
            for (int i = 0; i < numberOfChildren; i++) {
                ageSum += children[i].getAge();
            }

            return ageSum / numberOfChildren;
        }
        return -1;
    }

    public int numberOfGirls() {
        return numberOfChildren - numberOfBoys();
    }
    public int numberOfBoys() {
        int boys = 0;
        for (int i = 0; i < numberOfChildren; i++) {
            if (children[i].isBoy()) {
                boys++;
            }
        }

        return boys;
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
}
