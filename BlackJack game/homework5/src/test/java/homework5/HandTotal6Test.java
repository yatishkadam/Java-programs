package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal6Test {

    private TestHelperClass testHelperClass;
    private HandTotal6 handTotal;
    private Hand handPair33;
    private Hand handA5;
    private Hand hand42;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal6.getInstance(testHelperClass.game);


        handPair33 = new Hand();
        handA5 = new Hand();
        hand42 = new Hand();
        handPair33.accept(testHelperClass.cardThree);
        handPair33.accept(testHelperClass.cardThree);

        handA5.accept(testHelperClass.cardAce);
        handA5.accept(testHelperClass.cardFive);

        hand42.accept(testHelperClass.cardFour);
        hand42.accept(testHelperClass.cardTwo);

    }

    /**
     * This is used to test all the possibilities of when you get to a state 6.
     * possibilities 3,3   , A,5   , 4,2
     */
    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        game.currentHandBeingChecked = hand42;
        Dealer dealer;
        int expectedDecision = 2;//hit
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = "dealer"+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = handA5;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = "dealer"+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = handPair33;
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