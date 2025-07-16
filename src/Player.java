import java.util.ArrayList;

public class Player {
    private String playerName;

    private ArrayList<Card> hand;

    public Player(String playerName) {
        this.playerName = playerName;
        this.hand = new ArrayList<>();
    }
    public void createPlayer(String userName) {

    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void showPlayerHand() {
        System.out.println(playerName + "'s hand:");
        for (Card cards : hand) {
            System.out.println(cards);
        }
    }

    public Card playerPlaceCard(int playerCard) {
        return hand.remove(playerCard);
    }

    public ArrayList<Card> gethand() {
        return hand;
    }

    public String getPlayerName() {
        return playerName;
    }


}
