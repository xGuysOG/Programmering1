package arraysdobbel.opgave1_2dobbelArray;

/**
 * @author mad
 */
public class DobbelArrayMethods {

    public void udskrivArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + "  ");
            }
            System.out.println();
        }
    }

    // Opgave 1.1
    public int getValueAt(int[][] numbers, int row, int col) {
        return numbers[row][col];
    }

    // Opgave 1.2
    public void setValueAt(int[][] numbers, int row, int col, int value) {
        numbers[row][col] = value;
    }

    // Opgave 1.3
    public int sumRow(int[][] numbers, int row) {
        int sum = 0;
        for (int i = 0; i < numbers[row].length; i++) {
            sum += numbers[row][i];
        }
        return sum;
    }

    // Opgave 1.4
    public int sumCol(int[][] numbers, int col) {
        //TODO returner summen af tallene i kolonnen col
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i][col];
        }
        return sum;
    }

    // Opgave 1.5
    public int sum(int[][] numbers) {
        //TODO returnerer summen af alle tallene i numbers
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                sum += numbers[i][j];
            }
        }
        return sum;
    }

}
