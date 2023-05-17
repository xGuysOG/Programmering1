package arraysdobbel.opgave4barchart;

public class Column {
    private String title;
    private int size;

    public Column(String name, int size) {
        this.title = name;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }
}
