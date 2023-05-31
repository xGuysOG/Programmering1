package storage;

import model.Patient;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Patient> patienter = new ArrayList<>();

    public static void storePatient(Patient patient){
        patienter.add(patient);
    }

    public static ArrayList<Patient> getPatienter() {
        return new ArrayList<>(patienter);
    }
}
