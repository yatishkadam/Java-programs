package problem2;


/**
 * The Interface for the game class
 *  To constuct a game you will need to pass(constuctor arguement) the number of cards to be delt to each of the hands.
 * @author yatish
 */
public interface GameInterface {

    /**
     * This function is used ot create the deck to be used for the game.
     * @param deckType - String - "Vegas", "Standard", "Pinochle", or "Euchre"
     */
    void createDeck(String deckType);

    /**
     * This function is used ot create the vegas deck to be used for the game.
     * @param deckType - String - "Vegas".
     * @param numberOfDecks - int - number of standard decks the vegas deck will contain.
     */
    void createDeck(String deckType, int numberOfDecks);

    /**
     * function to set the number of hands for each game
     * @param numberOfHands - int - the number of hands for the game.
     */
    void setNumberOfHands(int numberOfHands);

    /**
     * function to deal the cards to the hands.
     */
    void deal();

}
