package Opgave2;

import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 3 numbers ");

        int numb = input.nextInt();
        int numb1 = input.nextInt();
        int numb2 = input.nextInt();

        if (numb > numb1 && numb1 > numb2) {
            System.out.print("aftagende");
        }
        else if (numb < numb1 && numb1 < numb2) {
            System.out.print("stigende");
        }
        else {
            System.out.print("hverken eller");
        }
        //voksende

        //aftagende

        //hverken eller
    }

}
