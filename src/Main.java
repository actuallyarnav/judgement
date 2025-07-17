import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final int TOTAL_SUIT_LOOP = 5;

    public static void main (String[] args) {
        /*
        * public static void main(String[] args) {
    Game game = new Game();
    List<Player> players = initializePlayers();

    game.setPlayers(players);
    game.shuffleAndDealCards();

    int trumpSuitPosition = 0;

    for (int i = 0; i < game.getTotalRounds(); i++) {
        System.out.println("Round " + (i + 1));
        Suit trump = determineTrump(trumpSuitPosition);
        game.setTrumpSuit(trump);

        playRound(game, players, i);

        game.calculateTurnScores(players, trump);
        Player winner = game.determineRoundWinner(players);
        System.out.println("Round Winner: " + winner.getName());

        trumpSuitPosition = (trumpSuitPosition + 1) % 6;
        game.advanceRound();
    }

    game.printFinalResults(players);
}
 */

        //counter variable that changes the trump suit, according to the array
        int trumpSuitPosition = 0;
        String[] Suits = {"Spades", "Clubs", "Hearts", "Diamonds", "None"};
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
        String currentSuit = null;
        int userPlaceCard;
        int indexToPlay;
        int turnNumber = 1;

        //let the user choose the number of rounds
        Scanner totalRnd = new Scanner(System.in);
        System.out.println("How many rounds should be played?: ");
        int totalRounds = Integer.parseInt(totalRnd.nextLine());

        //round loop
        for (int rcount = 0; rcount < totalRounds; rcount ++) {
            String trumpSuit = Suits[trumpSuitPosition];
            System.out.println("\n\nRound " + (rcount+1) + ":");
            System.out.println("Current trump suit is " + trumpSuit + "\n");
            game.distributeCards();

            //turn loop
            for (int i = 0; i < game.getRoundNumber(); i++) {
                playedCards.clear();

                System.out.println("Turn " + (i+1) + ":");

                //player 1 turn
                player1.showPlayerCard(0);
                //take the suit of the first played card as the "current suit"
                Card firstcard = player1.playerPlaceCard(0);
                currentSuit = firstcard.getSuit();
                playedCards.add(firstcard);
                System.out.println("\n" + player1.getPlayerName() + " played: " + firstcard);

                //player 2 turn
                List<Card> p2hand = player2.getHand();
                Card p2Card = null;
                indexToPlay = -1;
                for (int h = 0; h < p2hand.size(); h++) {
                    if (Objects.equals(p2hand.get(h).getSuit(), firstcard.getSuit())) {
                        indexToPlay = h;
                        break;
                    }
                }
                if (indexToPlay != -1) {
                    player2.showPlayerCard(indexToPlay);
                    p2Card = player2.playerPlaceCard(indexToPlay);

                } else {
                    player2.showPlayerCard(0);
                    p2Card = player2.playerPlaceCard(0);

                }
                playedCards.add(p2Card);
                System.out.println("\n" + player2.getPlayerName() + " played: " + p2Card);

                //player 3 turn
                List<Card> p3hand = player3.getHand();
                Card p3Card = null;
                indexToPlay = -1;
                for (int h = 0; h < p3hand.size(); h++) {
                    if (Objects.equals(p3hand.get(h).getSuit(), firstcard.getSuit())) {
                        indexToPlay = h;
                        break;
                    }
                }
                if (indexToPlay != -1) {
                    player3.showPlayerCard(indexToPlay);
                    p3Card = player3.playerPlaceCard(indexToPlay);

                } else {
                    player3.showPlayerCard(0);
                    p3Card = player3.playerPlaceCard(0);

                }
                playedCards.add(p3Card);
                System.out.println("\n" + player3.getPlayerName() + " played: " + p3Card);

                //user turn
                int userCardPlayed = -1;
                Card pUserCard = null;
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


                Player turnWinner = game.turnWinner(playedCards, currentSuit, trumpSuit);
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
            trumpSuitPosition = (trumpSuitPosition + 1) % TOTAL_SUIT_LOOP;
        }
    }
}