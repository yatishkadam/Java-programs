package problem1;


/**
 * This is a factory method to the deck class.
 * The Game class uses this to create the deck it requires.
 *
 * @author yatish
 */
public class DeckFactory {

    /**
     * This function is used ot create the deck to be used for the game.
     * @param deckType - String - "Vegas", "Standard", "Pinochle", or "Euchre"
     *
     * @return - Deck - A deck object
     */
    public static Deck createDeck(String deckType){
        int standardVegasDeckSize = 6;

        if ("Standard".equalsIgnoreCase(deckType)) return new Standard();
        else if ("Euchre".equalsIgnoreCase(deckType)) return new Euchre();
        else if ("Pinochle".equalsIgnoreCase(deckType)) return new Pinochle();
        else if ("Vegas".equalsIgnoreCase(deckType)) return new Vegas(standardVegasDeckSize);
        return null;
    }

    /**
     * This function is used ot create the vegas deck to be used for the game.
     * @param deckType - String - "Vegas".
     * @param numberOfDecks - int - number of standard decks the vegas deck will contain.
     *
     * @return - Deck - A deck object
     */
    public static Deck createDeck(String deckType, int numberOfDecks){
        if ("Vegas".equalsIgnoreCase(deckType)) return new Vegas(numberOfDecks);
        else return null;
    }

}
