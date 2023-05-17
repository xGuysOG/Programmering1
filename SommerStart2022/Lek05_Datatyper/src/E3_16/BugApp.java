package E3_16;

public class BugApp {

    public static void main(String[] args) {
        Bug bugsy = new Bug(10);
        bugsy.turn();
        bugsy.move();
        System.out.println(bugsy.getPosition());
        bugsy.move();
        System.out.println(bugsy.getPosition());
        bugsy.turn();
        bugsy.move();
        System.out.println(bugsy.getPosition());
    }
}
