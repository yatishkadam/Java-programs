package problem1;

import java.util.*;

/*
 * Deck class to represent a deck.
 *
 * @author yatish
 */
public class Deck implements DeckInterface{

    /**
     * Unicode character declaration for the different suits.
     */
    private static final  char SPADES ='\u2660';        // Spades suit
    private static final  char HEART = '\u2665';        // Heart suit
    private static final  char DIMOND = '\u2666';       // Dimond suit
    private static final  char CLUB = '\u2663';         // Club suit


    /**
     * A List of the standard suits.
     */
    List<Character>standardSuits = Arrays.asList(SPADES,HEART,DIMOND,CLUB);
    /**
     * A list<card> contains all the card objects
     */
    List<Card> deckOfCards = new ArrayList<Card>();
    /**
     * The original size of the deck
     */
    int originalSizeOfDeck ;


    /**
     * Deck constructor
     */
    Deck(){
        //Does nothing because it is just a base class declaration
    }

    /**
     * Function that creates a deck
     * Will be over writtern in each class which inherits it
     */
    public void createDeck(){
        //Does nothing because it will be overridden in the child classes.
    }

    /**
     * This function is used to return the original size of the deck when it was created
     * @return - int - the size of the deck after creation
     */
    public int officialSize()
    {
        return this.originalSizeOfDeck;
    }

    /**
     * this function is used to return the deck
     * @return - List<Card> - a list of cards
     */
    public List<Card> getCards()
    {
        return this.deckOfCards;
    }

    /**
     * this function is used to shuffle the cards in the deck
     */
    public void shuffle(){
       Collections.shuffle(this.deckOfCards);
    }

    /**
     * this function is used to sort the deck of cards by either of the sort options.
     * @param sortBy - String - either "Rank" "Suit" "Both" - option to sort by.
     */
    public void sort(String sortBy){
        SortUtils sortClassObj = new SortUtils();
        this.deckOfCards = sortClassObj.sort(sortBy, this.deckOfCards);
    }

    /**
     * function which is used to cut a deck.
     * @param cutPoint - int - a integer  at which the deck will be cut
     */
    public void cut(int cutPoint) {
        if (cutPoint > deckOfCards.size()){
            return;
        }
        List<Card> cutList;
        cutList = new ArrayList<Card>(deckOfCards.subList(0,cutPoint));
        deckOfCards.subList(0,cutPoint).clear();
        deckOfCards.addAll(cutList);
    }

    /**
     * this function implements the "pull card" functionality returns the card at the top of the deck. and deletes the card from the deck.
     * @return - Card object -  a Card object.
     */
    public Card pullCard(){
        Card cardPulled =  this.deckOfCards.get(0);
        this.deckOfCards.remove(0);
        return cardPulled;
    }

    /**
     * this function is used to check if the deck is empty
     * @return - Boolean - true if a deck is empty else false
     */
    public Boolean emptyDeck(){
        return this.deckOfCards.isEmpty();
    }


}
