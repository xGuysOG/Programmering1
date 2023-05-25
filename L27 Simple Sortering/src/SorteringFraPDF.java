public class SorteringFraPDF {
    public void bubbleSort(int[] arr) {
// arr has an unsorted part followed by a sorted part,
// i is the index of the last number in the unsorted part
        for (int i = arr.length-1; i > 0; i--) {
// bubble the biggest number in the unsorted part up to index i
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void selectionSort(int[] arr) {
// arr has a sorted part followed by an unsorted part
// i is the index of the first number in the unsorted part
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                int temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
// arr has a sorted part followed by an unsorted part
// i is the index of the first number in the unsorted part
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }


}
