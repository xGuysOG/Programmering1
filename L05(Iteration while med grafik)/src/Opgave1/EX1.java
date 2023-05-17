package Opgave1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EX1 {

    public static ArrayList<Integer> currentInts = new ArrayList<Integer>();
    public static void main(String[] args) {
        System.out.println("Please input some numbers last number has to be 0");
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        int toAdd = 0;
        while (cont) {
            toAdd = scanner.nextInt();
            if (toAdd != 0){
                currentInts.add(toAdd);
            } else{
                cont = false;
            }
        }
        ExcerciseB(currentInts);

    }

    public static void ExcerciseB(ArrayList<Integer> list) {
        int math = 0;
        for(int i = 0; i < list.size(); i++) {
            math += list.get(i);
            System.out.print(math + " ");
        }
    }

    public static void ExcerciseA(ArrayList<Integer> list) {
        Collections.sort(list);
        int even = 0;
        int odd = 0;
        System.out.println("Amount of xD is " + list.size());
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0)
            {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Amount of even is " + even);
        System.out.println("Amount of odd is " + odd);
        System.out.println("Smalles number is " + list.get(0));
        System.out.println("Largest number is " + list.get(list.size() - 1));
    }
}
