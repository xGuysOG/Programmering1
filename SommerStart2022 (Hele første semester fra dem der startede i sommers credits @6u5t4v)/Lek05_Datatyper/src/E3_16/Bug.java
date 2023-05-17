package E3_16;

public class Bug {
    private int position;

    /* DIRECTION
     * 1: Bevæg til højre
     * 2: Bevæg til venstre
     */
    private int direction;

    public Bug(int initialPosition) {
        this.position = initialPosition;
        this.direction = 1;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position += direction;
    }

    public void turn(){
        /* Samme som
            if(direction == 1){
                direction = -1;
            }else{
                direction = 1;
            }
         */
        direction = direction == 1 ? -1 : 1;
    }
}
