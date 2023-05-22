package P5_16;

public class Card {
    public String description;

    public String notation;

    public Card(String notation) {
        this.notation = notation;
    }

    public String getDescription() {
        String fullDescription = "Unknown";

        String firstNotation = notation.substring(0, 1);
        String lastNotation = notation.substring(1);

        fullDescription = firstNotation + " of " + lastNotation;

        return "Queen of Spades";
    }

    private boolean isValidNotation(String description) {
        return true;
    }
}
