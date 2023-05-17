package Opgave5;

public class MyPoint {
	double x;
	double y;
	
	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}
	
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(MyPoint myPoint) {
	    return Math.sqrt((myPoint.y - y) * (myPoint.y - y) + (myPoint.x - x) * (myPoint.x - x));
	}
	
	public double distance(double x, double y) {
		return distance(new MyPoint(x ,y));
	}
	
    @Override
    public String toString() {
        return String.format("Employee(%s, %s)", x ,y);
    }
    
//	MyPoint
//	x: double
//	y: double
//	+ MyPoint(x: double, y: double)
//	+ MyPoint()
//  + distance(myPoint: MyPoint)
//  + distance(x: double, y: double)
//	+ toString(): String

}
