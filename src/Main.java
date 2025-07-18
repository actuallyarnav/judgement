import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main (String[] args) {

        //counter variable that changes the trump suit, according to the array

        //creates a game object (new shuffled deck, initialises variables)
        Game game = new Game();

        //arraylists for players and played cards in a turn
        ArrayList<Player> players = game.initPlayers();
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);
        Player playerUser = players.get(3);

        ArrayList<Card> playedCards = new ArrayList<>();

        //initialising some variables
        String leadSuit = null;
        int userPlaceCard;
        int turnNumber = 1;
        int indexToPlay;

        //let the user choose the number of rounds
        Scanner totalRnd = new Scanner(System.in);
        System.out.println("How many rounds should be played?: ");
        int totalRounds = Integer.parseInt(totalRnd.nextLine());

        //round loop
        for (int rcount = 0; rcount < totalRounds; rcount ++) {

            System.out.println("\n\nRound " + (rcount+1) + ":");
            System.out.println("Current trump suit is " + game.getTrumpSuit() + "\n");
            game.distributeCards();

            //turn loop
            for (int i = 0; i < game.getRoundNumber(); i++) {

                System.out.println("Turn " + (i+1) + ":");

                //player 1 turn
                player1.showPlayerCard(0);
                //take the suit of the first played card as the "current suit"
                Card firstcard = player1.playerPlaceCard(0);
                leadSuit = firstcard.getSuit();
                playedCards.add(firstcard);
                System.out.println("\n" + player1.getPlayerName() + " played: " + firstcard);

                //player 2 turn
                List<Card> p2hand = player2.getHand();
                indexToPlay = game.checkSuitMatchFirst(p2hand, firstcard);
                if (indexToPlay == -1){
                    indexToPlay = 0;
                }

                player2.showPlayerCard(indexToPlay);
                Card p2Card = player2.playerPlaceCard(indexToPlay);

                playedCards.add(p2Card);
                System.out.println("\n" + player2.getPlayerName() + " played: " + p2Card);

                //player 3 turn
                List<Card> p3hand = player3.getHand();
                indexToPlay = game.checkSuitMatchFirst(p3hand, firstcard);
                if (indexToPlay == -1){
                    indexToPlay = 0;
                }

                player3.showPlayerCard(indexToPlay);
                Card p3Card = player3.playerPlaceCard(indexToPlay);

                playedCards.add(p3Card);
                System.out.println("\n" + player3.getPlayerName() + " played: " + p3Card);

                //user turn
                List<Card> pUserhand = playerUser.getHand();
                int userCardPlayed = -1;
                Card pUserCard = null;
                int playableSuit = game.checkSuitMatchFirst(pUserhand, firstcard);
                Scanner userCard = new Scanner(System.in);
                System.out.println("\nYour hand:");
                playerUser.showPlayerHand();
                while (pUserCard == null) {
                    System.out.println("\nWhich card would you like to play? (Enter an integer)");
                    try {
                        userCardPlayed = Integer.parseInt(userCard.next());
                        pUserCard = playerUser.playerPlaceCard(userCardPlayed - 1);
                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid number selected, enter an integer");
                    } catch (IndexOutOfBoundsException ioobe) {
                        System.err.println("Invalid card selected, choose an existing card");
                    }
                }
                playedCards.add(pUserCard);
                System.out.println("\n" + playerUser.getPlayerName() + " played: " + pUserCard);


                Player turnWinner = game.turnWinner(playedCards, leadSuit, game.getTrumpSuit());
                System.out.println("Winner of Turn " + turnNumber + " is: " + turnWinner.getPlayerName());
                turnWinner.incrementTurnScore();
                System.out.println("Turn " + turnNumber + " results:\n");
                System.out.println(player1.getPlayerName() + ": " + player1.getPlayerTurnScore());
                System.out.println(player2.getPlayerName() + ": " + player2.getPlayerTurnScore());
                System.out.println(player3.getPlayerName() + ": " + player3.getPlayerTurnScore());
                System.out.println(playerUser.getPlayerName() + ": " + playerUser.getPlayerTurnScore());

                turnNumber++;
            }
            //code to determine the round winner (simple score counts. no judgement yet, will add later)
            game.advanceRound();
            playedCards.clear();

        }
    }
}