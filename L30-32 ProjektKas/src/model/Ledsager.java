package model;

import java.util.ArrayList;

public class Ledsager {
    private String name;
    private ArrayList<Udflugt> udflugter;
    private Deltager deltager;

    public Ledsager(String name, Deltager deltager){
        this.name = name;
        this.deltager = deltager;
        udflugter = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + " Ledsager af " + "(" + deltager.getName() + ")";
    }

    public void setUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
        udflugt.addLedsager(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deltager getDeltager(){
        return this.deltager;
    }

    public ArrayList<Udflugt> getUdflugter(){
        return udflugter;
    }
}
