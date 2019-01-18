package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal17Test {
    private TestHelperClass testHelperClass;
    private HandTotal17 handTotal;
    private Hand hand107;
    private Hand hand98;
    private Hand handA6;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal17.getInstance(testHelperClass.game);
        hand107 = new Hand();
        hand98 = new Hand();
        handA6 = new Hand();

        hand107.accept(testHelperClass.cardTen);
        hand107.accept(testHelperClass.cardSeven);

        hand98.accept(testHelperClass.cardNine);
        hand98.accept(testHelperClass.cardEight);

        handA6.accept(testHelperClass.cardAce);
        handA6.accept(testHelperClass.cardSix);

    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand107;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(1, handTotal.handAction());

        }

        game.currentHandBeingChecked = hand98;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(1, handTotal.handAction());

        }

        game.currentHandBeingChecked = handA6;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(2, handTotal.handAction());

        }
    }
}