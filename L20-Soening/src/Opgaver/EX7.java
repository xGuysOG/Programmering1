package Opgaver;

public class EX7 {

//    Write a linear search method, named searchSum(), with two parameters: an int array, and a
//    positive integer representing a total.
//    The method must find a number of adjacent integers, whose sum is equal to the total
//    parameter, and return the index of the first of these integers. This is an advanced searching.

//    Header of the method: public int searchSum(int[] t, int total)

//    If t1=[4, 3, 12, 5, 7, -4, 1, 8, 12], then searchSum(t1,9) should return 3, because t1[3]+ t1[4]+
//    t1[5]+ t1[6] = 5 + 7 + (-4) + 1 = 9
    public static void main(String[] args) {
        int[] t1 = {4, 3, 12, 5, 7, -4, 1, 8, 12};
        int[] t2 = {4, 3, 2, 5, 7, -4, 1, 8, 12};
        System.out.println(searchSum(t1, 9)); // Output: 3
        System.out.println(searchSum(t2, 9)); // Output: 3
    }
    public static int searchSum(int[] t, int total) {
        for (int i = 0; i <= t.length - 1; i++) {
            //we loop through the array
            int sum = t[i];
            // Check for adjacent integers with the given sum
            for (int j = i + 1; j < t.length; j++) {
                //so first we go 4 is the sum.
                //then we add 3
                //if 7 == total(9) then return else we continue.
                //so now its 7 + 12 aka = 19 and that does not equal 9.
                sum += t[j];

                if (sum == total) {
                    return i;
                }
                if (sum > total){
                    continue;
                }
            }
        }


        return -1;
    }

}
