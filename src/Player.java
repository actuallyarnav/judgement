import java.util.ArrayList;

public class Player {
    private String playerName;

    private ArrayList<Card> hand;
    private int turnScore;
    private int roundScore;

    public Player(String playerName) {
        this.playerName = playerName;
        this.hand = new ArrayList<>();
        this.turnScore = 0;
        this.roundScore = 0;
    }
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void showPlayerHand() {
        int i = 1;
        for (Card cards : hand) {
            System.out.println(i + ") " + cards);
            i++;
        }
    }

    public Card playerPlaceCard(int playerCard) {
        return hand.remove(playerCard);
    }

    public Card showPlayerCard(int playerCard) {
        return hand.get(playerCard);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    //player turn score methods
    public void incrementTurnScore() {
        turnScore++;
    }
    public void resetTurnScore() {
        turnScore = 0;
    }
    public int getPlayerTurnScore() {
        return turnScore;
    }

    //player round score methods
    public void incrementRoundScore(int setScore) {
        roundScore = setScore;
    }

    public int getPlayerRoundScore() {
        return roundScore;
    }
}
