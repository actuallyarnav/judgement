import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("Hello, world!");

        int trumpSuitPosition = 0;
        String[] Suits = {"Spades", "Clubs", "Hearts", "Diamonds", "None"};
        //initialize a deck object
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Card> playedCards = new ArrayList<>();


        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String playerUserName = userInput.next();

        Player player1 = new Player("brug1");
        Player player2 = new Player("brug2");
        Player player3 = new Player("brug3");
        Player playerUser = new Player(playerUserName);

        //adding created player objects to arraylist (to pass on to the game class)
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(playerUser);

        Game game = new Game(players);
        //create a standard 52 card deck

        //display the deck

        game.distributeCards();
        String trumpSuit = Suits[trumpSuitPosition];
        System.out.println("Current trump suit is " + trumpSuit);
        String currentSuit = null;
        for (int i = 0; i < game.getRoundNumber(); i++) {
            player1.showPlayerHand();
            //take the suit of the first played card as the "current suit"
            Card firstcard = player1.playerPlaceCard(0);
            currentSuit = firstcard.getSuit();
            playedCards.add(firstcard);

            player2.showPlayerHand();
            playedCards.add(player2.playerPlaceCard(0));

            player3.showPlayerHand();
            playedCards.add(player3.playerPlaceCard(0));

            playerUser.showPlayerHand();
            playedCards.add(playerUser.playerPlaceCard(0));

            /*
            //testing to see if it recognises ace as bigger
            Card p1card = new Card(13, "Spades");
            player1.addCardToHand(p1card);
            playedCards.add(player1.playerPlaceCard(0));
            player1.showPlayerHand();
            currentSuit = p1card.getSuit();

            Card p2card = new Card(1, "Diamonds");
            player2.addCardToHand(p2card);
            playedCards.add(player2.playerPlaceCard(0));
            player2.showPlayerHand();

            Card p3card = new Card(1, "Spades");
            player3.addCardToHand(p3card);
            playedCards.add(player3.playerPlaceCard(0));
            player3.showPlayerHand();

            Card p4card = new Card(12, "Hearts");
            playerUser.addCardToHand(p4card);
            playedCards.add(playerUser.playerPlaceCard(0));
            playerUser.showPlayerHand();
            */
        }

        Player roundWinner = game.roundWinner(playedCards, currentSuit, trumpSuit);
        System.out.println("Winner of Round " + game.getRoundNumber() + " is: " + roundWinner.getPlayerName());
    }
}