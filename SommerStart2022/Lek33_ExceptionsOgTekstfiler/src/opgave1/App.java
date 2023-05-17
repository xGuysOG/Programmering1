package opgave1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Hvilket nr. primtal skal vises?: ");
            int n = scan.nextInt();
            System.out.println("Primtal nr. " + n + " er "
                    + prim[n - 1] + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Nummeret skal være mellem 1 og 10 inklusiv");
        } catch (NumberFormatException | InputMismatchException e1) {
            throw new RuntimeException("Input skal være et heltal");
        }
    }
}
