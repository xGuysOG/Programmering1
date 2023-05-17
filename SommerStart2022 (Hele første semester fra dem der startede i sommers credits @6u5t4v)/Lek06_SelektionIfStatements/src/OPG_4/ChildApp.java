package OPG_4;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(10, true);// boy 4 years old
		Child c2 = new Child(3, false);// boy 4 years old

		// PIGE TESTS
		c2.setAge(6);
		System.out.println("6 årigt pige: " + c2.team());

		c2.setAge(8);
		System.out.println("8 årigt pige: " + c2.team());

		// DRENGE TESTS
		c1.setAge(6);
		System.out.println("6 årigt drenge: " + c1.team());

		c1.setAge(9);
		System.out.println("9 årigt drenge: " + c1.team());
	}

}
