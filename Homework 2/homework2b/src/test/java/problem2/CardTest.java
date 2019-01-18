package problem2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    private static final char SPADES ='\u2660';
    private char shortNameOfCard = 'A' ;
    private int cardRank = 1;
    private char cardSymbol = SPADES;

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

}