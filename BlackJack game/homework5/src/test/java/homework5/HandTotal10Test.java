package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal10Test {
    private TestHelperClass testHelperClass;
    private HandTotal10 handTotal;
    private Hand hand64;
    private Hand hand55;
    private Hand handA9;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal10.getInstance(testHelperClass.game);
        hand64 = new Hand();
        hand55 = new Hand();
        handA9 = new Hand();

        hand64.accept(testHelperClass.cardThree);
        hand64.accept(testHelperClass.cardSix);

        hand55.accept(testHelperClass.cardFour);
        hand55.accept(testHelperClass.cardFive);

        handA9.accept(testHelperClass.cardEight);
        handA9.accept(testHelperClass.cardAce);
    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        int expectedDecision = 2;
        game.currentHandBeingChecked = hand64;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = hand55;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = handA9;

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