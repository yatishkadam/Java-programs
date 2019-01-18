package problem2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests to test the card class
 * This tests the following
 *  - the card creation and if the card created is the correct card.
 *  - if the rank is right.(what rank you created with)
 *  - if the suit is right.(what suit you created the card with)
 *
 * @author yatish
 */
class CardTest {

    /**
     * declaring all the constants
     */
    /**
     * Unicode character declaration for the different suits.
     */
    private static final  char SPADES ='\u2660';        // Spades suit
    private static final  char HEART = '\u2665';        // Heart suit
    private static final  char DIMOND = '\u2666';       // Dimond suit
    private static final  char CLUB = '\u2663';         // Club suit
    private char shortNameOfCard = 'A' ;
    private int cardRank = 1;
    private char cardSymbol = SPADES;

    /**
     * This is a hard map variable which tells what kind of cards are present in this deck type.
     */
    private static Map<Character, Integer> deckCards = new HashMap<Character, Integer>();
    static {
        deckCards.put('2',5);
        deckCards.put('3',9);
        deckCards.put('4',13);
        deckCards.put('5',4);
        deckCards.put('6',8);
        deckCards.put('7',12);
        deckCards.put('8',3);
        deckCards.put('9',7);
        deckCards.put('T',11);
        deckCards.put('J',2);
        deckCards.put('Q',6);
        deckCards.put('K',10);
        deckCards.put('A',1);
    }
    /**
     * A List of the standard suits.
     */
    List<Character> standardSuits = Arrays.asList(SPADES,HEART,DIMOND,CLUB);
    // Card
    private Card card;

    /**
     * initialize the class object before testing
     */
    @BeforeEach
    void initClassObj(){
        card = new Card(shortNameOfCard, cardRank, cardSymbol);
    }

    /**
     * this is to test the creation of a card.
     * checks if the card created is the right card with the same values as you passed.
     */
    @Test
    void cardConstructorTest(){
        assertEquals(card.getRank().getPips(),cardRank);
        assertEquals(card.getSuit().getSymbol(), cardSymbol);
        assertEquals(card.getRank().getShortName(),shortNameOfCard);
    }

    /**
     * this is to test the rank of the card.
     * it tests if the card holds the same rank as if was created with.
     * and if the method runs and returns the correct value
     */
    @Test
    void cardRankTest(){
        assertEquals(card.getRank().getPips(),cardRank);

    }

    /**
     * this is to test the suit of the card.
     * it tests if the card is the same suit as if was created with.
     * and if the method runs and returns the correct value
     */
    @Test
    void cardSuitTest(){
        assertEquals(card.getSuit().getSymbol(), cardSymbol);
    }

    /**
     * Checking for all 52 cards
     * I am creating a card and checking if the created card has the right variables that were supplied to it.
     */
    @Test
    void testAllCards(){
        for (char suit:standardSuits) {
            for (Map.Entry<Character, Integer> item:deckCards.entrySet()) {
                int rank = item.getValue();
                Card card = new Card(item.getKey(),rank,suit);
                assertEquals(card.getSuit().getSymbol(), suit);
                assertEquals(card.getRank().getPips(),rank);
            }
        }
    }
}