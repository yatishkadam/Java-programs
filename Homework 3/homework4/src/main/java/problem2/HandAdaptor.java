package problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This is an implementation of the card adaptor.
 * it uses the Shou provided and present the user the adapted hand.
 *
 * @author yatish
 */
public class HandAdaptor implements HandInterface {

    /**
     * logger variable to log
     */
    private final Logger logger = Logger.getLogger(Game.class.getName());

    /**
     * Unicode character declaration for the different suits.
     */
    private static final  char SPADES ='\u2660';        // Spades suit
    private static final  char HEART = '\u2665';        // Heart suit
    private static final  char DIMOND = '\u2666';       // Dimond suit
    private static final  char CLUB = '\u2663';         // Club suit
    /**
     * Suit Values
     * used to give a specific suit to the card.
     * //    xin, tieQiao, zuanShi, juLeBu; // hearts, spades, diamonds, clubs
     * //    the enum values in the ka class. So we map it to the values.
     */
    private static final Map<Character, Integer> suitValues = new HashMap<>();
    static {
        suitValues.put(SPADES   ,1);
        suitValues.put(HEART    ,0);
        suitValues.put(DIMOND   ,2);
        suitValues.put(CLUB     ,3);
    }


    /**
     * This is a shou
     */
    Shou hand;

    /**
     * Constructor of a HandAdaptor it initializes a new ShouShiXia
     */
    HandAdaptor(){
        this.hand = new ShouShiXia();
    }


    /**
     * this creates a kaShiXia.
     * @param card - CardAdaptor - whwhcih will be used to create the KA
     * @return - kaShiXia.
     */
    private Ka createKaCard(Card card){
        return new kaShiXia(card.getRank().getPips(), suitValues.get(card.getSuit().getSymbol()));
    }

    /**
     * function to return the present cards in the hand
     * @return - List<Card> - a list containing all the cards in the hand.
     */
    public List<Card> showCards(){
        List<Card> newHand = new ArrayList<>();
        if (hand instanceof ShouShiXia){
            ShouShiXia tempHand = (ShouShiXia)hand;
            for (Ka card:tempHand.showHand()) {
                newHand.add(new CardAdaptor(card));
            }
        }
        return newHand;
    }

    /**
     * this function adds the card to the hand.
     * @param card - Card object - the card to be added to the hand.
     */
    public void accept(Card card){
        hand.accept(this.createKaCard(card));
    }

    /**
     * function to pull a card from the hand.
     * @return - a Card
     */
     public Card pullCard(){
        return new CardAdaptor(hand.pullKa());
    }

    /**
     * check if the present hand has the particular card
     * @param card - Card object - card to check if in hand.
     * @return - Boolean - true is the card is present in the hand else false
     */
    public Boolean hasCard(Card card){
        return hand.hasKa(this.createKaCard(card));
    }

    /**
     * Sort function to sort the cards in the hand. based on the criteria
     * @param sortBy - String - criteria to sort on.
     */
    public void sort(String sortBy){
        if (sortBy.equals("Rank")){
            hand.sort();
        }
        else {
            sortByOther(sortBy);
        }
    }

    /**
     * This is used to sort when the sort by is "Suit" Or "Both"
     * @param sortBy - the Sort by "Both" "Suit"
     */
    private void sortByOther(String sortBy){
        List<Card> sortedHand;
        if (sortBy.equals("Suit")){
            sortedHand =  this.sortBySuit(this.getListOfCards());
        }
        else {
            sortedHand =  this.sortByBoth(this.getListOfCards());
        }
        pushAllCardToShou(sortedHand);
    }
    /**
     * this function sorts the deck based on the suit of the card.
     * @param listOfCards - List<Card> - the list of cards that needs to be sorted
     * @return - List<Card> - the sorted list.
     */
    private List<Card> sortBySuit(List<Card> listOfCards){
        List<Card> spadeCards = new ArrayList<Card>();
        List<Card> dimondCards= new ArrayList<Card>();
        List<Card> heartCards= new ArrayList<Card>();
        List<Card> clubsCards= new ArrayList<Card>();

        for (Card card:listOfCards) {
            char suit = card.getSuit().getSymbol();
            switch (suit){
                case SPADES:
                    spadeCards.add(card);
                    break;
                case HEART:
                    heartCards.add(card);
                    break;
                case DIMOND:
                    dimondCards.add(card);
                    break;
                case CLUB:
                    clubsCards.add(card);
                    break;
                default:
                    logger.info("Sort by suit \nSuite not found while sorting.");
                    break;
            }
        }
        listOfCards.clear();
        listOfCards.addAll(spadeCards);
        listOfCards.addAll(dimondCards);
        listOfCards.addAll(heartCards);
        listOfCards.addAll(clubsCards);
        return listOfCards;
    }

    /**
     * this function sorts the deck based on the rank and the suit of the card.
     * @param listOfCards - List<Card> - the list of cards that needs to be sorted
     * @return - List<Card> - the sorted list.
     */
    private List<Card> sortByBoth(List<Card> listOfCards){
        List<Card> spadeCards = new ArrayList<Card>();
        List<Card> dimondCards= new ArrayList<Card>();
        List<Card> heartCards= new ArrayList<Card>();
        List<Card> clubsCards= new ArrayList<Card>();

        for (Card card:listOfCards) {
            char suit = card.getSuit().getSymbol();
            switch (suit){
                case SPADES:
                    spadeCards.add(card);
                    break;
                case HEART:
                    heartCards.add(card);
                    break;
                case DIMOND:
                    dimondCards.add(card);
                    break;
                case CLUB:
                    clubsCards.add(card);
                    break;
                default:
                    logger.info("Sort by suit \nSuite not found while sorting.");
                    break;
            }
        }
        listOfCards.clear();
        //Sort the spades based on rank
        if(spadeCards.size() > 0){
            pushAllCardToShou(spadeCards);
            hand.sort();
            spadeCards.clear();
            spadeCards = getListOfCards();
        }


        //Sort the spades based on dimondCards
        if(dimondCards.size() > 0) {
            pushAllCardToShou(dimondCards);
            hand.sort();
            dimondCards.clear();
            dimondCards = getListOfCards();
        }

        //Sort the spades based on heartCards
        if(heartCards.size() > 0) {
            pushAllCardToShou(heartCards);
            hand.sort();
            heartCards.clear();
            heartCards = getListOfCards();
        }

        //Sort the spades based on clubsCards
        if(clubsCards.size() > 0) {
            pushAllCardToShou(clubsCards);
            hand.sort();
            clubsCards.clear();
            clubsCards = getListOfCards();
        }


        listOfCards.addAll(spadeCards);
        listOfCards.addAll(dimondCards);
        listOfCards.addAll(heartCards);
        listOfCards.addAll(clubsCards);
        return listOfCards;
    }

    /**
     * This function is used to get the list of cards.
     * @return - List<Card> - list of cards
     */
    private List<Card> getListOfCards(){
        List<Card> listOfCard = new ArrayList<>(showCards());
        if (hand instanceof ShouShiXia){
            ShouShiXia tempHand = (ShouShiXia)hand;
            while (((ShouShiXia) hand).getHandSize() >0){

                hand.pullKa();
            }
        }
        return listOfCard;
    }

    /**
     * This card pushes the sorted cards to the hand.
     * @param sortedHand - the sorted hand that needs to be pushed to the hand.
     */
    private void pushAllCardToShou(List<Card> sortedHand){
        for(int index = 0; index < sortedHand.size();index++){
            hand.accept(this.createKaCard(sortedHand.get(index)));
        }
    }

    /**
     * this function suffles all the cards in the hand.
     */
    public void shuffle(){
        if (hand instanceof ShouShiXia){
            ShouShiXia tempHand = (ShouShiXia)hand;
            tempHand.shuffle();
        }
    }

}
