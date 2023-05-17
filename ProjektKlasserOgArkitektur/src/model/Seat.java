package model;

public class Seat {
    private int row;
    private int nr;
    private int price;
    private SeatType seatType;

    public Seat(int row, int nr, int price, SeatType seatType) {
        this.row = row;
        this.nr = nr;
        this.price = price;
        this.seatType = seatType;
    }
    public int getRow() {
        return row;
    }
    public int getNr() {
        return nr;
    }
    public int getPrice() {
        return price;
    }

    public boolean checkPos(int x, int y){
        return getRow() == x && getNr() == y;
    }

    /**
    @Override
    public String toString(){
        String s = "";

        if(price == 500){s+= "\u001B[33m ";}
        if(price == 450){s+= "\u001B[32m ";}
        if(price == 400){s+= "\u001B[34m ";}

        if(seatType == SeatType.WHEELCHAIR){
            s+="W";
        }
        if(seatType==SeatType.LONGLEGS){
            s+="L";
        }
        if(seatType==SeatType.STANDARD){
            s+="S";
        }



        return s;
    }
     */

    @Override
    public String toString() {
        return String.format("Row: %2d, Nr: %2d (kr %d, %10s)", row, nr, price, seatType.toString());
    }
}
