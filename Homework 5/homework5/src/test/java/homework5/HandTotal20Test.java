package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal20Test {
    private TestHelperClass testHelperClass;
    private HandTotal20 handTotal;
    private Hand hand1010;
    private Hand handA9;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal20.getInstance(testHelperClass.game);
        hand1010 = new Hand();
        handA9 = new Hand();


        hand1010.accept(testHelperClass.cardTen);
        hand1010.accept(testHelperClass.cardTen);

        handA9.accept(testHelperClass.cardAce);
        handA9.accept(testHelperClass.cardNine);

    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand1010;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(1, handTotal.handAction());
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