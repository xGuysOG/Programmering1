package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    private ArrayList<Deltagelse> deltagelser;

    private Fag fag;
}
