package arraysdobbel.opgave1_2dobbelArray;

public class Opgave1DobbelArray {

    public static void main(String[] args) {
        int[][] values = {{0, 4, 3, 9, 6}, {1, 3, 5, 2, 2}, {3, 3, 1, 0, 1}, {0, 0, 9, 7, 1}};
        // 22 13 8 17
        DobbelArrayMethods da = new DobbelArrayMethods();
        System.out.println("Værdien af tabellen udskrives");
        da.udskrivArray(values);

        //TODO Tilføj kode der afprøver metoderne du programmerer i klassen DobbelArray til opgave 1
        System.out.println(da.getValueAt(values, 3, 4));
        System.out.println();
//        da.setValueAt(values, 3, 4, 9);
//        da.udskrivArray(values);

        System.out.println();
        System.out.println(da.sumRow(values, 3));

        System.out.println();
        System.out.println(da.sumCol(values, 2));

        System.out.println();
        System.out.println(da.sum(values));
    }


}
