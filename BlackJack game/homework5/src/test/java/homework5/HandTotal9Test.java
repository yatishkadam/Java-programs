package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal9Test {
    private TestHelperClass testHelperClass;
    private HandTotal9 handTotal;
    private Hand hand63;
    private Hand hand54;
    private Hand handA8;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal9.getInstance(testHelperClass.game);
        hand63 = new Hand();
        hand54 = new Hand();
        handA8 = new Hand();

        hand63.accept(testHelperClass.cardThree);
        hand63.accept(testHelperClass.cardSix);

        hand54.accept(testHelperClass.cardFour);
        hand54.accept(testHelperClass.cardFive);

        handA8.accept(testHelperClass.cardEight);
        handA8.accept(testHelperClass.cardAce);
    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        int expectedDecision = 2;
        game.currentHandBeingChecked = hand63;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = hand54;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = handA8;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(1, handTotal.handAction());
        }
    }
}