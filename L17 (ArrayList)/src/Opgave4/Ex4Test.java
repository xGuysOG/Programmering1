package Opgave4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex4Test {
    public static ArrayList<Integer> funList = new ArrayList<>();
    public static void main(String[] args) {
        funList.addAll(List.of(5, 4,9,16,25));
        System.out.println(funList);
//        funList = swapfirstandLast(funList);
//        System.out.println(funList);
//        funList = replaceEvenZero(funList);
//        System.out.println(funList);
//        System.out.println(secondHighestInt(funList));
//        System.out.println(isSortedAscending(funList));
//        funList = shiftToRight(funList);
//        System.out.println(funList);
        System.out.println(hasDoublets(funList));

    }
    public static ArrayList<Integer> swapfirstandLast(ArrayList<Integer> list) {
        int temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set((list.size() -1), temp);
        return list;
    }
    public static ArrayList<Integer> replaceEvenZero(ArrayList<Integer> list) {
        for (int i : list) {
            if (i % 2 == 0) {
                list.set(list.indexOf(i), 0);
            }
        }
        return list;
    }

    public static int secondHighestInt(ArrayList<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() - 2);
    }

    public static boolean isSortedAscending(ArrayList<Integer> list) {
        int temp = Integer.MIN_VALUE;
        for(int i : list) {
            if (i > temp) {
                temp = i;
            } else {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> shiftToRight (ArrayList<Integer> list) {
        int temp = list.get(list.size() - 1);
        for (int i = list.size()-1; i > 0; i--) {
            list.set(i,list.get(i - 1));
        }
        list.set(0,temp);
        return list;
    }

    public static boolean hasDoublets(ArrayList<Integer> list) {
        for (int i : list) {
            int pos = list.indexOf(i);
            return list.indexOf(i) != list.lastIndexOf(i);
        }
        return false;
    }

}
