package OPG_3;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(10, true);// boy 4 years old
		Child c2 = new Child(3, false);// boy 4 years old


		System.out.println("Et barn på " + c1.getAge());

		System.out.println("c1 Gender: " +c1.gender());
		System.out.println("c2 Gender: " +c2.gender());
	}

}
