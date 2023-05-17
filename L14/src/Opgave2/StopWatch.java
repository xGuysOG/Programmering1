package Opgave2;

import java.time.LocalDate;
import java.time.LocalTime;

public class StopWatch {

    LocalTime startTime;
    LocalTime endTime;

    public StopWatch() {
    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        endTime = LocalTime.now();
    }

    public double elapsedTime() {
        return endTime.toSecondOfDay() - startTime.toSecondOfDay() ;
    }


}
