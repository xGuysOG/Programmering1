package opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String file1 = "Lek34_Fletninger/src/opgave5/numbers.txt";
        String file2 = "Lek34_Fletninger/src/opgave5/numbers2.txt";

        findNumbers(file1, file2, "Lek34_Fletninger/src/opgave5/result.txt");
    }

    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal som de to filer har til fælles
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void findNumbers(String fileName1, String fileName2, String fileNameNy) {
        ArrayList<Integer> l1 = new ArrayList<>();
        try (Scanner in1 = new Scanner(new File(fileName1)); Scanner in2 = new Scanner(new File(fileName2))) {
            try (PrintWriter printWriter = new PrintWriter(fileNameNy)) {
                int e1 = in1.nextInt();
                int e2 = in2.nextInt();

                while (e1 < Integer.MAX_VALUE && e2 < Integer.MAX_VALUE) {
                    if (e1 <= e2) {
                        printWriter.println(e1);
                        e1 = in1.nextInt();
                    } else {
                        printWriter.println(e2);
                        e2 = in2.nextInt();
                    }
                }

                while (e1 < Integer.MAX_VALUE) {
                    printWriter.println(e1);
                    e1 = in1.nextInt();
                }

                while (e2 < Integer.MAX_VALUE) {
                    printWriter.println(e2);
                    e2 = in2.nextInt();
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
//    public static void findNumbers(String fileName1, String
//            fileName2, String fileNameNy) {
//
//        ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
//
//        try (Scanner in1 = new Scanner(new File(fileName1)); Scanner in2 = new Scanner(new File(fileName2))) {
//            // Skanner hvert tal i begge filer og putter dem in hver deres arraylist
//            while (in1.hasNextInt() && in2.hasNextInt()) {
//                l1.add(in1.nextInt());
//                l2.add(in2.nextInt());
//            }
//
//            System.out.println("Filerne er blevet skannet");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        // Flet tallene fra de to filer
//        int[] result = merge(l1, l2);
//        System.out.println("Indholdet er blevet flettet");
//
//        // Udskriver tallene fra result array til en ny fil
//        try (PrintWriter out = new PrintWriter(fileNameNy)) {
//            int i = 0;
//            while (i < result.length) {
//                out.println(result[i]);
//                i++;
//            }
//
//            System.out.println("En ny fil er genereret: " + fileNameNy);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static int[] merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
//        int i1 = 0;
//        int i2 = 0;
//        int j = 0;
//
//        int[] result = new int[l1.size() + l2.size()];
//
//        while (i1 < l1.size() && i2 < l2.size()) {
//            if (l1.get(i1) < l2.get(i2)) {
//                result[j] = l1.get(i1);
//                i1++;
//            } else if (l1.get(i1) > l2.get(i2)) {
//                result[j] = l2.get(i2);
//                i2++;
//            }
//            j++;
//        }
//
//        while (i1 < l1.size()) {
//            result[j] = l1.get(i1);
//            i1++;
//            j++;
//        }
//
//        while (i2 < l2.size()) {
//            result[j] = l2.get(i2);
//            i2++;
//            j++;
//        }
//
//        return result;
//    }
}

