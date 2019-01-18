package problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Custom sort class for sorting functions.
 *
 * @author yatish
 */
public class SortUtils {

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
     * Private face values given to the cards.
     * used to give a specific weightage to the card to tell how the deck should be ordered.
     */
    private static final Map<Character, Integer> faceValueOfCards = new HashMap<Character, Integer>();
    static {
        faceValueOfCards.put('2', 2);
        faceValueOfCards.put('3', 3);
        faceValueOfCards.put('4', 4);
        faceValueOfCards.put('5', 5);
        faceValueOfCards.put('6', 6);
        faceValueOfCards.put('7', 7);
        faceValueOfCards.put('8', 8);
        faceValueOfCards.put('9', 9);
        faceValueOfCards.put('T', 10);
        faceValueOfCards.put('J', 11);
        faceValueOfCards.put('Q', 12);
        faceValueOfCards.put('K', 13);
        faceValueOfCards.put('A', 1);
    }

    /**
     * sort function which is used to tell what sort needs to be done on the cards.
     * @param sortBy - String - the type of sort that needs to be done i.e "Rank" , "Suit" , "Both"
     * @param listOfCards - List<Card> - the list of cards that needs to be sorted
     * @return - List<Card> - the sorted list.
     */
    public List<Card> sort(String sortBy, List<Card> listOfCards){

        if (sortBy.equals("Rank")){
            return this.sortByRank(listOfCards);
        }
        else if (sortBy.equals("Suit")){
            return this.sortBySuit(listOfCards);
        }
        else {
            return this.sortByBoth(listOfCards);
        }
    }


    /**
     * this function sorts the deck based on the rank of the card.
     * @param listOfCards - List<Card> - the list of cards that needs to be sorted
     * @return - List<Card> - the sorted list.
     */
    private List<Card> sortByRank(List<Card> listOfCards)
    {
        return sortOnFaceValue(listOfCards);
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
        listOfCards.addAll(sortOnFaceValue(spadeCards));
        listOfCards.addAll(sortOnFaceValue(dimondCards));
        listOfCards.addAll(sortOnFaceValue(heartCards));
        listOfCards.addAll(sortOnFaceValue(clubsCards));
        return listOfCards;
    }


    /**
     * this function sorts the deck based on the face Value of the card.
     * @param listOfCards - List<Card> - the list of cards that needs to be sorted
     * @return - List<Card> - the sorted list.
     */
    private List<Card> sortOnFaceValue(List<Card> listOfCards){
        int faceValueToComp;
        Card temp;
        int deckSize = listOfCards.size();
        for (int i = 0; i < deckSize; i++){
            faceValueToComp = i;
            for (int j = i+1; j < deckSize; j++){
                Card card1 = listOfCards.get(j);
                Card card2 = listOfCards.get(faceValueToComp);

                int faceValueofCard1 = faceValueOfCards.get(card1.getRank().getShortName());
                int faceValueofCard2 = faceValueOfCards.get(card2.getRank().getShortName());
                if (faceValueofCard1 < faceValueofCard2){
                    faceValueToComp = j;
                }
            }
            temp = listOfCards.get(i);
            listOfCards.set(i, listOfCards.get(faceValueToComp));
            listOfCards.set(faceValueToComp, temp);
        }
        return listOfCards;
    }
}
