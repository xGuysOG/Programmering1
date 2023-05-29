package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;

    private ArrayList<Antal> antals = new ArrayList<>();
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil){
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

//    Tilføj til klassen Vagt en metode
//    findMedarbejder(LocalTime tidspunkt, int antalTimer)
//    Metoden skal returnere en medarbejder, som møder på den angivne tidspunkt, og arbejder
//    mindst det angivne antal timer. Hvis en sådan medarbejder ikke findes, skal metoden returnere
//null.
    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder medarbejderToReturn = null;
        int index = 0;
        while (medarbejderToReturn == null || index < medarbejdere.size()) {
            Medarbejder medarbejder = medarbejdere.get(index);
            if (medarbejder.getTypiskMødetid().equals(tidspunkt) &&
                medarbejder.getAntalTimerPrDag() >= antalTimer) {
                medarbejderToReturn = medarbejder;
            } else index++;
        }
        return medarbejderToReturn;
    }
//    Når der løbende laves regnskab, skal køkkenchefen kunne aflæse det samlede timeforbrug for en
//    given vagt, forstået som antallet af tilknyttede medarbejdere ganget med vagtens varighed.
//    Tilføj til klassen Vagt en metode beregnTimeforbrug() : int, der returnerer vagtens
//    samlede timeforbrug afrundet opad til nærmeste hele time.
    public int beregnTimeforbrug(){
        Duration duration = Duration.between(tidFra, tidTil);
        int math = (int) (duration.toHours() * medarbejdere.size());
        return (int) Math.ceil(math);
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion){
        int amount = 0;
        for(Medarbejder medarbejder : medarbejdere){
            for(Funktion funktion1 : medarbejder.getFunktioner()){
                if(funktion1.equals(funktion)){
                    amount++;
                    break;
                }
            }
        }
        return amount;
    }
//    Medarbejdere kan ved oprettelse få registreret deres typiske mødetid i kantinen. Ved nogle vagter
//    er det vigtigt, at der tages højde for, at alle tilknyttede medarbejdere er til stede fra vagtens start.
//    Tilføj til klassen Vagt en metode skalAdviseresOmMødetid() : Medarbejder[], der
//    returnerer et array med de medarbejdere på vagten, som har typisk mødetid senere end vagtens
//    start tid.
//public Medarbejder[] skalAdviseresOmMødetid() {
//    ArrayList<Medarbejder> medarbejdereMedSenereMødetid = new ArrayList<>();
//
//    for (Medarbejder medarbejder : medarbejdere) {
//        if (medarbejder.getTypiskMødetid().compareTo(startTid) > 0) {
//            medarbejdereMedSenereMødetid.add(medarbejder);
//        }
//    }
//
//    return medarbejdereMedSenereMødetid.toArray(new Medarbejder[0]);
//}
    public Medarbejder[] skalAdviseresOmMødetid(){
        Medarbejder[] medarbejdereMedSenereMødetid = new Medarbejder[medarbejdere.size()];
        int sizeNeeded = 0;
        //we make an array thats too big

        for(Medarbejder medarbejder : medarbejdere){
            if (medarbejder.getTypiskMødetid().isAfter(LocalTime.from(tidFra))) {
                medarbejdereMedSenereMødetid[sizeNeeded] = medarbejder;
                sizeNeeded++;
            }
        }
        //then we fill it up starting at 0 and save the size

        Medarbejder[] trimmedArray = new Medarbejder[sizeNeeded];
        for (int i = 0; i < sizeNeeded; i++) {
            trimmedArray[i] = medarbejdereMedSenereMødetid[i];
        }
        //since we started at 0 before we can now just move them from the array and return it

        return trimmedArray;

    }

//    For at en vagt kan gennemføres optimalt, skal den være tilknyttet det antal medarbejderne med
//    en given funktion, som det ved Antal er registreret, at udførelsen af vagtens opgaver kræver.
//    Tilføj til klassen Vagt en metode status() : String, der returnerer værdien ”Ressourcer
//    tildelt”, hvis der er tilknyttet det tilstrækkelige antal medarbejdere med de påkrævede funktioner
//for at vagten kan gennemføres. Hvis ikke, returneres ”Manglende resourcer”.
//    OBS: Det er et krav, at metoden anvender søgeskabelonen
    public String status() {
        //fuck this shit im out mhmm
        String test = "";
        return test;
    }

}
