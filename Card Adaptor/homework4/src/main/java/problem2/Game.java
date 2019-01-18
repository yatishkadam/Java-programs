package problem2;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The Game class represents a game.
 *
 * @author yatish
 */
public class Game implements GameInterface {

    /**
     * LOGGER variable to log
     */
    private static final  Logger LOGGER = Logger.getLogger(Game.class.getName());

    /**
     * The Deck object to hold the deck the game will be using
     */
    Deck deck;
    /**
     * This variable honds all the hand instances.
     */
    List<Hand> listOfHands = new ArrayList<Hand>();

    /**
     * the number of hands in the game
     */
    private int numberOfHands = 0;
    /**
     * the number of cards for each hand
     */
    private int numberOfCardsEachHand;

    /**
     * Constuctor for Game
     * @param numOfCardsEachHand - int - the number cards each hand will get.
     */
    Game(int numOfCardsEachHand){
        this.numberOfCardsEachHand = numOfCardsEachHand;
    }

    /**
     * This function is used ot create the deck to be used for the game.
     * @param deckType - String - "Vegas", "Standard", "Pinochle", or "Euchre"
     */
    public void createDeck(String deckType){
        deck = DeckFactory.createDeck(deckType);
    }

    /**
     * This function is used ot create the vegas deck to be used for the game.
     * @param deckType - String - "Vegas".
     * @param numberOfDecks - int - number of standard decks the vegas deck will contain.
     */
    public void createDeck(String deckType, int numberOfDecks){
        deck = DeckFactory.createDeck(deckType, numberOfDecks);
    }

    /**
     * function to set the number of hands for each game
     * @param numberOfHands - int - the number of hands for the game.
     */
    public void setNumberOfHands(int numberOfHands) {
        this.numberOfHands = numberOfHands;
        for (int handIndex = 0;handIndex<numberOfHands;handIndex++){
            Hand hand = new Hand();
            this.listOfHands.add(hand);
        }
    }

    /**
     * function to deal the cards to the hands.
     */
    public void deal(){
        if (numberOfHands == 0){
            LOGGER.info("There needs to be more than 0 hands");
            return;
        }
        Hand tempHand;
        for (int cycle = 0; cycle < this.numberOfCardsEachHand; cycle++){
            for (int handIndex = 0; handIndex < this.numberOfHands; handIndex++){
                tempHand = this.listOfHands.get(handIndex);
                tempHand.accept(this.deck.pullCard());
            }
        }
    }



}
