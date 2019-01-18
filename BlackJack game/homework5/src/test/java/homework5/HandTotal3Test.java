package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal3Test {
    private TestHelperClass testHelperClass;
    private HandTotal3 handTotal3;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal3 = HandTotal3.getInstance(testHelperClass.game);
    }

    /**
     * This is used to test all the possibilities of when you get to a state 3.
     * Thinking -
     *          for any of the face cards we get a value of 2; which means hit in my implementation
     *          so we loop through and check for all combinations of A,2.
     */
    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        Dealer dealer;
        int expectedDecision = 2;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = "dealer"+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            testHelperClass.game.dealer = dealer;
            assertEquals(expectedDecision, handTotal3.handAction());
        }
    }
}