package problem2;

import java.util.List;

/**
 * This is the interface for the Hand class
 *
 * @author yatish
 */
public interface HandInterface {
    /**
     * function to return the present cards in the hand
     * @return - List<Card> - a list containing all the cards in the hand.
     */
    List<Card> showCards();

    /**
     * this function adds the card to the hand.
     * @param card - Card object - the card to be added to the hand.
     */
    void accept(Card card);

    /**
     * function to pull a card from the hand.
     * @return - a Card
     */
    Card pullCard();

    /**
     * check if the present hand has the particular card
     * @param card - Card object - card to check if in hand.
     * @return - Boolean - true is the card is present in the hand else false
     */
    Boolean hasCard(Card card);

    /**
     * Sort function to sort the cards in the hand. based on the criteria
     * @param sortBy - String - criteria to sort on.
     */
    void sort(String sortBy);

    /**
     * this function suffles all the cards in the hand.
     */
    void shuffle();

}
