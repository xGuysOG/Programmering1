package modelarray;

import java.util.Arrays;

public class ArrayMethods {
    public void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            } else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    /**
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }

    /**
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public int[] fyldArrayB() {
        return new int[]{2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
    }

    /**
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public int[] fyldArrayC() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public int[] fyldArrayD() {
        int[] result = new int[10];

        int even = 2;
        for (int i = 0; i < result.length; i++) {
            result[i] = even;
            even += 2;
        }
        return result;
    }

    /**
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public int[] fyldArrayE() {
        int[] result = new int[10];

        for (int i = 1; i <= result.length; i++) {
            result[i - 1] = i * i;
        }

        return result;
    }

    /**
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public int[] fyldArrayF() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public int[] fyldArrayG() {
        int[] result = new int[10];
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (i % 5 == 0) {
                count = 0;
            }
            result[i] = count;
            count++;
        }
        return result;
    }

    public int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }

    public int sum(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum;
    }

    public double sum(double[] t) {
        double sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum;
    }

    public int[] makeSum(int[] a, int[] b) {
        if (a.length > b.length) {
            b = Arrays.copyOf(b, a.length);
        } else {
            a = Arrays.copyOf(a, b.length);
        }
        final int NEW_ARRAY_SIZE = Math.max(a.length, b.length);
        int[] sum = new int[NEW_ARRAY_SIZE];

        for (int i = 0; i < sum.length; i++) {
            sum[i] = a[i] + b[i];
        }
        return sum;
    }

    public boolean hasUneven(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 != 0) {
                return true;
            }
        }

        return false;
    }

    public int[] swapFirstLast(int[] t) {
        int temp = t[0];
        t[0] = t[t.length - 1];
        t[t.length - 1] = temp;
        return t;
    }

    public int[] pushRight(int[] t) {
        int last = t[t.length - 1];
        for (int i = t.length - 2; i >= 0; i--) {
            t[i + 1] = t[i];
        }

        t[0] = last;

        return t;
    }

    public int[] replaceZeros(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 0) {
                t[i] = 0;
            }
        }
        return t;
    }

    public int secondLargest(int[] t) {
        int largest = t[0];
        int secondLargest = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > largest) {
                secondLargest = largest;
                largest = t[i];
            }
        }

        return secondLargest;
    }

    public boolean isSorted(int[] t) {
        boolean sorted = true;
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i + 1] < t[i]) {
                sorted = false;
                break;
            }
        }

        return sorted;
    }

    public boolean hasDuplicates(int[] t) {
        boolean found = false;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length - 1; j++) {
                if (i == j) continue;

                if (t[i] == t[j]) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }
}
