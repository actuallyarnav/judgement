public class Card {
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }
    @Override
    public String toString() {
        return number + " of " + suit;
    }
}
