package Opgave2;

import com.sun.jdi.event.ExceptionEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class EX2 {
    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
// ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();
// Test of sum1() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);
        // Test of sum() method: correct sum is 61.
        System.out.println("Sum new " + sum(ints));
// Test of minimum() method: correct minimum is -16.
        System.out.println("minimum " + minimum(ints));
// Test of maximum() method: correct maximum is 45.
        System.out.println("Max " + maximum(ints));
// Test of average() method: correct average is 7.625.
        System.out.println("Average " + average(ints));
// Test of zeroes() method: correct number of zeroes is 2.
        System.out.println("Zeroes " + zeroes(ints));
// Test of evens() method: correct result is [12, 0, -16, 0, -10].
        System.out.println("evens " + evens(ints));
    }
    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }

    /**
     * Return the sum of all numbers in the list
     * Return 0 if the lit is empty
     */
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for(int i : list) {
            sum += i;
        }
        return sum;
    }
    /**
     * Return the minimum of all numbers in the list
     * Pre: the list is not empty
     */
    public static int minimum(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for(int i : list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Return the maximum of all numbers in the list
     * Pre: the list is not empty
     */
    public static int maximum(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(int i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * Return the Average of all numbers in the list
     * Pre: the list is not empty
     */
    public static double average(ArrayList<Integer> list) {
        double average = 0;
        for(int i : list) {
            average += i;
        }
        average = average/list.size();
        return average;
    }
    /**
     * Return the number of zeroes in the list
     */
    public static int zeroes(ArrayList<Integer> list) {
        int zeroes = 0;
        for(int i : list) {
            if (i == 0) {
                zeroes++;
            }
        }
        return zeroes;
    }
    /**
     * Return a new list containing the even numbers in the list
     */
    public static ArrayList<Integer> evens(ArrayList<Integer> list) {
        ArrayList<Integer> evenNumber = new ArrayList<>();
        for(int i : list) {
            if (i % 2 == 0) {
                evenNumber.add(i);
            }
        }
        return evenNumber;
    }









}