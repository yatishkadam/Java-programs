package problem1;

/**
 * Card class represents a playing Card. eg: Ace,King
 *
 * @author yatish
 */
public class Card implements CardInterface {


    private Rank rankOfCard;        // object - Rank - represents the Rank object of a card.
    private Suit suitOfCard;        // object - Suit - represents the Suit object of a card.


    /**
     * Constructor of a Card.
     * @param shortNameOfCard - char - a character representing a short name for a card eg k-king , A-ace , t- ten, 2 -two
     * @param cardRank - int - the rank of the card
     * @param cardSymbol - char - unicode chara representing the suits-"Spade" or "Dimond" or  "Club" or "Heart"
     */
    public Card(char shortNameOfCard, int cardRank, char cardSymbol){
        String cardName = shortNameOfCard + String.valueOf(cardSymbol);
        this.rankOfCard  = new Rank(shortNameOfCard, cardName, cardRank);
        this.suitOfCard = new Suit(cardName, cardSymbol);
    }

    /**
     * function to return the Rank object of a card
     * @return - object Rank - returns the rank object of the card.
     */
    public Rank getRank(){
        return this.rankOfCard;
    }

    /**
     * function to return the suit object of the Card
     * @return - object Suit - returns the suit object of the card
     */
    public Suit getSuit(){
        return this.suitOfCard;
    }


}
