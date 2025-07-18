import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    private Deck deck;
    private ArrayList<Player> players = new ArrayList<>();
    private int currentRound;

    public Game() {
        this.deck = new Deck();
        this.deck.createDeck();
        this.deck.shuffleDeck();
        this.currentRound = 1;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> initPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        players.add(new Player("brug1"));
        players.add(new Player("brug2"));
        players.add(new Player("brug3"));
        players.add(new Player(name));

        return players;
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

    //checks if hand has cards matching the lead suit
    //if yes, it returns the first instance of such a card
    //if not, it returns -1
    public int checkSuitMatchFirst(List<Card> pHand, Card firstcard) {
        int indexToPlay = -1;
        for (int h = 0; h < pHand.size(); h++) {
            if (Objects.equals(pHand.get(h).getSuit(), firstcard.getSuit())) {
                indexToPlay = h;
                break;
            }
        }
        return indexToPlay;
    }

    //returns the player that won the round
    public Player turnWinner(ArrayList<Card> playedCards, String currentSuit, String trumpSuit) {
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
