package Opgave5;

public class FileUtilTest {
    public static void main(String[] args) {
        int data = 0;

        //MAX
        try {
            data = FileUtil.max("L28/src/Opgave5/numbers.txt");
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        System.out.println("Max is " + data);


        try {
            data = FileUtil.max("L28/src/Opgave5/numbers1.txt");
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        System.out.println("Max2 is " + data);

        //MIN
        try {
            data = FileUtil.min("L28/src/Opgave5/numbers.txt");
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        System.out.println("min is " + data);

        try {
            data = FileUtil.min("L28/src/Opgave5/numbers1.txt");
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        System.out.println("min2 is " + data);


        //AVERAGE
        double average = 0;
        try {
            average = FileUtil.average("L28/src/Opgave5/numbers.txt");
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        System.out.println("average is " + average);

        try {
            average = FileUtil.average("L28/src/Opgave5/numbers1.txt");
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        System.out.println("average is " + average);
    }


}
