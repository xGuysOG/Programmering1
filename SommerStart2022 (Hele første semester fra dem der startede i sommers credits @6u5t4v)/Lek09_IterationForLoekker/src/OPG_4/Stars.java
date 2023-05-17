package OPG_4;

public class Stars {
    final int MAX_ROWS = 10;

    public void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureA() {
        for (int row = MAX_ROWS; row >= 0; row--) {
            for (int s = 0; s < row; s++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureB() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int spaces = MAX_ROWS - row; spaces > 0; spaces--) {
                System.out.print(' ');
            }

            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void starPictureC() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int spaces = 0; spaces > row; spaces++) {
                System.out.print(' ');
            }

            for (int s = 0; s < MAX_ROWS - row; s++) {
                System.out.print('*');
            }

            System.out.println();
        }
        System.out.println();
    }

    public void starPictureD() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int spaces = MAX_ROWS - row; spaces > 0; spaces--) {
                System.out.print(' ');
            }

            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}
