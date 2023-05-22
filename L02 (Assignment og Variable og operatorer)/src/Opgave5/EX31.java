package Opgave5;
import java.util.Scanner;

public class EX31 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double discriminantOfQudratic = Math.pow(b, 2) - 4 * a * c;
        if (discriminantOfQudratic > 0) {
            double root1 = (-b + Math.pow(discriminantOfQudratic, 0.5))/(2*a);
            double root2 = (-b - Math.pow(discriminantOfQudratic, 0.5))/(2*a);
            System.out.print("2 root to be found its root1: " + root1 + " root2: " + root2);
            //2 roots
        } else if (discriminantOfQudratic == 0) {
            //1 root
            double root1 = (-b + Math.pow(discriminantOfQudratic, 0.5))/(2*a);
            System.out.print("1 root to be found its " + root1);
        } else {
            //no root
            System.out.print("No root to be found ");
        }
    }

}
