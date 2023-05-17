package OPG_1;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 32);
		e1.printEmployee();

		e1.setFornavn("Viggo");
		e1.setAge(32);
		e1.printEmployee();

		e1.birthday();
		e1.printEmployee();
	}

}
