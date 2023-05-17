package modelchild;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(0, true);
		Child c2 = new Child(2, false);
		Child c3 = new Child(4, true);
		Child c4 = new Child(9, false);
		Child c5 = new Child(1, true);

		System.out.println("Et barn på " + c1.getAge());

		System.out.println("Største vægt forhøjelse: " + c1.getIncrease());

		Institution institution = new Institution("22S", "Sønderhøj");
		institution.addChild(c1);
		institution.addChild(c2);
		institution.addChild(c3);
		institution.addChild(c4);
		institution.addChild(c5);

		System.out.println("Gennemsnitlige alder på insitution: " + institution.averageAge());
		System.out.println("Piger: " + institution.numberOfGirls());
		System.out.println("Drenge: " + institution.numberOfBoys());
	}

}
