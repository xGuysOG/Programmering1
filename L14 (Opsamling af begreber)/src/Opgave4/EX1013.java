package Opgave4;

public class EX1013 {
    public static void main(String[] args) {

        MyRectangle2D r1 = new MyRectangle2D(4, 4,5,5);

        System.out.println("r1 area " + r1.getArea() + " r1 parimeter " + r1.getPerimeter());

        System.out.println(" data of r1 1 " + r1.contains(5,3));
        System.out.println(" data of r1 2 " + r1.contains(new MyRectangle2D(5,3,2,2)));
        System.out.println(" data of r1 3 " + r1.overlaps(new MyRectangle2D(5,3,2.5,5.4)));
    }
}
