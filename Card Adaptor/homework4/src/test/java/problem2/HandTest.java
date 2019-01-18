package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class is to test the Hand class
 */
class HandTest {


    private HandInterface hand;
    /**
     * Unicode character declaration for the different suits.
     */
    private static final  char SPADES ='\u2660';        // Spades suit
    private static final  char HEART = '\u2665';        // Heart suit
    private static final  char DIMOND = '\u2666';       // Dimond suit
    private static final  char CLUB = '\u2663';         // Club suit


    private char shortNameOfCardForA = 'A' ;
    private int cardRankForAce = 1;
    private char cardSymbol = SPADES;

    /**
     * Suit Values
     * used to give a specific suit to the card.
     * //    xin, tieQiao, zuanShi, juLeBu; // hearts, spades, diamonds, clubs
     * //    the enum values in the ka class. So we map it to the values.
     */
    private static final Map<Character, Integer> suitValues = new HashMap<>();
    static {
        suitValues.put(SPADES   ,2);
        suitValues.put(HEART    ,1);
        suitValues.put(DIMOND   ,3);
        suitValues.put(CLUB     ,4);
    }

    /**
     * declaring all the constants
     */
    private char shortNameOfCardForTen = 'T' ;
    private int cardRankForTen = 10;


    /**
     * declaring all the constants
     */
    private char shortNameOfCardForTwo = '2' ;
    private int cardRankForTwo = 2;

    /**
     * declaring all the constants
     */
    private char shortNameOfCardForFour = '4' ;
    private int cardRankForFour = 4;

    /**
     * declaring all the constants
     */
    private char shortNameOfCardForSix = '6' ;
    private int cardRankForSix = 6;

    /**
     * Creating new cards
     */
    private Card cardAce =  new CardAdaptor(shortNameOfCardForA,cardRankForAce,cardSymbol);
    private Card cardTen =  new CardAdaptor(shortNameOfCardForTen,cardRankForTen,cardSymbol);
    private Card cardTwo =  new CardAdaptor(shortNameOfCardForTwo, cardRankForTwo, cardSymbol);
    private Card cardFour = new CardAdaptor(shortNameOfCardForFour, cardRankForFour, cardSymbol);
    private Card cardSix =  new CardAdaptor(shortNameOfCardForSix, cardRankForSix, cardSymbol);
    private Card cardAceHeart = new CardAdaptor(shortNameOfCardForA, cardRankForAce, HEART);

    /**
     * Initializing a hand
     */
    @BeforeEach
    void makeHand(){
        hand = new HandAdaptor();
        hand.accept(cardAce);
        hand.accept(cardFour);
        hand.accept(cardTen);
    }

    /**
     * This tests the show cards method
     * we create a list of cards that we gave to the hand.
     * Then check this list of cards the same cards as what the hand recieved
     */
    @Test
    void showCards() {
        List<Card> listOfCardsToCheckAgainst = new ArrayList<>();
        listOfCardsToCheckAgainst.add(cardAce);
        listOfCardsToCheckAgainst.add(cardFour);
        listOfCardsToCheckAgainst.add(cardTen);

        for (int i = 0; i < hand.showCards().size(); i++) {
            Card card = listOfCardsToCheckAgainst.get(i);
            Card cardInList = hand.showCards().get(i);
            assertEquals(card.getRank().getPips(),cardInList.getRank().getPips());
            assertEquals(card.getSuit().getSymbol(), cardInList.getSuit().getSymbol());
        }
    }

    /**
     * This Tests the accept method of a hand.
     * it accepts a card.
     * thinking -> first check if the card we are suppllying is not present in the deck.
     *             supply the card to the hand.
     *             then check if the card is in the hand.
     */
    @Test
    void accept() {
        assertFalse(hand.showCards().contains(cardTwo));

        hand.accept(cardTwo);

        assertTrue(hand.hasCard(cardTwo));
    }

    /**
     * this is to test the sort functionality of the hand
     * we add a heart card to the hand
     * and then perform the needed sort.
     * and check against the a expected list order we define
     */
    @Test
    void sortBySuit(){
        /**
         * we know that there are three cards in the hand(All of spades).
         * we add a card AceOfHeats to the hand.
         * then sort it nand check te order
         */
        List<Character> suitOrder = new ArrayList<Character>();
        suitOrder.add(SPADES);
        suitOrder.add(SPADES);
        suitOrder.add(SPADES);
        suitOrder.add(HEART);
        hand.accept(cardAceHeart);

        hand.sort("Suit");
        List<Card> presentHandCards = hand.showCards();

        char suitToCheck;
        char cardSuit;

        for (int i =0;i< presentHandCards.size();i++){
            cardSuit = presentHandCards.get(i).getSuit().getSymbol();
            suitToCheck = suitOrder.get(i);
            assertEquals(cardSuit, suitToCheck);
        }

    }

    /**
     * this is to test the sort functionality of the hand
     * we add a heart card to the hand
     * and then perform the needed sort.
     * and check against the a expected list order we define
     */
    @Test
    void sortByBoth(){
        /**
         * we know that there are three cards in the hand(All of spades).
         * we add a card AceOfHeats to the hand.
         * then sort it nand check te order
         */
        List<Integer> rankOrder = new ArrayList<>();
        rankOrder.add(cardAce.getRank().getPips());
        rankOrder.add(cardFour.getRank().getPips());
        rankOrder.add(cardTen.getRank().getPips());
        rankOrder.add(cardAce.getRank().getPips());

        List<Character> suitOrder = new ArrayList<Character>();
        suitOrder.add(SPADES);
        suitOrder.add(SPADES);
        suitOrder.add(SPADES);
        suitOrder.add(HEART);


        hand.accept(cardAceHeart);

        hand.sort("Both");
        List<Card> presentHandCards = hand.showCards();

        int rankToCheck;
        char suitToCheck;
        char cardSuit;
        int cardrankOrder;

        for (int i =0;i< presentHandCards.size();i++){
            cardrankOrder = presentHandCards.get(i).getRank().getPips();
            cardSuit = presentHandCards.get(i).getSuit().getSymbol();

            rankToCheck = rankOrder.get(i);
            suitToCheck = suitOrder.get(i);

            assertEquals(cardrankOrder, rankToCheck);
            assertEquals(cardSuit,suitToCheck);
        }

    }

    /**
     * this is to test the sort functionality of the hand
     * we add a heart card to the hand
     * and then perform the needed sort.
     * and check against the a expected list order we define
     */
    @Test
    void sortByRank(){
        /**
         * we know that there are three cards in the hand(All of spades).
         * we add a card AceOfHeats to the hand.
         * then sort it nand check te order
         */
        List<Integer> rankOrder = new ArrayList<>();
        rankOrder.add(cardAce.getRank().getPips());
        rankOrder.add(cardAce.getRank().getPips());
        rankOrder.add(cardFour.getRank().getPips());
        rankOrder.add(cardTen.getRank().getPips());


        hand.accept(cardAceHeart);

        hand.sort("Rank");
        List<Card> presentHandCards = hand.showCards();

        int rankToCheck;
        int cardrank;

        for (int i =0; i< presentHandCards.size(); i++){
            cardrank = presentHandCards.get(i).getRank().getPips();
            rankToCheck = rankOrder.get(i);
            assertEquals(cardrank, rankToCheck);
        }

    }

    /**
     * check if the card is in the hand.
     * thinking ->
     *              lets consider that we always pull the card from the front. (index 0)
     *              make a copy of the card
     *              check if its present. (returns true)
     *              then pull the card
     *              now again check if the pulled card is present in the deck (should return
     */
    @Test
    void pullCard() {
        Card cardToCheck = hand.showCards().get(0);
        assertTrue(hand.showCards().contains(cardToCheck));

        hand.pullCard();

        assertFalse(hand.showCards().contains(cardToCheck));
    }

    /**
     * check if a card has a card that was supplied to it.
     * and also check a card that was not supplied to it.
     */
    @Test
    void hasCard() {
        assertFalse(hand.showCards().contains(cardSix));
        assertTrue(hand.showCards().contains(cardAce));
    }


    /**
     * this tests the shuffle method for a deck
     * Thinking ->
     *            make two copies of the deck.
     *            check first if they are same.( Which will be true).
     *            shuffle the deck using the shuffle method.
     *            check if they are not the same. ( checking if they are the same will throw an error cause they wont be of the same order)
     */
    @Test
    void shuffle() {
        List<Card> unshuffledListOfCards = new ArrayList<>(hand.showCards());
        assertEquals(unshuffledListOfCards,hand.showCards());
        hand.shuffle();
        assertNotEquals(unshuffledListOfCards, hand.showCards());
    }



    /**
     * @param renHeKa a card
     * @return if the hand contains the card, returns the position of that card within the
     *         hand. -1 means card was not found.
     */
    private int contains(Ka renHeKa) {

        for (int i = 0; i < hand.showCards().size(); i++) {
            if (renHeKa.equals(hand.showCards().get(i))) {
                return i;
            }
        }
        return -1; // card not found
    }
}