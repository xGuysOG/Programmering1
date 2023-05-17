package OPG_5;

public class PrimeGenerator {
    private int input;
    private int currentPrime;

    public PrimeGenerator(int input) {
        this.input = input;
        this.currentPrime = 0;
    }

    public int nextPrime() {
        for (int current = currentPrime; current < input; current++) {
            if (isPrime(current)) {
                this.currentPrime = current;
                break;
            }
        }
        return this.currentPrime;
    }

    public boolean isPrime(int check) {
        return check % check == 0 ;
    }
}
