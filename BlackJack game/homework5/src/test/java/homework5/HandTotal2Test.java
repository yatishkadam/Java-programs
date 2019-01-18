package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal2Test {

    private TestHelperClass testHelperClass;
    private HandTotal2 handTotal2;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal2 = HandTotal2.getInstance(testHelperClass.game);
    }

    /**
     * This is used to test all the possibilities of when you get to a state 2.
     * Thinking -
     *          for any of the face cards we get a value of 3; which means split in my implementation
     *          so we loop through and check for all combinations of A,A.
     */
    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        Dealer dealer;
        int expectedDecision = 3;//split
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = "dealer"+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            testHelperClass.game.dealer = dealer;
            assertEquals(expectedDecision, handTotal2.handAction());
        }
    }
}