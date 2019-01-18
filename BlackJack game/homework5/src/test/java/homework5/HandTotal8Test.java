package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal8Test {
    private TestHelperClass testHelperClass;
    private HandTotal8 handTotal;
    private Hand hand62;
    private Hand hand44;
    private Hand handA7;
    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal8.getInstance(testHelperClass.game);
        hand62 = new Hand();
        hand44 = new Hand();
        handA7 = new Hand();

        hand62.accept(testHelperClass.cardTwo);
        hand62.accept(testHelperClass.cardSix);

        hand44.accept(testHelperClass.cardFour);
        hand44.accept(testHelperClass.cardFour);

        handA7.accept(testHelperClass.cardSeven);
        handA7.accept(testHelperClass.cardAce);
    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        int expectedDecision = 2;
        game.currentHandBeingChecked = hand62;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(expectedDecision, handTotal.handAction());
        }

        game.currentHandBeingChecked = hand44;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() == 5 || dealer.getFaceUpCard().getRank().getPips() == 6){
                assertEquals(3, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(expectedDecision, handTotal.handAction());
            }
        }

        game.currentHandBeingChecked = handA7;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() <= 8 && dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(expectedDecision, handTotal.handAction());
            }
        }
    }
}