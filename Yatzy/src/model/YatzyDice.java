package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6 for i in [0..4]
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    /**
     * Return the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the 5 face values of the dice.<br/>
     * Pre: 1 <= values[i] <= 6 for i in [0..4].<br/>
     * Note: This method is only to be used in tests.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Return the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Reset the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Roll the 5 dice. Only roll dice that are not hold.<br/>
     * Note: holdStatus[index] is true, if die no. index is hold (for index in [0..4]).
     */
    public void throwDice(boolean[] holdStatus) {

        for(int i = 0; i < values.length; i++) {
            if (!holdStatus[i]) {
                values[i] = random.nextInt(1,values.length + 2);

            }
        }
        throwCount++;
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {
        int[] frequency = new int[7];
        int currentFrequency;
        for (int face : values) {
            currentFrequency = frequency[face];
            frequency[face] = currentFrequency + 1;
        }
        return frequency;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int[] frequency = frequency();
        return frequency[value] * value;
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int getPairValue(List<Integer> numbs, int pairToCheck) {
        int highest = 0;
        int sum = 0;
        if(pairToCheck == 2 && numbs.size() < 2){
            return 0;
        }

        if (pairToCheck == 1) {
            for (var n : numbs) {
                if (n > highest) {
                    highest = n;
                }
            }
            return highest*2;
        } else if(pairToCheck == 2) {
            for(var n : numbs) {
                sum+= n*2;
            }
            return sum;
        } else if(pairToCheck == 3 || pairToCheck == 4){
            for(var n : numbs) {
                sum+= n*pairToCheck;
            }
            return sum;
        }
        return 0;
    }

    public int getPairPoints(int pairToCheck){
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        int[] freq = frequency();
        for(int i = 0; i < freq.length; i++ ){
            if(pairToCheck == 2){
                if(freq[i] >= 2){
                    pairs.add(i);
                }
            } else if (pairToCheck == 1) {
                if(freq[i] >= pairToCheck+1){
                    pairs.add(i);
                }
            } else if ( pairToCheck == 3){
                if(freq[i] >= pairToCheck){
                    pairs.add(i);
                }
            }else if ( pairToCheck == 4){
                if(freq[i] >= pairToCheck){
                    pairs.add(i);
                }
            }
        }
        return getPairValue(pairs,pairToCheck);
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        return getPairPoints(1);
    }

    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        return getPairPoints(2);
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        return getPairPoints(3);
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        return getPairPoints(4);
    }

    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        int threeFace = 0;
        int twoFace = 0;
        int points = 0;

        int[] frequency = frequency();

        for (int i = frequency.length - 1; i > 0; i--) {
            boolean found3 = frequency[i] == 3;
            boolean found2 = frequency[i] == 2;

            if (found3) {
                threeFace = i;
            }
            if (found2 && i > twoFace){
                twoFace = i;
            }

            if (twoFace != 0 && threeFace != 0) {
                points = threeFace * 3 + twoFace * 2;
            }
        }
        return points;
    }

    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int[] frequency = frequency();
        for(int i = 1; i < frequency.length -1; i++) {
            if (frequency[i] != 1) {
                return 0;
            }
        }
        return 15;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int[] frequency = frequency();
        for(int i = frequency.length - 1; i > 1; i--) {
            if (frequency[i] != 1) {
                return 0;
            }
        }
        return 20;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        int[] frequency = frequency();
        int points = 0;
        for(int i = 1; i < frequency.length; i++) {
            points += frequency[i] * i;
        }
        return points;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {
        int[] frequency = frequency();
        for(int i = 1; i < frequency.length; i++) {
            if (frequency[i] == 5) {
                return 50;
            }
        }
        return 0;
    }
}
