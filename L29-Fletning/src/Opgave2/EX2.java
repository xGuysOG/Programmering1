package Opgave2;

public class EX2 {
//    in this exercise you are going to merge two arrays containing integers.
//    a) Program the following method in the method class:
//    /**
//     * Return a sorted array containing all elements
//     * shared by l1 and l2.
//     * The returned array must have no empty entries.
//     * Pre: l1 and l2 are sorted and have no empty entries.
//     */
//    public static int[] sharedNumbers (int[] l1, int[] l2)
//    b) Create two arrays in the main() method (perhaps {2,4,6,8,10,12,14} and
//    {1,2,4,5,6,9,12,17}).
//    c) Use the method sharedNumbers() with the two arrays and print the result. (With the two
//    arrays above the result will be {2,4,6,12}).
    public static void main(String[] args) {

    }
     /**
     * Return a sorted array containing all elements
     * shared by l1 and l2.
     * The returned array must have no empty entries.
     * Pre: l1 and l2 are sorted and have no empty entries.
     */
     public static int[] sharedNumbers(int[] l1, int[] l2) {
         int size = Math.min(l1.length, l2.length);
         int[] result = new int[size];

         int i = 0; // index for l1
         int j = 0; // index for l2
         int k = 0; // index for result array

         while (i < l1.length && j < l2.length) {
             if (l1[i] < l2[j]) {
                 i++;
             } else if (l1[i] > l2[j]) {
                 j++;
             } else {
                 result[k++] = l1[i];
                 i++;
                 j++;
             }
         }

         // Resize the result array if necessary
         if (k < size) {
             int[] temp = new int[k];
             System.arraycopy(result, 0, temp, 0, k);
             result = temp;
         }

         return result;
     }
}
