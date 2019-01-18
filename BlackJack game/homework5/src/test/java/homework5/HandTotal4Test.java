package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal4Test {

    private TestHelperClass testHelperClass;
    private HandTotal4 handTotal;
    private Hand handPair22;
    private Hand handA3;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal4.getInstance(testHelperClass.game);
        handPair22 = new Hand();
        handA3 = new Hand();

        handPair22.accept(testHelperClass.cardTwo);
        handPair22.accept(testHelperClass.cardTwo);

        handA3.accept(testHelperClass.cardAce);
        handA3.accept(testHelperClass.cardThree);
    }

    /**
     * This is used to test all the possibilities of when you get to a state 3.
     * Thinking -
     *          for any of the face cards we get a value of 2; which means hit in my implementation
     *          so we loop through and check for all combinations of A,2.
     */
    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        game.currentHandBeingChecked = handA3;
        Dealer dealer;
        int expectedDecision = 2;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = "dealer"+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = handPair22;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = "dealer"+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() >= 8){
                assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() != 1)
                assertEquals(3, handTotal.handAction());

        }
    }
}