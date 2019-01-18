package problem1;

/**

 * Interface for a Card.
 *
 * @author yatish
 */
public interface CardInterface {

    /**
     * function to return the Rank object of a card
     * @return - object Rank - returns the rank object of the card.
     */
    public Rank getRank();

    /**
     * function to return the suit object of the Card
     * @return - object Suit - returns the suit object of the card
     */
    public Suit getSuit();
}
