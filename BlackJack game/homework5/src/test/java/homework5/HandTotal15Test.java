package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem2.Hand;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HandTotal15Test {
    private TestHelperClass testHelperClass;
    private HandTotal15 handTotal;
    private Hand hand78;
    private Hand hand96;
    private Hand handA4;

    @BeforeEach
    void init(){
        testHelperClass = new TestHelperClass();
        handTotal = HandTotal15.getInstance(testHelperClass.game);
        hand78 = new Hand();
        hand96 = new Hand();
        handA4 = new Hand();

        hand78.accept(testHelperClass.cardSeven);
        hand78.accept(testHelperClass.cardSeven);
        hand96.accept(testHelperClass.cardNine);
        hand96.accept(testHelperClass.cardSix);

        handA4.accept(testHelperClass.cardAce);
        handA4.accept(testHelperClass.cardFour);

    }

    @Test
    void handAction() throws NoSuchFieldException, IllegalAccessException {
        BlackjackGame game = BlackjackGame.getInstance(2,2);
        String dealerString = "dealer";
        Dealer dealer;
        game.currentHandBeingChecked = hand78;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != 1 && dealer.getFaceUpCard().getRank().getPips() >=7){
                if(dealer.getFaceUpCard().getRank().getPips() != 10)
                assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
        }

        game.currentHandBeingChecked = hand96;
        for (String s:testHelperClass.dealerFaceCardOP) {
            String dealerToGet = dealerString+s;
            Field d = testHelperClass.getClass().getDeclaredField(dealerToGet);
            d.setAccessible(true);
            dealer = (Dealer) d.get(testHelperClass);
            game.dealer = dealer;
            if (dealer.getFaceUpCard().getRank().getPips() != 1 && dealer.getFaceUpCard().getRank().getPips() >=7){
                if(dealer.getFaceUpCard().getRank().getPips() != 10)
                    assertEquals(2, handTotal.handAction());
            }
            else if (dealer.getFaceUpCard().getRank().getPips() !=1){
                assertEquals(1, handTotal.handAction());
            }
        }


        game.currentHandBeingChecked = handA4;

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