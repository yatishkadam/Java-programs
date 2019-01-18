package problem2;

/**
 * This Represents the rank of a card.
 *
 * @author yatish
 */
public class Rank implements RankInterface {
    private String name;                // The name of the card associated with the rank
    private int rankOfCard;             // the rank of the card
    private char shortNameOfCard;      // String - Name of a card - eg A - ace, 2 - 2, k - king

    /**
     * Constructor for the Rank class
     * @param shortNameOfCard - Char - The short name for a card -eg. T-ten , k - king
     * @param name - String - Name of the card
     * @param rankOfCard - int - Rank of the card
     */
    Rank(char shortNameOfCard, String name, int rankOfCard){
        this.name = name;
        this.rankOfCard = rankOfCard;
        this.shortNameOfCard = shortNameOfCard;
    }

    /**
     * Function to return the name of the card associated with the rank
     * @return - String - returns the name of the card associated with the card
     */
    public String getName(){
        return this.name;
    }

    /**
     * Function to return the rank/ pip value of the card
     * @return - int - returns the rank/ pip value of the card
     */
    public int getPips(){
        return this.rankOfCard;
    }

    /**
     * Function to return the The short name for a card - eg. T-ten , k - king
     * @return - char - returns the The short name for a card - eg. T-ten , k - king
     */
    public char getShortName(){
        return this.shortNameOfCard;
    }
}
