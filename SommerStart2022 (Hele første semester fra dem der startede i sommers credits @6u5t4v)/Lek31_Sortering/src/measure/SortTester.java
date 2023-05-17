package measure;

import java.util.ArrayList;

public class SortTester {

    public static void main(String[] args) {
//        test1_5000();
//        test2_10000();
//        test3_25000();
//        test4_50000();
        drawGraph(1250, 1000, 5000);
    }

    private static void drawGraph(long highestTime, long time, int amount) {
        int maxLength = 64;
        int length = (int) (maxLength / (highestTime / time));

        System.out.println(length);
    }

    private static void test1_5000() {
        int testSize = 5000;

        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);


        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
//        System.out.printf("BubbleSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());

        long max = Measurer.durationMilliSeconds();

        drawGraph(max, Measurer.durationMilliSeconds(), testSize);

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
//        System.out.printf("InsertionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Insertion", Measurer.durationMilliSeconds(), testSize);
//        drawGraph(Measurer.durationMilliSeconds(), Measurer.durationMilliSeconds(), testSize);
        drawGraph(max, Measurer.durationMilliSeconds(), testSize);


        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
//        System.out.printf("SelectionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Selection", Measurer.durationMilliSeconds(), testSize);
        drawGraph(max, Measurer.durationMilliSeconds(), testSize);

    }

    private static void test2_10000() {
        int testSize = 10000;

        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
//        System.out.printf("BubbleSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());

//        drawGraph("Bubble", Measurer.durationMilliSeconds(), testSize);

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
//        System.out.printf("InsertionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Insertion", Measurer.durationMilliSeconds(), testSize);


        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
//        System.out.printf("SelectionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Selection", Measurer.durationMilliSeconds(), testSize);
    }

    private static void test3_25000() {
        int testSize = 25000;

        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
//        System.out.printf("BubbleSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());

//        drawGraph("Bubble", Measurer.durationMilliSeconds(), testSize);

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
//        System.out.printf("InsertionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Insertion", Measurer.durationMilliSeconds(), testSize);


        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
//        System.out.printf("SelectionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Selection", Measurer.durationMilliSeconds(), testSize);
    }

    private static void test4_50000() {
        int testSize = 50000;

        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
//        System.out.printf("BubbleSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());

//        drawGraph("Bubble", Measurer.durationMilliSeconds(), testSize);

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
//        System.out.printf("InsertionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Insertion", Measurer.durationMilliSeconds(), testSize);


        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
//        System.out.printf("SelectionSort (%d) -- Total time in milliseconds: %d%n",
//                testSize, Measurer.durationMilliSeconds());
//        drawGraph("Selection", Measurer.durationMilliSeconds(), testSize);
    }

}
