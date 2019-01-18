package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal7Test {

    private TestHelperClass testHelperClass;
    private HandTotal7 handTotal;
    private Hand hand61;
    private Hand hand34;
    private Hand handA6;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal7.getInstance(testHelperClass.game);
        hand61 = new Hand();
        hand34 = new Hand();
        handA6 = new Hand();

        hand61.accept(testHelperClass.cardAce);
        hand61.accept(testHelperClass.cardSix);

        hand34.accept(testHelperClass.cardFour);
        hand34.accept(testHelperClass.cardThree);

        handA6.accept(testHelperClass.cardAce);
        handA6.accept(testHelperClass.cardSix);
    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        int expectedDecision = 2;
        game.currentHandBeingChecked = hand34;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }
        game.currentHandBeingChecked = hand61;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }
        game.currentHandBeingChecked = handA6;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }
    }
}