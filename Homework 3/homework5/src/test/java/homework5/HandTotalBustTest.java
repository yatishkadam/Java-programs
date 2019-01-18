package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotalBustTest {
    private TestHelperClass testHelperClass;
    private HandTotalBust handTotal;
    private Hand handA10102;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotalBust.getInstance(testHelperClass.game);
        handA10102 = new Hand();
        handA10102.accept(testHelperClass.cardAce);
        handA10102.accept(testHelperClass.cardTen);
        handA10102.accept(testHelperClass.cardTen);
        handA10102.accept(testHelperClass.cardTwo);
    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = handA10102;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(-1, handTotal.handAction());
        }
    }

}