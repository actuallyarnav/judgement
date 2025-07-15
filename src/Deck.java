import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void createDeck() {
        String[] Suits = {"Spades", "Clubs", "Hearts", "Diamonds"};

        for (String suit : Suits) {
            for (int value = 1; value <= 13; value++) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public void displayDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
