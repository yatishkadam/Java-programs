package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is used to test the new Hand implementation
 */
class NewHandTest {
    private NewHandInterface hand;
    /**
     * declaring all the constants
     */
    private static final char SPADES ='\u2660';
    private static final char HEART = '\u2665';        // Heart suit
    private char shortNameOfCardForA = 'A' ;
    private int cardRankForAce = 1;
    private char cardSymbol = SPADES;

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
    private Card cardAce = new Card(shortNameOfCardForA, cardRankForAce, cardSymbol);
    private Card cardTen = new Card(shortNameOfCardForTen, cardRankForTen, cardSymbol);
    private Card cardTwo = new Card(shortNameOfCardForTwo, cardRankForTwo, cardSymbol);
    private Card cardFour = new Card(shortNameOfCardForFour, cardRankForFour, cardSymbol);
    private Card cardSix = new Card(shortNameOfCardForSix, cardRankForSix, cardSymbol);
    private Card cardAceHeart = new Card(shortNameOfCardForA, cardRankForAce, HEART);

    /**
     * Initializing a hand
     */
    @BeforeEach
    void makeHand(){
        hand = new NewHand();
        hand.accept(cardAce);
        hand.accept(cardFour);
        hand.accept(cardTen);
        hand.accept(cardAceHeart);
    }


    //This tests is used to test the number of times a card occurs in the hand
    @Test
    void occurrencesInHand() {
        int cardAceOccurence = 1;
        int cardFourOccurence = 1;
        assertEquals(cardAceOccurence, hand.occurrencesInHand(cardAce));
        assertEquals(cardFourOccurence, hand.occurrencesInHand(cardFour));
        assertEquals(0,hand.occurrencesInHand(cardSix));
    }

    //This tests is used to test the number of times a rank occurs in the hand
    @Test
    void occurencesInHand() {
        int aceRankOccurences = 2;
        int tenRankOccurences = 1;
        assertEquals(aceRankOccurences, hand.occurrencesInHand(cardAce.getRank()));
        assertEquals(tenRankOccurences, hand.occurrencesInHand(cardFour.getRank()));
        assertEquals(0,hand.occurrencesInHand(cardSix.getRank()));
    }

    //This is used to test the function has card in the NewHand class
    @Test
    void hasCard() {
        assertTrue(hand.hasCard(cardAce));
        assertFalse(hand.hasCard(cardSix));
    }
}