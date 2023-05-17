package pairofdices;


/**
 * This class models one pair of dices.
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
    private Die die1;
    /**
     * The second die in the pair.
     */
    private Die die2;

    private int sides = 6;

    private int rollDicesAmount = 0;
    private int sameEyedDices = 0;

    private int ones = 0;
    private int twoes = 0;
    private int threes = 0;
    private int fours = 0;
    private int fives = 0;
    private int sixes = 0;

    private int[] eyesCounter = new int[6];

    private int highestThrow = 0;

    /**
     * Constructor for objects of class PairOfDices
     */

    public PairOfDices() {
        die1 = new Die();
        die2 = new Die();
    }

    // TODO: put the second constructor here!
    public PairOfDices(int sides) {
        this.sides = sides;
        die1 = new Die(sides);
        die2 = new Die(sides);
    }

    // TODO: Add methods here
    public void rollBothDices() {
        die1.roll();
        die2.roll();

        int die1Eyes = die1.getFaceValue();
        int die2Eyes = die2.getFaceValue();

        countEyes(die1Eyes);
        countEyes(die2Eyes);

        if (die1Eyes == die2Eyes) {
            sameEyedDices++;
        }

        rollDicesAmount++;
    }

    public int sumOfDices() {
        int sum = die1.getFaceValue() + die2.getFaceValue();
        if (sum > highestThrow) {
            highestThrow = sum;
        }

        return sum;
    }

    public void resetPairOfDices() {
        die1 = new Die(sides);
        die2 = new Die(sides);

        rollDicesAmount = 0;
        sameEyedDices = 0;

        ones = 0;
        twoes = 0;
        threes = 0;
        fours = 0;
        fives = 0;
        sixes = 0;

        highestThrow = 0;
    }

    private void countEyes(int eyes) {

        if (eyes == 6) {
            sixes++;
        } else if (eyes == 5) {
            fives++;
        } else if (eyes == 4) {
            fours++;
        } else if (eyes == 3) {
            threes++;
        } else if (eyes == 2) {
            twoes++;
        } else {
            ones++;
        }
    }

    public int getRollDicesAmount() {
        return rollDicesAmount;
    }

    public int getSameEyedDices() {
        return sameEyedDices;
    }

    public int getOnes() {
        return ones;
    }

    public int getTwoes() {
        return twoes;
    }

    public int getThrees() {
        return threes;
    }

    public int getFours() {
        return fours;
    }

    public int getFives() {
        return fives;
    }

    public int getSixes() {
        return sixes;
    }

    public int getHighestThrow() {
        return highestThrow;
    }
}
