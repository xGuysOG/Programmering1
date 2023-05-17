package Opgave5;

public class EX104 {
	public static void main(String[] args) {
		MyPoint point1 = new MyPoint();
		MyPoint point2 = new MyPoint(10, 30.5);

		// Display the distance between point1 and point2
		System.out.println("The distance between (" 
			+ point1.x + ", " + point1.y + ") and ("
			+ point2.x + ", " + point2.y + ") is: " + 
			point1.distance(point2));
	}

}
