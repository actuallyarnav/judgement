public class Card {
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        if (number == 1) {
            return "Ace of " + suit;
        }
        else if (number == 11) {
            return "Jack of " + suit;
        }
        else if (number == 12) {
            return "Queen of " + suit;
        }
        else if (number == 13) {
            return "King of " + suit;
        }
        else {
            return number + " of " + suit;
        }
    }
}
