package problem2;

import java.util.List;

/**
 * Interface for the Deck class.
 *
 * @author yatish
 */
public interface DeckInterface {

    /**
     * this function is used to shuffle the cards in the deck
     */
    void shuffle();

    /**
     * this function is used to sort the deck of cards by either of the sort options.
     * @param sortBy - String - either "Rank" "Suit" "Both" - option to sort by.
     */
    void sort(String sortBy);

    /**
     * function which is used to cut a deck.
     * @param cutPoint - int - a integer  at which the deck will be cut
     */
    void cut(int cutPoint);

    /**
     * this function implements the "pull card" functionality returns the card at the top of the deck. and deletes the card from the deck.
     * @return - Card object -  a Card object.
     */
    Card pullCard();

    /**
     * this function is used to check if the deck is empty
     * @return - Boolean - true if a deck is empty else false
     */
    Boolean emptyDeck();

    /**
     * This function is used to return the original size of the deck when it was created
     * @return - int - the size of the deck after creation
     */
    int officialSize();

    /**
     * this function is used to return the deck
     * @return - List<Card> - a list of cards
     */
    List<Card> getCards();

}
