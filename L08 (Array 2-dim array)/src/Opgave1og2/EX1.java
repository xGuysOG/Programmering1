package Opgave1og2;

public class EX1 {
    public static void main(String[] args) {
        int[][] data = {
                {0,4,3,9,6},
                {1,3,5,2,2},
                {3,3,1,0,1},
                {0,0,9,7,1}
        };
        //1
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col] = 5;
            }
        }

//        print(data);
        //2
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (row % 2 == 0) {
                    data[row][col] = 2;
                } else {
                    data[row][col] = 3;
                }
            }
        }
//        print(data);
        //3
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (col % 2 == 0) {
                    data[row][col] = 2;
                } else {
                    data[row][col] = 3;
                }
            }
        }
        // print(data);

        //4
        int i = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (i % 2 == 0) {
                    data[row][col] = 0;
                } else {
                    data[row][col] = 1;
                }
                i++;
            }
        }

        //5

        //min and max in row = 5
        //first and last collom =5
        //Rest = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col] = 2;
                if (row == (data.length - data.length) || row == data.length - 1) {
                    data[row][col] = 5;
                }
                if (col == data[row].length - data[row].length || col == data[row].length - 1) {
                    data[row][col] = 5;
                }
            }
        }
        print(data);
//		System.out.println("Aight " + sumRow(data, 2));
//		System.out.println("Aight " + sumColumn(data, 2));

    }
    public static void print(int[][] numbers) {
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.print(numbers[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public static int sumRow(int[][]numbers, int row) {
        row = row -1;
        int sum = 0;
        for (int j = 0; j < numbers[row].length; j++) {
            sum = sum + numbers[row][j];
        }
        return sum;
    }

    public static int sumColumn(int[][]numbers, int col) {
        int sum = 0;
        col = col -1;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i][col];
        }
        return sum;
    }

    public int sum(int[][] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                sum += numbers[i][j];
            }
        }
        return sum;
    }

    public int getValueAt(int[][] numbers, int row, int col) {
        return numbers[row][col];
    }

    public void setValueAt(int[][] numbers, int row, int col, int value) {
        numbers[row][col] = value;
    }

}