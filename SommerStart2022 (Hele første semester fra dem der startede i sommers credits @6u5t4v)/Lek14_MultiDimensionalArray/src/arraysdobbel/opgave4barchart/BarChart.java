package arraysdobbel.opgave4barchart;

import java.util.ArrayList;
import java.util.Scanner;

public class BarChart {
    private ArrayList<Column> list = new ArrayList<>();

    public ArrayList<Column> readValues() {
        System.out.println("Indtast et søjle størrelse. " + "Indtast et negativt tal for at afslutte: ");

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while (n >= 0) {
            System.out.println("Indtast søjle title: ");
            String columnName = in.next();
            list.add(new Column(columnName, n));
            System.out.println("Indtast søjle størrelse: ");
            n = in.nextInt();
        }

        return list;
    }

    /**
     * Finds and returns the max value in the list.
     *
     * @param list the list with values.
     * @return the max value found.
     */
    public int findMax(ArrayList<Column> list) {
        int max = Integer.MIN_VALUE;

        for (Column column : list) {
            if (column.getSize() > max) {
                max = column.getSize();
            }
        }

        return max;
    }

    /**
     * Prints out a BarChart of the values using the System.out.println method.
     */
    public void printBarChart() {
        int max = findMax(this.list);

        // TODO: print out bar chart
        for (Column column : list) {
            System.out.printf("%-10s %s", column.getTitle(), "*".repeat(column.getSize()));
            System.out.println();
        }
    }
}
