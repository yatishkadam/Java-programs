package problem1;

/**
 * Interface for the suit class
 *
 * @author yatish
 */
public interface SuitInterface {

    /**
     * Function to get the name associated with the suit
     * @return - String - returns the name associated with the suit of the card.
     */
    public String getName();

    /**
     * Function to fetch the suit of the card.
     * @return - char - unicode representing the suit of the card.
     */
    public char getSymbol();
}
