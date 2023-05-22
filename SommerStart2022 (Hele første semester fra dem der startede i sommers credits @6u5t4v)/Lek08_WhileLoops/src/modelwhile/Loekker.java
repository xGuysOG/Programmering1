package modelwhile;

public class Loekker {
    public void udskriv1_10() {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");

    }

    public void udskriv1_10_iteration() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    public int summer() {
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            sum = sum + i;
            i++;

        }
        return sum;

    }

    public int summer(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum = sum + i;
            i++;
        }
        return sum;

    }

    public int multiplum(int a, int b) {
        int resultat = 0;
        int i = 0;
        while (i < a) {
            resultat = resultat + b;
            i++;
        }
        return resultat;

    }

    public int summerEven() {
        int sum = 0;
        int i = 2;
        while (i <= 100) {
            sum += i;
            i += 2;
        }

        return sum;
    }

    public int summerSquare() {

        int sum = 0;
        int i = 1;

        while (i <= 100) {
            double sqrt = Math.sqrt(i);

            if (sqrt % 1 == 0) {
                double squared = sqrt * sqrt;
                System.out.println("index: " + i);
                System.out.println("Squared: " + squared);

                sum += squared;
            }

            i++;
        }

        return sum;
    }

    public void allPowers() {
        int x = 0;
        while (x <= 20) {
            double powered = Math.pow(2, x);
            System.out.println("2^" + x + " = " + powered);
            x++;
        }
    }

    public int sumOdd(int a, int b) {
//        int counter = a;
        int sum = 0;

        while (a <= b) {
            if (a % 2 != 0) {
                sum += a;
            }

            a++;
        }

        return sum;
    }

    public int sumOfOddDigits(int number) {
        int sum = 0;
        int ciffers = number;

        while (ciffers > 0) {
            int digit = ciffers % 10;
            if (digit % 2 != 0) {
                sum = sum + digit;
            }

//            System.out.println("/ " + ciffers / 10);
//            System.out.println("% " + ciffers % 10);
            ciffers = ciffers / 10;
        }

        return sum;
    }
}
