package Opgave7;

import java.util.Scanner;

public class EX1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 3 numbers ");

        int numb = input.nextInt();
        int numb1 = input.nextInt();
        int numb2 = input.nextInt();

        System.out.println(order(numb, numb1, numb2));
        //voksende

        //aftagende

        //hverken eller
    }

    public static String order(int numb, int numb1, int numb2) {
        if (numb > numb1 && numb1 > numb2) {
            return "aftagende";
        }
        else if (numb < numb1 && numb1 < numb2) {
            return "stigende";
        }
        else {
            return "hverken eller";
        }
    }

}
