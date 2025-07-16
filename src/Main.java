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
            player1.showPlayerhand();
            //take the suit of the first played card as the "current suit"
            Card firstcard = player1.playerPlaceCard(0);
            currentSuit = firstcard.getSuit();
            playedCards.add(firstcard);

            player2.showPlayerhand();
            playedCards.add(player2.playerPlaceCard(0));

            player3.showPlayerhand();
            playedCards.add(player3.playerPlaceCard(0));

            playerUser.showPlayerhand();
            playedCards.add(playerUser.playerPlaceCard(0));
        }

        Player roundWinner = game.roundWinner(playedCards, currentSuit, trumpSuit);
        System.out.println("Winner of Round " + game.getRoundNumber() + " is: " + roundWinner.getPlayerName());
    }
}