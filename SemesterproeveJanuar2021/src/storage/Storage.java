package storage;

import model.Fag;
import model.Studerende;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Fag> fagene = new ArrayList<>();
    private static final ArrayList<Studerende> studerendene = new ArrayList<>();

    public static void storeFag(Fag fag){
        fagene.add(fag);
    }
    public static void storeStuderende(Studerende studerende){
        studerendene.add(studerende);
    }

    public static ArrayList<Fag> getFagene(){
        return fagene;
    }

    public static ArrayList<Studerende> getStuderendene(){
        return studerendene;
    }
}
