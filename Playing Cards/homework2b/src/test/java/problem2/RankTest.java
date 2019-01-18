package problem2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tests to test the rank class
 * This tests the following
 *  - the rank creation and if the card created has the correct rank.
 *  - if the rank/pips value is right.(what rank you created with)
 *  - if name is the the same as what you defined
 *  - if the short name is the same as
 *
 * @author yatish
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RankTest {

    private  Rank rank;
    /**
     * declaring all the constants
     */
    private String nameOfCard = "AS";
    private  char shortNameOfCard = 'A' ;
    private  int cardRank = 1;

    /**
     * initialize the class object before testing
     */
    @BeforeEach
    void initClassObj(){
        rank = new Rank(shortNameOfCard, nameOfCard, cardRank);
    }

    /**
     * this tests the constructor of the Rank .
     * it checks if the Created rank has the same values we passed to the constructor
     */


    @Test
    void rankConstructorTest(){
        assertEquals(rank.getPips(), cardRank);
        assertEquals(rank.getName(), nameOfCard);
        assertEquals(rank.getShortName(), shortNameOfCard);

    }

    /**
     * this tests the getNameTest  method.
     * and if the method runs and returns the correct value
     */
    @Test
    void getNameTest() {
        assertEquals(rank.getName(), nameOfCard);
    }

    /**
     * this tests the getPipsTest  method.
     * and if the method runs and returns the correct value
     */
    @Test
    void getPipsTest() {
        assertEquals(rank.getPips(), cardRank);
    }

    /**
     * this tests the getShortNameTest  method.
     * and if the method runs and returns the correct value
     */
    @Test
    void getShortNameTest() {
        assertEquals(rank.getShortName(), shortNameOfCard);
    }
}