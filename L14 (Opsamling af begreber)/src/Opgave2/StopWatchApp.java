package Opgave2;

public class StopWatchApp {

    public static void main(String[] args) throws InterruptedException {
        StopWatch xD = new StopWatch();
        xD.start();
        Thread.sleep(3000);
        xD.stop();
        System.out.println("Time passed is " + xD.elapsedTime());

    }
}
