package yatzy.model;

import java.util.Random;

public class Yatzy {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6.
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    public Yatzy() {
        //
    }

    /**
     * Returns the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Sets the 5 face values of the dice. Pre: values contains 5 face values in
     * [1..6]. Note: This method is only meant to be used for test, and
     * therefore has package visibility.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Returns the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
     * boolean values.
     */
    public void throwDice(boolean[] holds) {
        for (int i = 0; i < values.length; i++) {
            if (!holds[i]) {
                values[i] = random.nextInt(1, values.length + 2);
            }
        }

        throwCount++;
    }

    // -------------------------------------------------------------------------

    /**
     * Returns all results possible with the current face values. The order of
     * the results is the same as on the score board. Note: This is an optional
     * method. Comment this method out, if you don't want use it.
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
        results[10] = this.smallStraightPoints();
        results[11] = this.largeStraightPoints();
        results[12] = this.fullHousePoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Returns an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v
    // <= 6.
    // Index 0 is not used.
    private int[] calcCounts() {
        int[] frequency = new int[7];

        for (int face : values) {
            int currentFrequency = frequency[face];
            frequency[face] = currentFrequency + 1;
        }

        return frequency;
    }

    /**
     * Returns same-value points for the given face value. Returns 0, if no dice
     * has the given face value. Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int[] frequency = calcCounts();
        return frequency[value] * value;
    }

    /**
     * Returns points for one pair (for the face value giving highest points).
     * Returns 0, if there aren't 2 dice with the same face value.
     */

    private final static int PAIR = 2;

    public int onePairPoints() {
        int pair = 0;
        int[] frequency = calcCounts();

        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] >= PAIR) {
                pair = i;
            }
        }

        return pair * PAIR;
    }

    /**
     * Returns points for two pairs (for the 2 face values giving highest
     * points). Returns 0, if there aren't 2 dice with one face value and 2 dice
     * with a different face value.
     */

    public int twoPairPoints() {
        int pairsFound = 0;
        int points = 0;

        int[] frequency = calcCounts();

        for (int i = frequency.length - 1; i > 0; i--) {
            if (pairsFound == PAIR) break;

            boolean pair = frequency[i] == PAIR;
            if (pairsFound == 1) {
                pair = frequency[i] >= PAIR;
            }

            if (pair) {
                points += i * PAIR;
                pairsFound++;
            }
        }

        return points;
    }

    /**
     * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with
     * the same face value.
     */
    public int threeSamePoints() {
        int highest = 0;
        int[] frequency = calcCounts();

        for (int i = 1; i < frequency.length; i++) {
            boolean same = frequency[i] >= 3;
            if (same && i > highest) {
                highest = i;
            }
        }

        return highest * 3;
    }

    /**
     * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with
     * the same face value.
     */
    public int fourSamePoints() {
        int highest = 0;
        int[] frequency = calcCounts();
        for (int i = 1; i < frequency.length; i++) {
            boolean same = frequency[i] >= 4;
            if (same && i > highest) {
                highest = i;
            }
        }

        return highest * 4;
    }

    /**
     * Returns points for full house. Returns 0, if there aren't 3 dice with one
     * face value and 2 dice a different face value.
     */
    public int fullHousePoints() {
        int threesFace = 0;
        int twosFace = 0;

        int points = 0;

        int[] frequency = calcCounts();
        for (int i = frequency.length - 1; i > 0; i--) {
            boolean found3 = frequency[i] == 3;
            boolean found2 = frequency[i] == 2;

            if (found3) {
                threesFace = i;
            }

            if (found2 && i > twosFace) {
                twosFace = i;
            }
        }

        if (threesFace != 0 && twosFace != 0) {
            points = threesFace * 3 + twosFace * 2;
        }

        return points;
    }

    /**
     * Returns points for small straight. Returns 0, if the dice are not showing
     * 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int[] frequency = calcCounts();

        for (int i = 1; i < frequency.length - 1; i++) {
            if (frequency[i] != 1) {
                return 0;
            }
        }

        return 15;
    }

    /**
     * Returns points for large straight. Returns 0, if the dice is not showing
     * 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int[] frequency = calcCounts();

        for (int i = frequency.length - 1; i > 1; i--) {
            if (frequency[i] != 1) {
                return 0;
            }
        }

        return 20;
    }

    /**
     * Returns points for chance.
     */
    public int chancePoints() {
        int[] frequency = calcCounts();
        int points = 0;

        for (int i = 1; i < frequency.length; i++) {
            points += frequency[i] * i;
        }

        return points;
    }

    /**
     * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
     * face value.
     */
    public int yatzyPoints() {
        int[] frequency = calcCounts();

        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] == 5) {
                return 50;
            }
        }

        return 0;
    }
}
