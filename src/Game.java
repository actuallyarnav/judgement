import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private int currentRound;

    public Game(ArrayList<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.deck.createDeck();
        this.deck.shuffleDeck();
        this.currentRound = 1;
    }



    public int getRoundNumber() {
        return currentRound;
    }

    public void advanceRound() {
        currentRound++;
    }


    public void distributeCards() {
        for (int i = 0; i < currentRound; i++) {
            for (Player player : players) {
                player.addCardToHand(deck.drawCard());
            }
        }
    }

    public void playRound() {

    }

    //returns the player that won the round
    public Player roundWinner (ArrayList<Card> playedCards, String currentSuit, String trumpSuit) {
        int maxValue = -1;
        int trumpMaxValue = -1;
        Player regularWinner = null;
        Player trumpWinner = null;
        //i need to tell it that ace (value 1) is actually bigger than king (value 13)
        for (int i=0; i<players.size(); i++){
            Card card = playedCards.get(i);
            if (card.getNumber() > maxValue && Objects.equals(card.getSuit(), currentSuit)) {
                maxValue = card.getNumber();
                regularWinner = players.get(i);
            }
            if (card.getNumber() == 1 && Objects.equals(card.getSuit(), currentSuit)) {
                maxValue = 14;
                regularWinner = players.get(i);
            }

            if (Objects.equals(card.getSuit(), trumpSuit) && card.getNumber() > trumpMaxValue) {
                trumpMaxValue = card.getNumber();
                trumpWinner = players.get(i);
            }
            if (Objects.equals(card.getSuit(), trumpSuit) && card.getNumber() == 1) {
                trumpMaxValue = 14;
                trumpWinner = players.get(i);
            }

        }

        if (trumpWinner == null) {
            return regularWinner;
        }
        else {
            return trumpWinner;
        }
    }
}
