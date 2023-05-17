package Opgave3.ex3student;

public class Stars {
    public static void main(String[] args) {
        exD(10);
    }

    public static void exA(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);

            // print stars
            int starCount = rowCount + 1 - row;
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }

            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void exB(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);

            // print stars
            int starCount =  row;
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }

            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void exC(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);

            int starCount = rowCount + 1 - row;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }

            // print stars
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }

            // print dashes
            System.out.println();
        }
    }

    public static void exD(int rowCounts) {
        int maxCount = rowCounts / 2;
        int rowCount = 9;
        int starCount = 0;
        for (int row = 1; row <= maxCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);
            // print stars
            if (row > 1) {
//                System.out.println(" row amount is " + row);
                starCount = starCount + 2;
            } else {
                starCount = row;
            }
            int dashCount = (rowCount - starCount) / 2;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            dashCount = (rowCount - starCount) / 2;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }

            // print dashes
            System.out.println();
        }

        for (int row = 6; row <= rowCounts; row++) {
            // print row number
            System.out.printf("%2d: ", row);
            // print stars
            if (row > 6) {
//                System.out.println(" row amount is " + row);
                starCount = starCount - 2;
            }
            int dashCount = (rowCount - starCount) / 2;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            dashCount = (rowCount - starCount) / 2;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }

            // print dashes
            System.out.println();
        }
    }
}
