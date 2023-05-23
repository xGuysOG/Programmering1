package storage;

import model.Fag;
import model.Studerende;

import java.util.ArrayList;

public class Storage {

    public static final ArrayList<Fag> fagene = new ArrayList<>();
    public static final ArrayList<Studerende> studerendene = new ArrayList<>();

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
