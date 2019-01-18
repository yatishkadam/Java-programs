package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal18Test {
    private TestHelperClass testHelperClass;
    private HandTotal18 handTotal;
    private Hand hand108;
    private Hand hand99;
    private Hand handA7;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal18.getInstance(testHelperClass.game);
        hand108 = new Hand();
        handA7 = new Hand();
        hand99 = new Hand();

        hand108.accept(testHelperClass.cardEight);
        hand108.accept(testHelperClass.cardTen);

        hand99.accept(testHelperClass.cardNine);
        hand99.accept(testHelperClass.cardNine);

        handA7.accept(testHelperClass.cardAce);
        handA7.accept(testHelperClass.cardSeven);

    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand108;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            assertEquals(1, handTotal.handAction());
        }

        game.currentHandBeingChecked = handA7;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != 1 && dealer.getFaceUpCard().getRank().getPips() <= 8){
                    assertEquals(1, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(2, handTotal.handAction());
            }
        }


        game.currentHandBeingChecked = hand99;

        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() == 7 || dealer.getFaceUpCard().getRank().getPips() ==10 || dealer.getFaceUpCard().getRank().getPips() ==11){
                assertEquals(1, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(3, handTotal.handAction());
            }
        }
    }
}