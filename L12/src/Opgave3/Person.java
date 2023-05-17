package Opgave3;

public class Person {
	
	String name;
	
	String addresse;
	
	int monthlySalary;
	
    /** Create an employee. */
    public Person(String name, String addresse) {
        this.name = name;
        this.addresse = addresse;
    }
    
    public Person(String name) {
        this.name = name;
    }
    
    public double yearlySalary() {
    	return (monthlySalary * 12) + (monthlySalary * 0.25);
    }
    
    public void printPerson() {
    	System.out.println("****************");
    	System.out.println("* " + name);
    	System.out.println("* " + addresse);
    	System.out.println("* " + monthlySalary);
    	System.out.println("****************");
    }
    
    @Override
    public String toString() {
        return String.format("Person(%s, %s, %s)", name, addresse, monthlySalary);
    }

}
