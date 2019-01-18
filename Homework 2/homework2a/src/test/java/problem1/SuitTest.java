package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to test the Suit class
 * This tests the following
 *  - the Suit creation and if the card created has the correct Suit.
 *  - if the Suit value is right.(what Suit you created with)
 *  - if name is the the same as what you defined
 *
 * @author yatish
 */
class SuitTest {

    /**
     * declaring all the constants
     */
    private static final char SPADES ='\u2660';
    private String nameOfCard = "AS";

    private char cardSymbol = SPADES;
    private Suit suit;

    /**
     * initialize the class object before testing
     */
    @BeforeEach
    void initClassObj(){
        suit = new Suit(nameOfCard, cardSymbol);
    }

    /**
     * this tests the constructor of the Rank .
     * it checks if the Created rank has the same values we passed to the constructor
     */
    @Test
    void rankConstructorTest(){
        assertEquals(suit.getName(), nameOfCard);
        assertEquals(suit.getSymbol(), cardSymbol);

    }

    /**
     * this tests the getName  method.
     * and if the method runs and returns the correct value
     */
    @Test
    void getName() {
        assertEquals(suit.getName(), nameOfCard);
    }

    /**
     * this tests the getSymbol  method.
     * and if the method runs and returns the correct value
     */
    @Test
    void getSymbol() {
        assertEquals(suit.getSymbol(), cardSymbol);
    }
}