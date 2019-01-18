package problem2;

/**
 * This Represents the suit of a card.
 *
 * @author yatish
 */
public class Suit implements SuitInterface {
    private String name; // The name of the card associated with the suit
    private char symbol; // Suit represented as a unicode char.

    /**
     * Constructor for Suit
     * @param name - String - the name of the card associated with the suit
     * @param symbol - unicode char - representing the suit of the card.
     */
    Suit(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Function to get the name associated with the suit
     * @return - String - returns the name associated with the suit of the card.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Function to fetch the suit of the card.
     * @return - char - unicode representing the suit of the card.
     */
    public char getSymbol(){
        return this.symbol;
    }

}
