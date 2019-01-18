package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal19Test {
    private TestHelperClass testHelperClass;
    private HandTotal19 handTotal;
    private Hand hand109;
    private Hand handA8;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal19.getInstance(testHelperClass.game);
        hand109 = new Hand();
        handA8 = new Hand();


        hand109.accept(testHelperClass.cardNine);
        hand109.accept(testHelperClass.cardTen);

        handA8.accept(testHelperClass.cardAce);
        handA8.accept(testHelperClass.cardEight);

    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand109;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(1, handTotal.handAction());
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