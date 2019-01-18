package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to represent a hand
 *
 * @author yatish
 */
public class Hand{

    /**
     * A list to hold all the cards in the hand.
     */
    private List<Card> presentHand = new ArrayList<Card>();

    /**
     * Hand constructor
     */
    Hand(){ }

    /**
     * function to return the present cards in the hand
     * @return - List<Card> - a list containing all the cards in the hand.
     */
    public List<Card> showCards(){
        return this.presentHand;
    }

    /**
     * this function adds the card to the hand.
     * @param card - Card object - the card to be added to the hand.
     */
    public void accept(Card card) {
        this.presentHand.add(card);
    }


    /**
     * function to pull a card from the hand.
     * @return - a Card
     */
    public Card pullCard() {
        Card cardPulled =  this.presentHand.get(0);
        this.presentHand.remove(0);
        return cardPulled;
    }

    /**
     * check if the present hand has the particular card
     * @param card - Card object - card to check if in hand.
     * @return - Boolean - true is the card is present in the hand else false
     */
    public Boolean hasCard(Card card){
        return this.presentHand.contains(card);
    }

    /**
     * Sort function to sort the cards in the hand. based on the criteria
     * @param sortBy - String - criteria to sort on.
     */
    public void sort(String sortBy){
        SortUtils sortClassObj = new SortUtils();
        this.presentHand = sortClassObj.sort(sortBy, this.presentHand);
    }


    /**
     * this function suffles all the cards in the hand.
     */
    public void shuffle(){
        Collections.shuffle(this.presentHand);
    }
}
