package Opgaver;

public class EX9 {

//    Skriv en metode, der (uden brug af operationen for kvadratrod: Math.sqrt) kan beregne
//    heltalskvadratroden af et heltal n >= 0. Metoden skal altså returnere det største heltal r, der
//    opfylder: r2 <= n < (r+1)2.
//    Her er nogle eksempler:
//    n 0 2 3 4 7 8 9 10 111
//    r 0 1 1 2 2 2 3 3 10
//    Skriv en metode der anvender lineær søgning
//    Skriv en metode der anvender binær søgning
//    Hint: Der skal hverken anvendes array eller ArrayList, der skal blot søges blandt tallene 0 til
//    n.

    public static void main(String[] args) {
        int[] numbers = {0, 2, 3, 4, 7, 8, 9, 10, 111};

        for (int n : numbers) {
            int result = integerSquareRootLinear(n);
            System.out.println("Integer square root of " + n + ": " + result);
        }

        for (int n : numbers) {
            int result = integerSquareRootBinary(n);
            System.out.println("Integer square root of " + n + ": " + result);
        }
    }

    public static int integerSquareRootBinary(int n) {
        if (n == 0) {
            return 0;
        }
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;

            if (square == n) {
                return mid;
            } else if (square < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


    public static int integerSquareRootLinear(int n) {
        int r = 0;
        while ((r + 1) * (r + 1) <= n) {
            r++;
        }
        return r;
    }
}
