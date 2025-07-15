public class Main {
    public static void main (String[] args) {
        System.out.println("Hello, world!");
        //initialize a deck object
        Deck deck = new Deck();

        //create a standard 52 card deck
        deck.createDeck();

        //display the deck
        deck.displayDeck();
    }
}